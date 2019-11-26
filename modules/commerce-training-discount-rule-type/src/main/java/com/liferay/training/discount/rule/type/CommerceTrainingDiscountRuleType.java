
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

@Component(immediate = true, property = {
	"commerce.discount.rule.type.key=" + CommerceTrainingDiscountRuleType.KEY,
	"commerce.discount.rule.type.order:Integer=51"
}, service = CommerceDiscountRuleType.class)
public class CommerceTrainingDiscountRuleType
	implements CommerceDiscountRuleType {

	public static final String KEY = "Example";

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

	@Override
	public String getKey() {

		return KEY;
	}

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
