package com.liferay.commerce.training.order.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.order.CommerceOrderValidator;
import com.liferay.commerce.order.CommerceOrderValidatorResult;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.training.order.validator.constants.CustomOrderValidatorConstants;
import com.liferay.portal.kernel.exception.PortalException;

import commerce.training.car.garage.model.CarGarage;
import commerce.training.car.garage.model.CarGarageProduct;
import commerce.training.car.garage.service.CarGarageLocalService;
import commerce.training.car.garage.service.CarGarageProductLocalService;

/**
 * 
 * It is important to provide a distinct key for the order validator so that
 * Liferay Commerce can distinguish the new order validator from others in the
 * order validator registry. Reusing a key that is already in use will override
 * the existing associated validator. The commerce.order.validator.priority
 * value indicates when the order validator will perform its validation in
 * sequence with other validators. For example, the default order validator has
 * a value of 10. Giving our order validator a value of 9 ensures that it will
 * perform its validation immediately before the default validator.
 */

@Component(immediate = true, property = {
	"commerce.order.validator.key=" +
		CustomOrderValidatorConstants.CUSTOMORDERVALIDATORKEY,
	"commerce.order.validator.priority:Integer=10"
}, service = CommerceOrderValidator.class)

public class CustomOrderValidator implements CommerceOrderValidator {

	/**
	 * This method provides a unique identifier for the order validator in the
	 * order validator registry. The key can be used to fetch the validator from
	 * the registry. Reusing a key that is already in use will override the
	 * existing associated validator.
	 */
	@Override
	public String getKey() {

		return CustomOrderValidatorConstants.CUSTOMORDERVALIDATORKEY;
	}

	/**
	 * This is one of the two validation methods where we will add our custom
	 * validation logic. This method is called whenever a customer adds an item
	 * to their cart. It does this by returning a CommerceOrderValidatorResult,
	 * which uses a boolean to signal whether or not the result passes
	 * validation;
	 * 
	 * This method garantee that only one product of Vehicle Service will be added on the cart.
	 * 
	 * Here we can validate what there are on the Order and What is or quantity of the new Item to add. 
	 * 
	 */
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
	
	/**
	 * Validate order item
	 */
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
