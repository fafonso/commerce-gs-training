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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CarGarage. This utility wraps
 * <code>commerce.training.car.garage.service.impl.CarGarageLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Roselaine Marques
 * @see CarGarageLocalService
 * @generated
 */
public class CarGarageLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>commerce.training.car.garage.service.impl.CarGarageLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the car garage to the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarage the car garage
	 * @return the car garage that was added
	 */
	public static commerce.training.car.garage.model.CarGarage addCarGarage(
		commerce.training.car.garage.model.CarGarage carGarage) {

		return getService().addCarGarage(carGarage);
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
	public static commerce.training.car.garage.model.CarGarage addCarGarage(
			String title, double latitude, double longitude,
			long cpDefinitionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCarGarage(
			title, latitude, longitude, cpDefinitionId, serviceContext);
	}

	/**
	 * Creates a new car garage with the primary key. Does not add the car garage to the database.
	 *
	 * @param carGarageId the primary key for the new car garage
	 * @return the new car garage
	 */
	public static commerce.training.car.garage.model.CarGarage createCarGarage(
		long carGarageId) {

		return getService().createCarGarage(carGarageId);
	}

	/**
	 * Deletes the car garage from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarage the car garage
	 * @return the car garage that was removed
	 */
	public static commerce.training.car.garage.model.CarGarage deleteCarGarage(
		commerce.training.car.garage.model.CarGarage carGarage) {

		return getService().deleteCarGarage(carGarage);
	}

	/**
	 * Deletes the car garage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage that was removed
	 * @throws PortalException if a car garage with the primary key could not be found
	 */
	public static commerce.training.car.garage.model.CarGarage deleteCarGarage(
			long carGarageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCarGarage(carGarageId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static commerce.training.car.garage.model.CarGarage
		fetchByCPDefinitionId(long cpDefinitionId) {

		return getService().fetchByCPDefinitionId(cpDefinitionId);
	}

	public static commerce.training.car.garage.model.CarGarage fetchCarGarage(
		long carGarageId) {

		return getService().fetchCarGarage(carGarageId);
	}

	/**
	 * Returns the car garage matching the UUID and group.
	 *
	 * @param uuid the car garage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static commerce.training.car.garage.model.CarGarage
		fetchCarGarageByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchCarGarageByUuidAndGroupId(uuid, groupId);
	}

	public static commerce.training.car.garage.model.CarGarage
			findByCPDefinitionId(long cpDefinitionId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getService().findByCPDefinitionId(cpDefinitionId);
	}

	public static commerce.training.car.garage.model.CarGarage findByPrimaryKey(
			long carGarageId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getService().findByPrimaryKey(carGarageId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the car garage with the primary key.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage
	 * @throws PortalException if a car garage with the primary key could not be found
	 */
	public static commerce.training.car.garage.model.CarGarage getCarGarage(
			long carGarageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCarGarage(carGarageId);
	}

	/**
	 * Returns the car garage matching the UUID and group.
	 *
	 * @param uuid the car garage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching car garage
	 * @throws PortalException if a matching car garage could not be found
	 */
	public static commerce.training.car.garage.model.CarGarage
			getCarGarageByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCarGarageByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<commerce.training.car.garage.model.CarGarage>
		getCarGarages(int start, int end) {

		return getService().getCarGarages(start, end);
	}

	/**
	 * Returns all the car garages matching the UUID and company.
	 *
	 * @param uuid the UUID of the car garages
	 * @param companyId the primary key of the company
	 * @return the matching car garages, or an empty list if no matches were found
	 */
	public static java.util.List<commerce.training.car.garage.model.CarGarage>
		getCarGaragesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getCarGaragesByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<commerce.training.car.garage.model.CarGarage>
		getCarGaragesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<commerce.training.car.garage.model.CarGarage>
					orderByComparator) {

		return getService().getCarGaragesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of car garages.
	 *
	 * @return the number of car garages
	 */
	public static int getCarGaragesCount() {
		return getService().getCarGaragesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the car garage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param carGarage the car garage
	 * @return the car garage that was updated
	 */
	public static commerce.training.car.garage.model.CarGarage updateCarGarage(
		commerce.training.car.garage.model.CarGarage carGarage) {

		return getService().updateCarGarage(carGarage);
	}

	public static CarGarageLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CarGarageLocalService, CarGarageLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CarGarageLocalService.class);

		ServiceTracker<CarGarageLocalService, CarGarageLocalService>
			serviceTracker =
				new ServiceTracker
					<CarGarageLocalService, CarGarageLocalService>(
						bundle.getBundleContext(), CarGarageLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}