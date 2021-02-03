package com.liferay.commerce.payment.method.redsys;

import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.constants.CommerceOrderPaymentConstants;
import com.liferay.commerce.constants.CommercePaymentConstants;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.payment.method.CommercePaymentMethod;
import com.liferay.commerce.payment.method.redsys.configuration.RedsysPaymentMethodCardGroupServiceConfiguration;
import com.liferay.commerce.payment.method.redsys.connector.RedsysConfigClient;
import com.liferay.commerce.payment.method.redsys.connector.RedsysEnvironment;
import com.liferay.commerce.payment.method.redsys.constants.RedsysCommercePaymentMethodConstants;
import com.liferay.commerce.payment.method.redsys.constants.RedsysMessages;
import com.liferay.commerce.payment.method.redsys.constants.RedsysTypeOfTransaction;
import com.liferay.commerce.payment.request.CommercePaymentRequest;
import com.liferay.commerce.payment.result.CommercePaymentResult;
import com.liferay.commerce.service.CommerceOrderService;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.URLCodec;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import sis.redsys.api.ApiMacSha256;
/**
 * 
 * @author Roselaine Marques
 *
 */
@Component(immediate = true, 
property = "commerce.payment.engine.method.key=" + RedsysCommercePaymentMethod.KEY, 
service = CommercePaymentMethod.class)

public class RedsysCommercePaymentMethod implements CommercePaymentMethod{

	public static final String KEY = "Redsys";
	
	@Override
	public String getDescription(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			RedsysCommercePaymentMethodConstants.BASE_NAME, locale, getClass());

