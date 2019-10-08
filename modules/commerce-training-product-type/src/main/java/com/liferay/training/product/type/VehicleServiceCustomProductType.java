
package com.liferay.training.product.type;

import com.liferay.commerce.product.type.CPType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
	"commerce.product.type.display.order:Integer=15",
	"commerce.product.type.name=" + VehicleServiceCustomProductType.NAME
}, service = CPType.class)
public class VehicleServiceCustomProductType implements CPType {

	public static final String NAME = "Vehicle Service";

	@Override
	public void deleteCPDefinition(long cpDefinitionId)
		throws PortalException {

	}

	@Override
	public String getLabel(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "vehicle-service");

	}

	@Override
	public String getName() {

		return NAME;
	}
}
