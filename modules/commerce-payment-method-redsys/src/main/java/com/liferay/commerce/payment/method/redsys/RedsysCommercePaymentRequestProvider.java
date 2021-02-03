package com.liferay.commerce.payment.method.redsys;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.payment.request.CommercePaymentRequest;
import com.liferay.commerce.payment.request.CommercePaymentRequestProvider;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
/**
 * 
 * @author Roselaine Marques
 *
 */
@Component(
		immediate = true,
		property = "commerce.payment.engine.method.key=" + RedsysCommercePaymentMethod.KEY,
		service = CommercePaymentRequestProvider.class
	)

public class RedsysCommercePaymentRequestProvider implements CommercePaymentRequestProvider{

	@Override
	public CommercePaymentRequest getCommercePaymentRequest(String cancelUrl, long commerceOrderId,
			HttpServletRequest httpServletRequest, Locale locale, String returnUrl, String transactionId)
			throws PortalException {
		
		CommerceOrder commerceOrder =
				_commerceOrderLocalService.getCommerceOrder(commerceOrderId);
		
		return new RedsysCommercePaymentMethodRequest(
				commerceOrder.getTotal(), cancelUrl, commerceOrderId, locale, httpServletRequest, returnUrl, transactionId);
	}

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;
}

