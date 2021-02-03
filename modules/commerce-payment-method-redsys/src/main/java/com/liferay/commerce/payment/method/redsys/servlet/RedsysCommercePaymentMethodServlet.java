package com.liferay.commerce.payment.method.redsys.servlet;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.payment.engine.CommercePaymentEngine;
import com.liferay.commerce.payment.engine.CommerceSubscriptionEngine;
import com.liferay.commerce.payment.method.redsys.configuration.RedsysPaymentMethodCardGroupServiceConfiguration;
import com.liferay.commerce.payment.method.redsys.constants.RedsysCommercePaymentMethodConstants;
import com.liferay.commerce.payment.method.redsys.constants.RedsysTypeOfTransaction;
import com.liferay.commerce.service.CommerceOrderService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import sis.redsys.api.ApiMacSha256;
/**
 * 
 * @author Roselaine Marques
 *
 */
@Component(immediate = true, property = {
		"osgi.http.whiteboard.context.path=/" + RedsysCommercePaymentMethodConstants.SERVLET_PATH,
		"osgi.http.whiteboard.servlet.name=com.liferay.commerce.payment.method.redsys.servlet.RedsysCommercePaymentMethodServlet",
		"osgi.http.whiteboard.servlet.pattern=/" + RedsysCommercePaymentMethodConstants.SERVLET_PATH
				+ "/*" }, service = Servlet.class)
public class RedsysCommercePaymentMethodServlet extends HttpServlet {

	private static final long serialVersionUID = 1072470763650867734L;

	@Override
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {

		try {

			HttpSession httpSession = httpServletRequest.getSession();

			if (PortalSessionThreadLocal.getHttpSession() == null) {
				PortalSessionThreadLocal.setHttpSession(httpSession);
			}

			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil
					.create(_portal.getUser(httpServletRequest));

			PermissionThreadLocal.setPermissionChecker(permissionChecker);

			String redirectCod = ParamUtil.getString(httpServletRequest, "redirect");

			long groupId = ParamUtil.getLong(httpServletRequest, "groupId");
			String uuid = ParamUtil.getString(httpServletRequest, "uuid");

			CommerceOrder commerceOrder = _commerceOrderService.getCommerceOrderByUuidAndGroupId(uuid, groupId);

			if (Validator.isNotNull(redirectCod)) {

				byte[] bytesDecoded = Base64.getDecoder().decode(redirectCod);
				String redirect = new String(bytesDecoded);
				
				ApiMacSha256 apiMacSha256 = new ApiMacSha256();
				String params = ParamUtil.getString(httpServletRequest, RedsysCommercePaymentMethodConstants.DS_MERCHANT_PARAMETERS);
				String signature = ParamUtil.getString(httpServletRequest, RedsysCommercePaymentMethodConstants.DS_SIGNATURE);
				apiMacSha256.decodeMerchantParameters(params);
				
				String codResponseRedsys = apiMacSha256.getParameter("Ds_Response");
				httpServletRequest.setAttribute(RedsysCommercePaymentMethodConstants.COD_RESPONSE_REDSYS, codResponseRedsys);

				if (!redirect.contains("cancel")) {
					
					RedsysPaymentMethodCardGroupServiceConfiguration paymentMethodCardGroupServiceConfiguration = _getConfiguration(
							commerceOrder.getGroupId());
					
					String clientSecret = paymentMethodCardGroupServiceConfiguration.clientSecret();
					String signatureCalculed = apiMacSha256.createMerchantSignatureNotif(clientSecret, params);

					if (signatureCalculed.equals(signature)) {
						
						String dsOrder = apiMacSha256.getParameter("Ds_Order");
						String dsAmount = apiMacSha256.getParameter("Ds_Amount");
						String dsMerchantCode = apiMacSha256.getParameter("Ds_MerchantCode");
						String dsTerminal = apiMacSha256.getParameter("Ds_Terminal");
						String dsTransactionType = apiMacSha256.getParameter("Ds_TransactionType");

						String order = Long.toString(commerceOrder.getCommerceOrderId());
						String amount = commerceOrder.getTotal().setScale(2).toString().replace(".","");
						String merchantCode = paymentMethodCardGroupServiceConfiguration.merchantCode();
						String terminal = paymentMethodCardGroupServiceConfiguration.terminal();
						String typeTransaction = paymentMethodCardGroupServiceConfiguration.typeTransaction();
						RedsysTypeOfTransaction transactionValue = RedsysTypeOfTransaction.valueOf(typeTransaction.toUpperCase());
						
						if(dsOrder.equalsIgnoreCase(order) && dsAmount.equals(amount) && dsMerchantCode.equalsIgnoreCase(merchantCode)
								&& dsTerminal.equalsIgnoreCase("0".concat(terminal)) && dsTransactionType.equalsIgnoreCase(transactionValue.getTypeOfTransaction())) {
							
						_commercePaymentEngine.completePayment(commerceOrder.getCommerceOrderId(), null,
								httpServletRequest);
						
						}else {
							_log.error(RedsysCommercePaymentMethodConstants.ERROR_PARAMETERS_COMPARE);
							throw new Exception(RedsysCommercePaymentMethodConstants.ERROR_PARAMETERS_COMPARE);
						}
					}else {		
						_log.error(RedsysCommercePaymentMethodConstants.ERROR_SIGNATURE);
						throw new Exception(RedsysCommercePaymentMethodConstants.ERROR_SIGNATURE);
					}

				} else {

					_commercePaymentEngine.cancelPayment(commerceOrder.getCommerceOrderId(), null, httpServletRequest);
				}

				httpServletResponse.sendRedirect(redirect);

			} else {

				RequestDispatcher requestDispatcher = _servletContext
						.getRequestDispatcher("/redsys_form/redsys-form.jsp");

				requestDispatcher.forward(httpServletRequest, httpServletResponse);
			}
			
		}catch (Exception e) {
			_portal.sendError(e, httpServletRequest, httpServletResponse);
		}
	}

	private RedsysPaymentMethodCardGroupServiceConfiguration _getConfiguration(long groupId) throws ConfigurationException {

		return _configurationProvider.getConfiguration(RedsysPaymentMethodCardGroupServiceConfiguration.class,
				new GroupServiceSettingsLocator(groupId, RedsysCommercePaymentMethodConstants.SERVICE_NAME));
	}

	private static final Log _log = LogFactoryUtil.getLog(RedsysCommercePaymentMethodServlet.class);

	@Reference
	private CommerceOrderService _commerceOrderService;

	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference
	private CommercePaymentEngine _commercePaymentEngine;

	@Reference
	private CommerceSubscriptionEngine _commerceSubscriptionEngine;

	@Reference
	private Portal _portal;

	@Reference(target = "(osgi.web.symbolicname=commerce.payment.method.redsys)")
	private ServletContext _servletContext;

}
