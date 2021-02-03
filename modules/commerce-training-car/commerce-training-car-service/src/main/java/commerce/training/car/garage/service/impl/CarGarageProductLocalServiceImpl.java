/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package commerce.training.car.garage.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import commerce.training.car.garage.exception.CarGarageProductCPDefinitionIdException;
import commerce.training.car.garage.exception.CarGarageProductCarGarageIdException;
import commerce.training.car.garage.exception.NoSuchCarGarageProductException;
import commerce.training.car.garage.model.CarGarageProduct;
import commerce.training.car.garage.service.base.CarGarageProductLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the car garage product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>commerce.training.car.garage.service.CarGarageProductLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Roselaine de Faria Marques Montero
 * @see CarGarageProductLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=commerce.training.car.garage.model.CarGarageProduct",
	service = AopService.class
)
public class CarGarageProductLocalServiceImpl
	extends CarGarageProductLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>commerce.training.car.garage.service.CarGarageProductLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>commerce.training.car.garage.service.CarGarageProductLocalServiceUtil</code>.
	 */
	/**
	 * Creates a new CarGarageProduct. CarGarageProducts are the car parts which
	 * a CarGarage fit and repair.
	 *
	 * @param cpDefinitionId
	 * @param carGarageId
	 * @param serviceContext
	 * @return CarGarageProduct
	 * @exception PortalException
	 */
	@Override
	public CarGarageProduct addCarGarageProduct(
		long cpDefinitionId, long carGarageId, String title, ServiceContext serviceContext)
		throws PortalException {

		validate(cpDefinitionId, carGarageId);

		CarGarageProduct carGarageProduct =
			carGarageProductPersistence.create(counterLocalService.increment());

		carGarageProduct.setGroupId(serviceContext.getScopeGroupId());

		User user = userLocalService.getUser(serviceContext.getUserId());

		carGarageProduct.setCompanyId(user.getCompanyId());
		carGarageProduct.setUserId(user.getUserId());

		carGarageProduct.setCreateDate(new Date());
		carGarageProduct.setModifiedDate(new Date());

		carGarageProduct.setCpDefinitionId(cpDefinitionId);
		carGarageProduct.setCarGarageId(carGarageId);
		carGarageProduct.setTitle(title);

		return carGarageProductPersistence.update(carGarageProduct);

	}

	@Override
	public CarGarageProduct findByPrimaryKey(long carGarageId)
		throws NoSuchCarGarageProductException {

		return carGarageProductPersistence.findByPrimaryKey(carGarageId);
	}

	@Override
	public List<CarGarageProduct> findByCarGarageId(long carGarageId) {

		return carGarageProductPersistence.findByCarGarageId(carGarageId);
	}

	protected void validate(long cpDefinitionId, long carGarageId)
		throws PortalException {

		if (Validator.isNull(cpDefinitionId)) {
			throw new CarGarageProductCPDefinitionIdException();
		}

		if (Validator.isNull(carGarageId)) {
			throw new CarGarageProductCarGarageIdException();
		}
	}

}