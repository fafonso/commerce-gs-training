package com.liferay.commerce.training.order.validator;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.order.CommerceOrderValidator;
import com.liferay.commerce.order.CommerceOrderValidatorResult;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.training.order.validator.constants.CustomOrderValidatorConstants;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
		"commerce.order.validator.key=" +
				CustomOrderValidatorConstants.CUSTOMORDERVALIDATORKEY,
		"commerce.order.validator.priority:Integer=10"
	}, service = CommerceOrderValidator.class)

public class CustomOrderValidator implements CommerceOrderValidator {
	
	@Override
	public String getKey() {

		return CustomOrderValidatorConstants.CUSTOMORDERVALIDATORKEY;
	}

	@Override
	public CommerceOrderValidatorResult validate(Locale locale, CommerceOrder commerceOrder, CPInstance cpInstance,
			int quantity) throws PortalException {
		if (commerceOrder.isEmpty()) {
			return new CommerceOrderValidatorResult(true);
		} else {
			List<CommerceOrderItem> orderItems = commerceOrder.getCommerceOrderItems();
			CommerceOrderItem lastItem = orderItems.get(orderItems.size() - 1);
			String lastAddedProductType = lastItem.getCPDefinition().getProductTypeName();
			String newlyAddedProductType = cpInstance.getCPDefinition().getProductTypeName();
			
			
			if(newlyAddedProductType.equals(CustomOrderValidatorConstants.CUSTOMPRODUCTNAME)
					&& lastAddedProductType.equals(CustomOrderValidatorConstants.CUSTOMPRODUCTNAME)) {
				
				return new CommerceOrderValidatorResult(true);
			} else if(!newlyAddedProductType.equals(CustomOrderValidatorConstants.CUSTOMPRODUCTNAME)
					&& !lastAddedProductType.equals(CustomOrderValidatorConstants.CUSTOMPRODUCTNAME)) {
				
				return new CommerceOrderValidatorResult(true);
			} else {
				return new CommerceOrderValidatorResult(
						false,
						CustomOrderValidatorConstants.UNABLETOMIXCUSTOMPRODUCTWITHOTHERPRODUCT);
			}
			
		}

	}

	@Override
	public CommerceOrderValidatorResult validate(Locale locale, CommerceOrderItem commerceOrderItem)
			throws PortalException {
		
		return new CommerceOrderValidatorResult(true);
	}
}
