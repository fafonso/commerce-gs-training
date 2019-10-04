package com.liferay.training.product.type;

import com.liferay.commerce.product.type.CPType;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;
import org.osgi.service.component.annotations.Component;

@Component(
		  immediate = true,
		  property = {
		     "commerce.product.type.display.order:Integer=15",
		     "commerce.product.type.name=" + "Custom Product"
		  },
		  service = CPType.class
		)
public class CustomProductType implements CPType {
	@Override
	public void deleteCPDefinition(long cpDefinitionId) throws PortalException {
		
	}

	@Override
	public String getLabel(Locale locale) {
			return "Custom Product";
	}

	@Override
	public String getName() {
		return "Custom Product";
	}
}
