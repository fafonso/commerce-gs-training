
package com.liferay.commerce.training.order.validator;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.order.CommerceOrderValidator;
import com.liferay.commerce.order.CommerceOrderValidatorResult;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.training.order.validator.constants.CustomOrderValidatorConstants;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import commerce.training.car.garage.model.CarGarage;
import commerce.training.car.garage.model.CarGarageProduct;
import commerce.training.car.garage.service.CarGarageLocalService;
import commerce.training.car.garage.service.CarGarageProductLocalService;

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
	public CommerceOrderValidatorResult validate(
		Locale locale, CommerceOrder commerceOrder, CPInstance cpInstance,
		int quantity)
		throws PortalException {

		CPDefinition newOrderItemCPDefinition = cpInstance.getCPDefinition();

		if (commerceOrder.isEmpty()) {
			return new CommerceOrderValidatorResult(true);
		}
		else {

			List<CommerceOrderItem> commerceOrderItems =
				commerceOrder.getCommerceOrderItems();

			Set<Long> cpDefinitionIds = new HashSet();

			for (CommerceOrderItem CommerceOrderItem : commerceOrderItems) {
				cpDefinitionIds.add(CommerceOrderItem.getCPDefinitionId());
			}

			boolean hasVehicleServiceOrderItem = false;
			long existingCarGarageCPDefinitionId = 0l;

			// Check that the order contains a vehicle service.
			for (CommerceOrderItem commerceOrderItem : commerceOrderItems) {

				if (commerceOrderItem.getCPDefinition().getProductTypeName().equals(
					CustomOrderValidatorConstants.CUSTOMPRODUCTNAME)) {
					existingCarGarageCPDefinitionId =
						commerceOrderItem.getCPDefinition().getCPDefinitionId();
					hasVehicleServiceOrderItem = true;

				}

			}

			// Check that there is only 1 vehicle service in order.
			if (hasVehicleServiceOrderItem &&
				(newOrderItemCPDefinition.getProductTypeName().equals(
					CustomOrderValidatorConstants.CUSTOMPRODUCTNAME))) {

				return new CommerceOrderValidatorResult(
					false,
					CustomOrderValidatorConstants.ONLY1VEHILCESERVICEALLOWEDPERORDER);

			}

			if (newOrderItemCPDefinition.getProductTypeName().equals(
				CustomOrderValidatorConstants.CUSTOMPRODUCTNAME)) {

				CarGarage carGarage =
					_carGarageLocalService.findByCPDefinitionId(
						newOrderItemCPDefinition.getCPDefinitionId());

				List<CarGarageProduct> carGarageProducts =
					_carGarageProductLocalService.findByCarGarageId(
						carGarage.getCarGarageId());

				for (CarGarageProduct carGarageProduct : carGarageProducts) {

					if (!cpDefinitionIds.contains(
						carGarageProduct.getCpDefinitionId())) {

						return new CommerceOrderValidatorResult(
							false,
							CustomOrderValidatorConstants.GARAGECANNOTFITPART);
					}
				}

			}

			if (hasVehicleServiceOrderItem &&
				!newOrderItemCPDefinition.getProductTypeName().equals(
					CustomOrderValidatorConstants.CUSTOMPRODUCTNAME)) {

				CarGarage carGarage =
					_carGarageLocalService.findByCPDefinitionId(
						existingCarGarageCPDefinitionId);

				List<CarGarageProduct> carGarageProducts =
					_carGarageProductLocalService.findByCarGarageId(
						carGarage.getCarGarageId());

				for (CarGarageProduct carGarageProduct : carGarageProducts) {
					if (carGarageProduct.getCpDefinitionId() == newOrderItemCPDefinition.getCPDefinitionId()) {

						return new CommerceOrderValidatorResult(true);

					}
				}

				return new CommerceOrderValidatorResult(
					false, CustomOrderValidatorConstants.GARAGECANNOTFITPART);

			}

		}

		return new CommerceOrderValidatorResult(true);

	}

	@Override
	public CommerceOrderValidatorResult validate(
		Locale locale, CommerceOrderItem commerceOrderItem)
		throws PortalException {

		return new CommerceOrderValidatorResult(true);
	}

	@Reference
	private CarGarageLocalService _carGarageLocalService;

	@Reference
	private CarGarageProductLocalService _carGarageProductLocalService;

}
