package com.liferay.commerce.training.order.validator.price.quantity;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.order.CommerceOrderValidator;
import com.liferay.commerce.order.CommerceOrderValidatorResult;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roselaine Marques
 * 
 * Verify that the example order validator was added by viewing the failure message. 
 * Open your browser to https://localhost:8080 and navigate to a catalog with at least one 
 * item priced over $100. If no such product exists yet, add it yourself; see Creating a Simple Product 
 * for more information.
 * 
 * From the catalog, find the item with this price, then click “Add to Cart”. Increase the quantity to 11 
 * or more, then click the arrow to continue. The error message that appears shows that the custom order 
 * validator successfully rejected adding the item.
 * 
 * It is important to provide a distinct key for the order validator so that Liferay Commerce can distinguish
 * the new order validator from others in the order validator registry. Reusing a key that is already in use 
 * will override the existing associated validator.
 * 
 * The commerce.order.validator.priority value indicates when the order validator will perform its validation 
 * in sequence with other validators. For example, the default order validator has a value of 10. Giving our 
 * order validator a value of 9 ensures that it will perform its validation immediately before the default validator.
 * 
 */
@Component(
		immediate = true,
		property = {
			"commerce.order.validator.key=" + CommerceTrainingOrderValidationPriceQuantity.KEY,
			"commerce.order.validator.priority:Integer=9"
		},
		service = CommerceOrderValidator.class
	)
public class CommerceTrainingOrderValidationPriceQuantity implements CommerceOrderValidator{

	public static final String KEY = "Example";

	/**
	 * This method provides a unique identifier for the order validator in the order validator registry. 
	 * The key can be used to fetch the validator from the registry. Reusing a key that is already in use 
	 * will override the existing associated validator.
	 */
	@Override
	public String getKey() {
		return KEY;
	}

	/**
	 * This is one of the two validation methods where we will add our custom validation logic. This method 
	 * is called whenever a customer adds an item to their cart. It does this by returning a CommerceOrderValidatorResult, 
	 * which uses a boolean to signal whether or not the result passes validation;
	 */
	@Override
	public CommerceOrderValidatorResult validate(
			Locale locale, CommerceOrder commerceOrder, CPInstance cpInstance,
			int quantity)
		throws PortalException {

		if (cpInstance == null) {
			return new CommerceOrderValidatorResult(false);
		}

		BigDecimal price = cpInstance.getPrice();

		if ((price.doubleValue() > 100.0) && (quantity > 10)) {
			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, getClass());

			return new CommerceOrderValidatorResult(
				false, LanguageUtil.get(resourceBundle, "this-item-has-a-maximum-quantity-of-10"));
		}

		return new CommerceOrderValidatorResult(true);
	}
	/**
	 * This is the second validation method where we can add custom validation logic. This method is called for items already 
	 * in the cart, whenever a customer proceeds to a new step in checkout.
	 */
	@Override
	public CommerceOrderValidatorResult validate(
			Locale locale, CommerceOrderItem commerceOrderItem)
		throws PortalException {

		BigDecimal price = commerceOrderItem.getUnitPrice();

		if ((price.doubleValue() > 100.0) &&
			(commerceOrderItem.getQuantity() > 10)) {

			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, getClass());

			return new CommerceOrderValidatorResult(
				false,
				LanguageUtil.get(
					resourceBundle,
					"expensive-items-have-a-maximum-quantity-of-10"));
		}

		return new CommerceOrderValidatorResult(true);
	}
}