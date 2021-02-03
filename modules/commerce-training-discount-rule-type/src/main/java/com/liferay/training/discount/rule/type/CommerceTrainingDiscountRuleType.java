
package com.liferay.training.discount.rule.type;

import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.discount.model.CommerceDiscountRule;
import com.liferay.commerce.discount.rule.type.CommerceDiscountRuleType;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * It is important to provide a distinct key for the discount rule type so that
 * Liferay Commerce can distinguish the new type from others in the discount
 * rule type registry. Reusing a key that is already in use will override the
 * existing associated type. The commerce.discount.rule.type.order value
 * indicates how far in the list of available discount rule types this type will
 * appear. For example, the "added all" discount rule type has a value of 50.
 * Giving our discount rule type a value of 51 ensures that it will appear
 * immediately after the "added all" type.
 */
@Component(immediate = true, property = {
	"commerce.discount.rule.type.key=" + CommerceTrainingDiscountRuleType.KEY,
	"commerce.discount.rule.type.order:Integer=51"
}, service = CommerceDiscountRuleType.class)
public class CommerceTrainingDiscountRuleType
	implements CommerceDiscountRuleType {

	public static final String KEY = "Fitted By Garage";

	/**
	 * This method will be where we implement the business logic for evaluating
	 * when the discount rule is applied.
	 */
	@Override
	public boolean evaluate(
		CommerceDiscountRule commerceDiscountRule,
		CommerceContext commerceContext)
		throws PortalException {

		CommerceOrder commerceOrder = commerceContext.getCommerceOrder();

		if (commerceOrder == null) {
			return false;
		}

		List<CommerceOrderItem> commerceOrderItems =
			commerceOrder.getCommerceOrderItems();

		boolean isVehicleServiceOrder = false;

		for (CommerceOrderItem commerceOrderItem : commerceOrderItems) {
			if (commerceOrderItem.getCPDefinition().getProductTypeName().equals(
				"Vehicle Service")) {
				isVehicleServiceOrder = true;
				break;
			}
		}

		_log.debug(isVehicleServiceOrder);

		return isVehicleServiceOrder;

	}

	/**
	 * This provides a unique identifier for the discount rule type in the
	 * discount rule type registry. The key can be used to fetch the new type
	 * from the registry.
	 */
	@Override
	public String getKey() {

		return KEY;
	}

	/**
	 * This returns a text label that describes how the discount rule is
	 * applied. See the implementation in CommerceTrainingDiscountRuleType.java for
	 * a reference in retrieving the label with a language key.
	 */
	@Override
	public String getLabel(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, "car-garage-serviceable-products");
	}

	private static final Log _log =
		LogFactoryUtil.getLog(CommerceTrainingDiscountRuleType.class);

}
