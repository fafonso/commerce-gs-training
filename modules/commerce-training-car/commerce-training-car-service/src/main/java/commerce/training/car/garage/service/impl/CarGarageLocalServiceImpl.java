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

import commerce.training.car.garage.exception.CarGarageCPDefinitionIdException;
import commerce.training.car.garage.exception.CarGarageLatitudeException;
import commerce.training.car.garage.exception.CarGarageLongitudeException;
import commerce.training.car.garage.exception.NoSuchCarGarageException;
import commerce.training.car.garage.model.CarGarage;
import commerce.training.car.garage.service.base.CarGarageLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the car garage local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>commerce.training.car.garage.service.CarGarageLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Roselaine de Faria Marques Montero
 * @see CarGarageLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=commerce.training.car.garage.model.CarGarage",
	service = AopService.class
)
public class CarGarageLocalServiceImpl extends CarGarageLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>commerce.training.car.garage.service.CarGarageLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>commerce.training.car.garage.service.CarGarageLocalServiceUtil</code>.
	 */
	
	/**
	 * Creates a new CarGarage. CarGarage is a stores data for the commerce
	 * product type Car Service.
	 *
	 * @param latitude
	 * @param longitude
	 * @param cpDefinitionId
	 * @param serviceContext
	 * @return CarGarage
	 * @exception PortalException
	 */
	
	@Override
	public CarGarage addCarGarage(String title,
		double latitude, double longitude, long cpDefinitionId,
		ServiceContext serviceContext)
		throws PortalException {

		validate(latitude, longitude, cpDefinitionId);

		CarGarage carGarage =
			carGaragePersistence.create(counterLocalService.increment());

		carGarage.setGroupId(serviceContext.getScopeGroupId());

		User user = userLocalService.getUser(serviceContext.getUserId());

		carGarage.setCompanyId(user.getCompanyId());
		carGarage.setUserId(user.getUserId());
		carGarage.setUserName(user.getScreenName());
		
		carGarage.setCreateDate(new Date());
		carGarage.setModifiedDate(new Date());

		carGarage.setTitle(title);
		carGarage.setLatitude(latitude);
		carGarage.setLongitude(longitude);
		carGarage.setCpDefinitionId(cpDefinitionId);

		carGaragePersistence.update(carGarage);

		return carGarage;

	}

	@Override
	public CarGarage findByPrimaryKey(long carGarageId)
		throws NoSuchCarGarageException {

		return carGaragePersistence.findByPrimaryKey(carGarageId);
	}

	@Override
	public CarGarage fetchByCPDefinitionId(long cpDefinitionId) {

		return carGaragePersistence.fetchByCPDefinitionId(cpDefinitionId);
	}
	
	@Override
	public CarGarage findByCPDefinitionId(long cpDefinitionId)
		throws NoSuchCarGarageException {

		return carGaragePersistence.findByCPDefinitionId(cpDefinitionId);
	}

	protected void validate(
		double latitude, double longitude, long cpDefinitionId)
		throws PortalException {

		if (Validator.isNull(latitude)) {
			throw new CarGarageLatitudeException();
		}

		if (Validator.isNull(longitude)) {
			throw new CarGarageLongitudeException();
		}

		if (Validator.isNull(cpDefinitionId)) {
			throw new CarGarageCPDefinitionIdException();
		}
	}

}