		return LanguageUtil.get(
			resourceBundle, "this-is-payment-method-with-card-redsys");
	}
	
	@Override
	public String getKey() {
		return KEY;
	}

	@Override
	public String getName(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			RedsysCommercePaymentMethodConstants.BASE_NAME, locale, getClass());

		return LanguageUtil.get(resourceBundle, "redsys-payment-with-card");
	}

	@Override
	public int getPaymentType() {
		return CommercePaymentConstants.COMMERCE_PAYMENT_METHOD_TYPE_ONLINE_REDIRECT;
	}

	@Override
	public String getServletPath() {
		return RedsysCommercePaymentMethodConstants.SERVLET_PATH;
	}

	@Override
	public boolean isCancelEnabled() {
		return true;
	}

	@Override
	public boolean isCompleteEnabled() {
		return true;
	}

	@Override
	public boolean isProcessPaymentEnabled() {
		return true;
	}


	@Override
	public CommercePaymentResult cancelPayment(CommercePaymentRequest commercePaymentRequest) throws Exception {
		RedsysCommercePaymentMethodRequest redsysCommercePaymentMethodRequest =
				(RedsysCommercePaymentMethodRequest)commercePaymentRequest;
			 
		List<String> messages = getMessagesFromResponse(redsysCommercePaymentMethodRequest);
						
			return new CommercePaymentResult(
					redsysCommercePaymentMethodRequest.getTransactionId(),
					redsysCommercePaymentMethodRequest.getCommerceOrderId(),
					CommerceOrderPaymentConstants.STATUS_CANCELLED, false, null, null,
					messages, true);
	}
	
	@Override
	public CommercePaymentResult completePayment(CommercePaymentRequest commercePaymentRequest) throws Exception {
		
		RedsysCommercePaymentMethodRequest redsysCommercePaymentMethodRequest =
				(RedsysCommercePaymentMethodRequest)commercePaymentRequest;
		
		List<String> messages = getMessagesFromResponse(redsysCommercePaymentMethodRequest);

			return new CommercePaymentResult(
					redsysCommercePaymentMethodRequest.getTransactionId(),
					redsysCommercePaymentMethodRequest.getCommerceOrderId(),
					CommerceOrderConstants.PAYMENT_STATUS_PAID, false, null, null,
					messages, true);
	}

	@Override
	public CommercePaymentResult processPayment(CommercePaymentRequest commercePaymentRequest) throws Exception {
		
			RedsysCommercePaymentMethodRequest redsysCommercePaymentMethodRequest = (RedsysCommercePaymentMethodRequest) commercePaymentRequest;

			CommerceOrder commerceOrder = _commerceOrderService.getCommerceOrder(
					redsysCommercePaymentMethodRequest.getCommerceOrderId());
			
			String transactionUuid = PortalUUIDUtil.generate();
			String transactionId = StringUtil.replace(transactionUuid, CharPool.DASH, StringPool.BLANK);
			
			CommerceCurrency commerceCurrency = commerceOrder.getCommerceCurrency();
			Currency currencyIso4217 = Currency.getInstance(commerceCurrency.getCode());
			
			URL returnUrl = new URL(redsysCommercePaymentMethodRequest.getReturnUrl());
			String urlReturnDecoded = URLCodec.decodeURL(returnUrl.toString());
			
			String newRedirectOK= StringUtil.extractLast(urlReturnDecoded, RedsysCommercePaymentMethodConstants.REDIRECT_PARAM);
			String servlet = StringUtil.extractFirst(urlReturnDecoded, RedsysCommercePaymentMethodConstants.REDIRECT_PARAM).concat(StringPool.AMPERSAND.concat(RedsysCommercePaymentMethodConstants.REDIRECT_PARAM));
			
	        String urlCodedOK = Base64.getEncoder().encodeToString(newRedirectOK.getBytes());

			URL urlOk = new URL(servlet.concat(urlCodedOK));
			
			URL cancelUrl = new URL(redsysCommercePaymentMethodRequest.getCancelUrl());
			String urlCancelDecoded = URLCodec.decodeURL(cancelUrl.toString());
			
			String newRedirectKO= StringUtil.extractLast(urlCancelDecoded.toString(), RedsysCommercePaymentMethodConstants.REDIRECT_PARAM);

	        String urlCodedKO = Base64.getEncoder().encodeToString(newRedirectKO.getBytes());
	        URL urlNok = new URL(servlet.concat(urlCodedKO));

			RedsysPaymentMethodCardGroupServiceConfiguration paymentMethodCardGroupServiceConfiguration =
				_getConfiguration(commerceOrder.getGroupId());

			String environment = StringUtil.toUpperCase(paymentMethodCardGroupServiceConfiguration.mode());
			String clientSecret = paymentMethodCardGroupServiceConfiguration.clientSecret();
			String merchantCode = paymentMethodCardGroupServiceConfiguration.merchantCode();
			String dsSignatureV = paymentMethodCardGroupServiceConfiguration.dsSignatureVersion();	
			String typeTransaction = paymentMethodCardGroupServiceConfiguration.typeTransaction();				
			String terminal = paymentMethodCardGroupServiceConfiguration.terminal();				
			RedsysTypeOfTransaction transactionValue = RedsysTypeOfTransaction.valueOf(typeTransaction.toUpperCase());
			
			RedsysConfigClient redsysConfigClient = new RedsysConfigClient(dsSignatureV, clientSecret, RedsysEnvironment.valueOf(environment), merchantCode);
			
			ApiMacSha256 apiMacSha256 = new ApiMacSha256();
							
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_AMOUNT, commerceOrder.getTotal().setScale(2).toString().replace(".", ""));					
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_ORDER, Long.toString(commerceOrder.getCommerceOrderId()));
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_MERCHANTCODE,redsysConfigClient.getMerchantCode());
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_CURRENCY, Integer.toString(currencyIso4217.getNumericCode()));
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_TRANSACTIONTYPE, transactionValue.getTypeOfTransaction());
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_TERMINAL, terminal);
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_MERCHANTURL, URLCodec.encodeURL(_getServletUrl(redsysCommercePaymentMethodRequest)));
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_URLOK,  URLCodec.encodeURL(urlOk.toString()));
			apiMacSha256.setParameter(RedsysCommercePaymentMethodConstants.DS_MERCHANT_URLKO, URLCodec.encodeURL(urlNok.toString()));
			
			String claveModuloAdmin = redsysConfigClient.getSignatureSecret();
			String signature = apiMacSha256.createMerchantSignature(claveModuloAdmin); 
			String params = apiMacSha256.createMerchantParameters();				
			String dsSignatureVersion = redsysConfigClient.getDsSignatureVersion();
						
			List<String> resultMessage =  new ArrayList<String>();
						
			String url = StringBundler.concat(
					_getServletUrl(redsysCommercePaymentMethodRequest),
					StringPool.QUESTION, RedsysCommercePaymentMethodConstants.REDIRECT_URL,StringPool.EQUAL,URLCodec.encodeURL(redsysConfigClient.getEnvironmentUrl().toString()), 
					StringPool.AMPERSAND,RedsysCommercePaymentMethodConstants.PARAMS,StringPool.EQUAL,URLEncoder.encode(params, StringPool.UTF8),
					StringPool.AMPERSAND,RedsysCommercePaymentMethodConstants.SIGNATURE, StringPool.EQUAL,URLEncoder.encode(signature, StringPool.UTF8), 
					StringPool.AMPERSAND,RedsysCommercePaymentMethodConstants.DS_SIGNATURE_VERSION_PARAM,StringPool.EQUAL,dsSignatureVersion );
			
			boolean success = true;
			
			return new CommercePaymentResult(
				transactionId, commerceOrder.getCommerceOrderId(),
				CommerceOrderConstants.ORDER_STATUS_PENDING, true, url, null,
				resultMessage, success);
	}
	
	private RedsysPaymentMethodCardGroupServiceConfiguration _getConfiguration(long groupId)
			throws ConfigurationException {

			return _configurationProvider.getConfiguration(
					RedsysPaymentMethodCardGroupServiceConfiguration.class,
				new GroupServiceSettingsLocator(
					groupId, RedsysCommercePaymentMethodConstants.SERVICE_NAME));
		}

		private String _getServletUrl(
			RedsysCommercePaymentMethodRequest redsysCommercePaymentMethodRequest) {

			return StringBundler.concat(
				_portal.getPortalURL(
				redsysCommercePaymentMethodRequest.getHttpServletRequest()),
				_portal.getPathModule(), StringPool.SLASH,
				RedsysCommercePaymentMethodConstants.SERVLET_PATH);
		}
		
	private List<String> getMessagesFromResponse(RedsysCommercePaymentMethodRequest redsysCommercePaymentMethodRequest){
	
		HttpServletRequest httpServletRequest = redsysCommercePaymentMethodRequest.getHttpServletRequest();
		
		String codResponse = (String) httpServletRequest.getAttribute(RedsysCommercePaymentMethodConstants.COD_RESPONSE_REDSYS);
		
		RedsysMessages enumMessage = RedsysMessages.valueOf(("M").concat(codResponse));
		
		String messageLanguage = enumMessage.getMessage();
		
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(RedsysCommercePaymentMethodConstants.BASE_NAME, PortalUtil.getLocale(httpServletRequest), getClass());

		String messageLocalizable = LanguageUtil.get(resourceBundle, messageLanguage);
			 
		List<String> messages = new ArrayList<String>();
				
		messages.add(messageLocalizable);
		
		return messages;
	}	
	
	@Reference
	private CommerceOrderService _commerceOrderService;

	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference
	private Http _http;

	@Reference
	private Portal _portal;

}