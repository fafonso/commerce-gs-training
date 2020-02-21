
package com.liferay.training.product.type;

import com.liferay.commerce.product.type.CPType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.training.product.display.context.VehicleServiceConstants;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
	"commerce.product.type.display.order:Integer=15",
	"commerce.product.type.name=" + VehicleServiceConstants.VEHICLE_SERVICE_PRODUCT_KEY
}, service = CPType.class)
public class VehicleServiceCustomProductType implements CPType {


	@Override
	public void deleteCPDefinition(long cpDefinitionId)
		throws PortalException {

	}

	@Override
	public String getLabel(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, VehicleServiceConstants.VEHICLE_SERVICE_PRODUCT_KEY);

	}

	@Override
	public String getName() {

		return VehicleServiceConstants.VEHICLE_SERVICE_PRODUCT_KEY;
	}
}
