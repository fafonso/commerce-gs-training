
package com.liferay.commerce.training.low.stock.activity;

import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.stock.activity.CommerceLowStockActivity;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * It is important to provide a distinct key for the low stock activity so that
 * Liferay Commerce can distinguish the new activity from others in the low
 * stock activity registry. Reusing a key that is already in use will override
 * the existing associated activity. The commerce.low.stock.activity.priority
 * value indicates how far into the list of low stock activities our activity
 * will appear in the UI. For example, the "set as unpublished" activity has a
 * value of 10. Giving our low stock activity a value of 9 ensures that it will
 * appear immediately before the "set as unpublished" activity.
 */
@Component(immediate = true, property = {
	"commerce.low.stock.activity.key=" + CommerceTrainingLowStockActivity.KEY,
	"commerce.low.stock.activity.priority:Integer=9"
}, service = CommerceLowStockActivity.class)
public class CommerceTrainingLowStockActivity implements CommerceLowStockActivity {

	public static final String KEY = "LowSKU";

	/**
	 * This method will be where the business logic is implemented for the
	 * custom activity.
	 */
	@Override
	public void execute(CPInstance cpInstance)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn("Low stock for SKU: " + cpInstance.getSku());
			System.out.print("Low stock for SKU: " + cpInstance.getSku());
		}
	}

	/**
	 * This provides a unique identifier for the low stock activity in the low
	 * stock activity registry. The key can be used to fetch the low stock
	 * activity from the registry.
	 */
	@Override
	public String getKey() {

		return KEY;
	}

	/**
	 * This returns a text label that describes the low stock activity. See the
	 * implementation in CommerceTrainingLowStockActivity.java for a reference in
	 * retrieving the label with a language key.
	 */
	@Override
	public String getLabel(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "log-a-warning-message");
	}

	private static final Log _log =
		LogFactoryUtil.getLog(CommerceTrainingLowStockActivity.class);

}
