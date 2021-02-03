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
 * Provides a wrapper for {@link CarGarageProductLocalService}.
 *
 * @author Roselaine Marques
 * @see CarGarageProductLocalService
 * @generated
 */
public class CarGarageProductLocalServiceWrapper
	implements CarGarageProductLocalService,
			   ServiceWrapper<CarGarageProductLocalService> {

	public CarGarageProductLocalServiceWrapper(
		CarGarageProductLocalService carGarageProductLocalService) {

		_carGarageProductLocalService = carGarageProductLocalService;
	}

	/**
	 * Adds the car garage product to the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProduct the car garage product
	 * @return the car garage product that was added
	 */
	@Override
	public commerce.training.car.garage.model.CarGarageProduct
		addCarGarageProduct(
			commerce.training.car.garage.model.CarGarageProduct
				carGarageProduct) {

		return _carGarageProductLocalService.addCarGarageProduct(
			carGarageProduct);
	}

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
	public commerce.training.car.garage.model.CarGarageProduct
			addCarGarageProduct(
				long cpDefinitionId, long carGarageId, String title,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageProductLocalService.addCarGarageProduct(
			cpDefinitionId, carGarageId, title, serviceContext);
	}

	/**
	 * Creates a new car garage product with the primary key. Does not add the car garage product to the database.
	 *
	 * @param carGarageProductId the primary key for the new car garage product
	 * @return the new car garage product
	 */
	@Override
	public commerce.training.car.garage.model.CarGarageProduct
		createCarGarageProduct(long carGarageProductId) {

		return _carGarageProductLocalService.createCarGarageProduct(
			carGarageProductId);
	}

	/**
	 * Deletes the car garage product from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProduct the car garage product
	 * @return the car garage product that was removed
	 */
	@Override
	public commerce.training.car.garage.model.CarGarageProduct
		deleteCarGarageProduct(
			commerce.training.car.garage.model.CarGarageProduct
				carGarageProduct) {

		return _carGarageProductLocalService.deleteCarGarageProduct(
			carGarageProduct);
	}

	/**
	 * Deletes the car garage product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProductId the primary key of the car garage product
	 * @return the car garage product that was removed
	 * @throws PortalException if a car garage product with the primary key could not be found
	 */
	@Override
	public commerce.training.car.garage.model.CarGarageProduct
			deleteCarGarageProduct(long carGarageProductId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageProductLocalService.deleteCarGarageProduct(
			carGarageProductId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageProductLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _carGarageProductLocalService.dynamicQuery();
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

		return _carGarageProductLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>commerce.training.car.garage.model.impl.CarGarageProductModelImpl</code>.
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

		return _carGarageProductLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>commerce.training.car.garage.model.impl.CarGarageProductModelImpl</code>.
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

		return _carGarageProductLocalService.dynamicQuery(
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

		return _carGarageProductLocalService.dynamicQueryCount(dynamicQuery);
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

		return _carGarageProductLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public commerce.training.car.garage.model.CarGarageProduct
		fetchCarGarageProduct(long carGarageProductId) {

		return _carGarageProductLocalService.fetchCarGarageProduct(
			carGarageProductId);
	}

	/**
	 * Returns the car garage product matching the UUID and group.
	 *
	 * @param uuid the car garage product's UUID
	 * @param groupId the primary key of the group
	 * @return the matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	@Override
	public commerce.training.car.garage.model.CarGarageProduct
		fetchCarGarageProductByUuidAndGroupId(String uuid, long groupId) {

		return _carGarageProductLocalService.
			fetchCarGarageProductByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<commerce.training.car.garage.model.CarGarageProduct>
		findByCarGarageId(long carGarageId) {

		return _carGarageProductLocalService.findByCarGarageId(carGarageId);
	}

	@Override
	public commerce.training.car.garage.model.CarGarageProduct findByPrimaryKey(
			long carGarageId)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return _carGarageProductLocalService.findByPrimaryKey(carGarageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _carGarageProductLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the car garage product with the primary key.
	 *
	 * @param carGarageProductId the primary key of the car garage product
	 * @return the car garage product
	 * @throws PortalException if a car garage product with the primary key could not be found
	 */
	@Override
	public commerce.training.car.garage.model.CarGarageProduct
			getCarGarageProduct(long carGarageProductId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageProductLocalService.getCarGarageProduct(
			carGarageProductId);
	}

	/**
	 * Returns the car garage product matching the UUID and group.
	 *
	 * @param uuid the car garage product's UUID
	 * @param groupId the primary key of the group
	 * @return the matching car garage product
	 * @throws PortalException if a matching car garage product could not be found
	 */
	@Override
	public commerce.training.car.garage.model.CarGarageProduct
			getCarGarageProductByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageProductLocalService.
			getCarGarageProductByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the car garage products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>commerce.training.car.garage.model.impl.CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @return the range of car garage products
	 */
	@Override
	public java.util.List<commerce.training.car.garage.model.CarGarageProduct>
		getCarGarageProducts(int start, int end) {

		return _carGarageProductLocalService.getCarGarageProducts(start, end);
	}

	/**
	 * Returns all the car garage products matching the UUID and company.
	 *
	 * @param uuid the UUID of the car garage products
	 * @param companyId the primary key of the company
	 * @return the matching car garage products, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<commerce.training.car.garage.model.CarGarageProduct>
		getCarGarageProductsByUuidAndCompanyId(String uuid, long companyId) {

		return _carGarageProductLocalService.
			getCarGarageProductsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of car garage products matching the UUID and company.
	 *
	 * @param uuid the UUID of the car garage products
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching car garage products, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<commerce.training.car.garage.model.CarGarageProduct>
		getCarGarageProductsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<commerce.training.car.garage.model.CarGarageProduct>
					orderByComparator) {

		return _carGarageProductLocalService.
			getCarGarageProductsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of car garage products.
	 *
	 * @return the number of car garage products
	 */
	@Override
	public int getCarGarageProductsCount() {
		return _carGarageProductLocalService.getCarGarageProductsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _carGarageProductLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _carGarageProductLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _carGarageProductLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carGarageProductLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the car garage product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProduct the car garage product
	 * @return the car garage product that was updated
	 */
	@Override
	public commerce.training.car.garage.model.CarGarageProduct
		updateCarGarageProduct(
			commerce.training.car.garage.model.CarGarageProduct
				carGarageProduct) {

		return _carGarageProductLocalService.updateCarGarageProduct(
			carGarageProduct);
	}

	@Override
	public CarGarageProductLocalService getWrappedService() {
		return _carGarageProductLocalService;
	}

	@Override
	public void setWrappedService(
		CarGarageProductLocalService carGarageProductLocalService) {

		_carGarageProductLocalService = carGarageProductLocalService;
	}

	private CarGarageProductLocalService _carGarageProductLocalService;

}