package commerce.training.discount.rule.with.param;

import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.discount.model.CommerceDiscountRule;
import com.liferay.commerce.discount.rule.type.CommerceDiscountRuleType;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * The commerce.discount.rule.type.order value indicates how far in the list of available discount rule types 
 * this type appears. For example, the “added all” discount rule type has a value of 50. Giving your discount 
 * rule type a value of 51 ensures that it appears immediately after the “added all” type.
 */

@Component(
	    immediate = true,
	    property = {
	        "commerce.discount.rule.type.key=" + CommerceTrainingDiscountRuleWithParam.KEY,
	        "commerce.discount.rule.type.order:Integer=51"
	    },
	    service = CommerceDiscountRuleType.class
	)
/**
 * @author Roselaine Marques
 */
public class CommerceTrainingDiscountRuleWithParam implements CommerceDiscountRuleType{
	
	/**
	 * It is important to provide a distinct key for the discount rule type so that Liferay Commerce c
	 * an distinguish the new type from others in the discount rule type registry. Declaring a key that 
	 * is already in use overrides the existing associated type.
	 */
	
    public static final String KEY = "Minimum Number of Products";

    /**
     * This method is where you implement the business logic for evaluating when the discount rule is applied.
     * mplement any conditions here that must be true for a discount rule to be applied. This example checks 
     * that the order contains at least a minimum number of items, using a minimum value defined by a custom UI input 
     * (stored as a String within the CommerceDiscountRule).
     */
	@Override
	public boolean evaluate(CommerceDiscountRule commerceDiscountRule, CommerceContext commerceContext)
			throws PortalException {

		CommerceOrder commerceOrder = commerceContext.getCommerceOrder();

		if (commerceOrder == null) {
			return false;
		}

		String settingsProperty = commerceDiscountRule.getSettingsProperty(
			commerceDiscountRule.getType());

		int minimumProducts = Integer.valueOf(settingsProperty);

		List<CommerceOrderItem> commerceOrderItems =
			commerceOrder.getCommerceOrderItems();

		if (commerceOrderItems.size() >= minimumProducts) {
			return true;
		}

		return false;
	}

	/**
	 * This provides a unique identifier for the discount rule type in the discount rule type registry. 
	 * The key can be used to fetch the new type from the registry.
	 */
	@Override
	public String getKey() {
		return KEY;
	}
	/**
	 * This returns a text label that describes how the discount rule is applied,
	 * retrieving the label with a language key
	 */
	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, getClass());

			return LanguageUtil.get(
				resourceBundle, "has-a-minimum-number-of-products");
	}
}