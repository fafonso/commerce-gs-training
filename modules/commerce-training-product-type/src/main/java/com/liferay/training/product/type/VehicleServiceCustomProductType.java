
package com.liferay.training.product.type;

import com.liferay.commerce.product.type.CPType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * The product type name must be a unique value so that Liferay Commerce can
 * distinguish our product type from existing product types. The
 * commerce.product.type.display.order value indicates how far into the list of
 * product types our product type will appear in the UI. For example, the
 * virtual product type has a value of 15. Giving our product type a value of 16
 * ensures that it will appear immediately after the virtual type.
 */
@Component(immediate = true, property = {
	"commerce.product.type.display.order:Integer=16",
	"commerce.product.type.name=" + VehicleServiceCustomProductType.NAME
}, service = CPType.class)
public class VehicleServiceCustomProductType implements CPType {

	public static final String NAME = "Vehicle Service";

	/**
	 * This method is where any custom deletion logic for the product type will be added.
	 */
	@Override
	public void deleteCPDefinition(long cpDefinitionId)
		throws PortalException {

	}

	/**
	 * This returns a text label that describes the product type. 
	 */
	@Override
	public String getLabel(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "vehicle-service");

	}
	/**
	 * This returns the name of our product type. This name may be a language key 
	 * that corresponds to the name that will appear in the UI.
	 */
	@Override
	public String getName() {

		return NAME;
	}
}
