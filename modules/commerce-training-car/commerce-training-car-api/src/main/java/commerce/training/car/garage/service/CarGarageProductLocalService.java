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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import commerce.training.car.garage.exception.NoSuchCarGarageProductException;
import commerce.training.car.garage.model.CarGarageProduct;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for CarGarageProduct. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Roselaine Marques
 * @see CarGarageProductLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CarGarageProductLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CarGarageProductLocalServiceUtil} to access the car garage product local service. Add custom service methods to <code>commerce.training.car.garage.service.impl.CarGarageProductLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the car garage product to the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProduct the car garage product
	 * @return the car garage product that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CarGarageProduct addCarGarageProduct(
		CarGarageProduct carGarageProduct);

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
	public CarGarageProduct addCarGarageProduct(
			long cpDefinitionId, long carGarageId, String title,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new car garage product with the primary key. Does not add the car garage product to the database.
	 *
	 * @param carGarageProductId the primary key for the new car garage product
	 * @return the new car garage product
	 */
	@Transactional(enabled = false)
	public CarGarageProduct createCarGarageProduct(long carGarageProductId);

	/**
	 * Deletes the car garage product from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProduct the car garage product
	 * @return the car garage product that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public CarGarageProduct deleteCarGarageProduct(
		CarGarageProduct carGarageProduct);

	/**
	 * Deletes the car garage product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProductId the primary key of the car garage product
	 * @return the car garage product that was removed
	 * @throws PortalException if a car garage product with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public CarGarageProduct deleteCarGarageProduct(long carGarageProductId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarGarageProduct fetchCarGarageProduct(long carGarageProductId);

	/**
	 * Returns the car garage product matching the UUID and group.
	 *
	 * @param uuid the car garage product's UUID
	 * @param groupId the primary key of the group
	 * @return the matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarGarageProduct fetchCarGarageProductByUuidAndGroupId(
		String uuid, long groupId);

	public List<CarGarageProduct> findByCarGarageId(long carGarageId);

	public CarGarageProduct findByPrimaryKey(long carGarageId)
		throws NoSuchCarGarageProductException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the car garage product with the primary key.
	 *
	 * @param carGarageProductId the primary key of the car garage product
	 * @return the car garage product
	 * @throws PortalException if a car garage product with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarGarageProduct getCarGarageProduct(long carGarageProductId)
		throws PortalException;

	/**
	 * Returns the car garage product matching the UUID and group.
	 *
	 * @param uuid the car garage product's UUID
	 * @param groupId the primary key of the group
	 * @return the matching car garage product
	 * @throws PortalException if a matching car garage product could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarGarageProduct getCarGarageProductByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CarGarageProduct> getCarGarageProducts(int start, int end);

	/**
	 * Returns all the car garage products matching the UUID and company.
	 *
	 * @param uuid the UUID of the car garage products
	 * @param companyId the primary key of the company
	 * @return the matching car garage products, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CarGarageProduct> getCarGarageProductsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CarGarageProduct> getCarGarageProductsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator);

	/**
	 * Returns the number of car garage products.
	 *
	 * @return the number of car garage products
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCarGarageProductsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the car garage product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProduct the car garage product
	 * @return the car garage product that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CarGarageProduct updateCarGarageProduct(
		CarGarageProduct carGarageProduct);

}