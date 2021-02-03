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

package commerce.training.car.garage.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CarGarageLocalService}.
 *
 * @author Roselaine Marques
 * @see CarGarageLocalService
 * @generated
 */
public class CarGarageLocalServiceWrapper
	implements CarGarageLocalService, ServiceWrapper<CarGarageLocalService> {

	public CarGarageLocalServiceWrapper(
		CarGarageLocalService carGarageLocalService) {

		_carGarageLocalService = carGarageLocalService;
	}

	/**
	 * Adds the car garage to the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarage the car garage
	 * @return the car garage that was added
	 */
	@Override
	public commerce.training.car.garage.model.CarGarage addCarGarage(
		commerce.training.car.garage.model.CarGarage carGarage) {

		return _carGarageLocalService.addCarGarage(carGarage);
	}

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
	public commerce.training.car.garage.model.CarGarage addCarGarage(
			String title, double latitude, double longitude,
			long cpDefinitionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageLocalService.addCarGarage(
			title, latitude, longitude, cpDefinitionId, serviceContext);
	}

	/**
	 * Creates a new car garage with the primary key. Does not add the car garage to the database.
	 *
	 * @param carGarageId the primary key for the new car garage
	 * @return the new car garage
	 */
	@Override
	public commerce.training.car.garage.model.CarGarage createCarGarage(
		long carGarageId) {

		return _carGarageLocalService.createCarGarage(carGarageId);
	}

	/**
	 * Deletes the car garage from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarage the car garage
	 * @return the car garage that was removed
	 */
	@Override
	public commerce.training.car.garage.model.CarGarage deleteCarGarage(
		commerce.training.car.garage.model.CarGarage carGarage) {

		return _carGarageLocalService.deleteCarGarage(carGarage);
	}

	/**
	 * Deletes the car garage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage that was removed
	 * @throws PortalException if a car garage with the primary key could not be found
	 */
	@Override
	public commerce.training.car.garage.model.CarGarage deleteCarGarage(
			long carGarageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageLocalService.deleteCarGarage(carGarageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _carGarageLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _carGarageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>commerce.training.car.garage.model.impl.CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _carGarageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>commerce.training.car.garage.model.impl.CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _carGarageLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _carGarageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _carGarageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public commerce.training.car.garage.model.CarGarage fetchByCPDefinitionId(
		long cpDefinitionId) {

		return _carGarageLocalService.fetchByCPDefinitionId(cpDefinitionId);
	}

	@Override
	public commerce.training.car.garage.model.CarGarage fetchCarGarage(
		long carGarageId) {

		return _carGarageLocalService.fetchCarGarage(carGarageId);
	}

	/**
	 * Returns the car garage matching the UUID and group.
	 *
	 * @param uuid the car garage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	@Override
	public commerce.training.car.garage.model.CarGarage
		fetchCarGarageByUuidAndGroupId(String uuid, long groupId) {

		return _carGarageLocalService.fetchCarGarageByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public commerce.training.car.garage.model.CarGarage findByCPDefinitionId(
			long cpDefinitionId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return _carGarageLocalService.findByCPDefinitionId(cpDefinitionId);
	}

	@Override
	public commerce.training.car.garage.model.CarGarage findByPrimaryKey(
			long carGarageId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return _carGarageLocalService.findByPrimaryKey(carGarageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _carGarageLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the car garage with the primary key.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage
	 * @throws PortalException if a car garage with the primary key could not be found
	 */
	@Override
	public commerce.training.car.garage.model.CarGarage getCarGarage(
			long carGarageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageLocalService.getCarGarage(carGarageId);
	}

	/**
	 * Returns the car garage matching the UUID and group.
	 *
	 * @param uuid the car garage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching car garage
	 * @throws PortalException if a matching car garage could not be found
	 */
	@Override
	public commerce.training.car.garage.model.CarGarage
			getCarGarageByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageLocalService.getCarGarageByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the car garages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>commerce.training.car.garage.model.impl.CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @return the range of car garages
	 */
	@Override
	public java.util.List<commerce.training.car.garage.model.CarGarage>
		getCarGarages(int start, int end) {

		return _carGarageLocalService.getCarGarages(start, end);
	}

	/**
	 * Returns all the car garages matching the UUID and company.
	 *
	 * @param uuid the UUID of the car garages
	 * @param companyId the primary key of the company
	 * @return the matching car garages, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<commerce.training.car.garage.model.CarGarage>
		getCarGaragesByUuidAndCompanyId(String uuid, long companyId) {

		return _carGarageLocalService.getCarGaragesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of car garages matching the UUID and company.
	 *
	 * @param uuid the UUID of the car garages
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching car garages, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<commerce.training.car.garage.model.CarGarage>
		getCarGaragesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<commerce.training.car.garage.model.CarGarage>
					orderByComparator) {

		return _carGarageLocalService.getCarGaragesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of car garages.
	 *
	 * @return the number of car garages
	 */
	@Override
	public int getCarGaragesCount() {
		return _carGarageLocalService.getCarGaragesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _carGarageLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _carGarageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _carGarageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the car garage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param carGarage the car garage
	 * @return the car garage that was updated
	 */
	@Override
	public commerce.training.car.garage.model.CarGarage updateCarGarage(
		commerce.training.car.garage.model.CarGarage carGarage) {

		return _carGarageLocalService.updateCarGarage(carGarage);
	}

	@Override
	public CarGarageLocalService getWrappedService() {
		return _carGarageLocalService;
	}

	@Override
	public void setWrappedService(CarGarageLocalService carGarageLocalService) {
		_carGarageLocalService = carGarageLocalService;
	}

	private CarGarageLocalService _carGarageLocalService;

}