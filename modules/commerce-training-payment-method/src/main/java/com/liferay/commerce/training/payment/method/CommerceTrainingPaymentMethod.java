
package com.liferay.commerce.training.payment.method;

import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.constants.CommercePaymentConstants;
import com.liferay.commerce.payment.method.CommercePaymentMethod;
import com.liferay.commerce.payment.request.CommercePaymentRequest;
import com.liferay.commerce.payment.result.CommercePaymentResult;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;


@Component(immediate = true, 
			property = "commerce.payment.engine.method.key=" + CommerceTrainingPaymentMethod.KEY, service = CommercePaymentMethod.class)

public class CommerceTrainingPaymentMethod implements CommercePaymentMethod {

	/**
	 * It is important to provide a distinct key for the payment method so that
	 * Liferay Commerce can distinguish our new payment method from others in the
	 * payment method registry. Reusing a key that is already in use will override
	 * the existing associated payment method.
	 */
	public static final String KEY = "Example";

	/**
	 * Implement custom payment completion logic in this method. CommercePaymentResult 
	 * is a container that stores information relevant to the completion of a payment 
	 * process. See CommercePaymentResult.java for more information.
	 */
	@Override
	public CommercePaymentResult completePayment(
		CommercePaymentRequest commercePaymentRequest)
		throws Exception {

		return new CommercePaymentResult(
			null, commercePaymentRequest.getCommerceOrderId(),
			CommerceOrderConstants.PAYMENT_STATUS_PAID, false, null, null,
			Collections.emptyList(), true);
	}

	/**
	 * This populates the "Description" column in the Payment Methods
	 * administration page. Retrieving the description with a language key.
	 */
	@Override
	public String getDescription(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, "this-is-the-example-payment-method");
	}

	/**
	 * This provides a unique identifier for the payment method in the payment
	 * method registry. The key can be used to fetch the payment method from the
	 * registry. Reusing a key that is already in use will override the existing
	 * associated payment method.
	 */
	@Override
	public String getKey() {

		return KEY;
	}

	/**
	 * This populates the "Name" column in the Payment Methods administration
	 * page. It works similarly to the getDescription method.
	 */
	@Override
	public String getName(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "example");
	}

	/**
	 * This identifies how the payment engine will use a given payment method.
	 * We use the value COMMERCE_PAYMENT_METHOD_TYPE_OFFLINE to inform the
	 * payment engine that there are no online processing requirements for this
	 * payment method. There are two other payment type constants available
	 * out-of-the-box: COMMERCE_PAYMENT_METHOD_TYPE_ONLINE_STANDARD and
	 * COMMERCE_PAYMENT_METHOD_TYPE_ONLINE_REDIRECT.
	 */
	@Override
	public int getPaymentType() {

		return CommercePaymentConstants.COMMERCE_PAYMENT_METHOD_TYPE_OFFLINE;
	}

	/**
	 * A servlet may be required to enable proper interfacing with an external
	 * payment provider for online payment methods. Since no servlet path is
	 * required for an offline payment method, getServletPath must return null.
	 */
	@Override
	public String getServletPath() {

		return null;
	}

	@Override
	public boolean isCompleteEnabled() {

		return true;
	}

	@Override
	public boolean isProcessPaymentEnabled() {

		return true;
	}

	/**
	 * Implement custom payment logic in this method. The CommercePaymentResult
	 * should store information relevant to the processing of a payment. See
	 * CommercePaymentResult.java for more information.
	 */
	@Override
	public CommercePaymentResult processPayment(
		CommercePaymentRequest commercePaymentRequest)
		throws Exception {

		return new CommercePaymentResult(
			null, commercePaymentRequest.getCommerceOrderId(),
			CommerceOrderConstants.PAYMENT_STATUS_AUTHORIZED, false, null, null,
			Collections.emptyList(), true);
	}

}
