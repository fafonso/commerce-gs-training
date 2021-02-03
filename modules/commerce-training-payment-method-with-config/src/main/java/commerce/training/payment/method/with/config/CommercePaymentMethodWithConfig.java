package commerce.training.payment.method.with.config;

import com.liferay.commerce.payment.method.CommercePaymentMethod;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roselaine Marques
 */

@Component(immediate = true, 
property = "commerce.payment.engine.method.key=" + CommercePaymentMethodWithConfig.KEY, 
service = CommercePaymentMethod.class)

public class CommercePaymentMethodWithConfig implements CommercePaymentMethod{

	/**
	 * It is important to provide a distinct key for the payment method so that
	 * Liferay Commerce can distinguish our new payment method from others in the
	 * payment method registry. Reusing a key that is already in use will override
	 * the existing associated payment method.
	 */
	public static final String KEY = "Payment With Card";
	
	/**
	 * This populates the "Description" column in the Payment Methods
	 * administration page. Retrieving the description with a language key.
	 */
	@Override
	public String getDescription(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, "this-is-payment-method-with-card");
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

		return LanguageUtil.get(resourceBundle, "payment-with-card");
	}

	/**
	 * Identifies how the payment engine will use a given payment method.We use the value 
	 * COMMERCE_PAYMENT_METHOD_TYPE_OFFLINE to inform the payment engine that there are no online 
	 * processing requirements for this payment method. There are two other payment type constants 
	 * available out-of-the-box: COMMERCE_PAYMENT_METHOD_TYPE_ONLINE_STANDARD and 
	 * COMMERCE_PAYMENT_METHOD_TYPE_ONLINE_REDIRECT.
	 */
	@Override
	public int getPaymentType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getServletPath() {
		// TODO Auto-generated method stub
		return null;
	}
}