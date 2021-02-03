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

package commerce.training.car.garage.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import commerce.training.car.garage.model.CarGarageProduct;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the car garage product service. This utility wraps <code>commerce.training.car.garage.service.persistence.impl.CarGarageProductPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Roselaine Marques
 * @see CarGarageProductPersistence
 * @generated
 */
public class CarGarageProductUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CarGarageProduct carGarageProduct) {
		getPersistence().clearCache(carGarageProduct);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CarGarageProduct> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CarGarageProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CarGarageProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CarGarageProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CarGarageProduct update(CarGarageProduct carGarageProduct) {
		return getPersistence().update(carGarageProduct);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CarGarageProduct update(
		CarGarageProduct carGarageProduct, ServiceContext serviceContext) {

		return getPersistence().update(carGarageProduct, serviceContext);
	}

	/**
	 * Returns all the car garage products where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching car garage products
	 */
	public static List<CarGarageProduct> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the car garage products where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @return the range of matching car garage products
	 */
	public static List<CarGarageProduct> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the car garage products where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching car garage products
	 */
	public static List<CarGarageProduct> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the car garage products where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching car garage products
	 */
	public static List<CarGarageProduct> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first car garage product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage product
	 * @throws NoSuchCarGarageProductException if a matching car garage product could not be found
	 */
	public static CarGarageProduct findByUuid_First(
			String uuid, OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first car garage product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	public static CarGarageProduct fetchByUuid_First(
		String uuid, OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last car garage product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage product
	 * @throws NoSuchCarGarageProductException if a matching car garage product could not be found
	 */
	public static CarGarageProduct findByUuid_Last(
			String uuid, OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last car garage product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	public static CarGarageProduct fetchByUuid_Last(
		String uuid, OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the car garage products before and after the current car garage product in the ordered set where uuid = &#63;.
	 *
	 * @param carGarageProductId the primary key of the current car garage product
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next car garage product
	 * @throws NoSuchCarGarageProductException if a car garage product with the primary key could not be found
	 */
	public static CarGarageProduct[] findByUuid_PrevAndNext(
			long carGarageProductId, String uuid,
			OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByUuid_PrevAndNext(
			carGarageProductId, uuid, orderByComparator);
	}

	/**
	 * Removes all the car garage products where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of car garage products where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching car garage products
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the car garage product where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCarGarageProductException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching car garage product
	 * @throws NoSuchCarGarageProductException if a matching car garage product could not be found
	 */
	public static CarGarageProduct findByUUID_G(String uuid, long groupId)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the car garage product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	public static CarGarageProduct fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the car garage product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	public static CarGarageProduct fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the car garage product where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the car garage product that was removed
	 */
	public static CarGarageProduct removeByUUID_G(String uuid, long groupId)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of car garage products where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching car garage products
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the car garage products where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching car garage products
	 */
	public static List<CarGarageProduct> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the car garage products where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @return the range of matching car garage products
	 */
	public static List<CarGarageProduct> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the car garage products where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching car garage products
	 */
	public static List<CarGarageProduct> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the car garage products where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching car garage products
	 */
	public static List<CarGarageProduct> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first car garage product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage product
	 * @throws NoSuchCarGarageProductException if a matching car garage product could not be found
	 */
	public static CarGarageProduct findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first car garage product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	public static CarGarageProduct fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last car garage product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage product
	 * @throws NoSuchCarGarageProductException if a matching car garage product could not be found
	 */
	public static CarGarageProduct findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last car garage product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	public static CarGarageProduct fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the car garage products before and after the current car garage product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param carGarageProductId the primary key of the current car garage product
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next car garage product
	 * @throws NoSuchCarGarageProductException if a car garage product with the primary key could not be found
	 */
	public static CarGarageProduct[] findByUuid_C_PrevAndNext(
			long carGarageProductId, String uuid, long companyId,
			OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByUuid_C_PrevAndNext(
			carGarageProductId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the car garage products where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of car garage products where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching car garage products
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the car garage products where carGarageId = &#63;.
	 *
	 * @param carGarageId the car garage ID
	 * @return the matching car garage products
	 */
	public static List<CarGarageProduct> findByCarGarageId(long carGarageId) {
		return getPersistence().findByCarGarageId(carGarageId);
	}

	/**
	 * Returns a range of all the car garage products where carGarageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param carGarageId the car garage ID
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @return the range of matching car garage products
	 */
	public static List<CarGarageProduct> findByCarGarageId(
		long carGarageId, int start, int end) {

		return getPersistence().findByCarGarageId(carGarageId, start, end);
	}

	/**
	 * Returns an ordered range of all the car garage products where carGarageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param carGarageId the car garage ID
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching car garage products
	 */
	public static List<CarGarageProduct> findByCarGarageId(
		long carGarageId, int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().findByCarGarageId(
			carGarageId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the car garage products where carGarageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param carGarageId the car garage ID
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching car garage products
	 */
	public static List<CarGarageProduct> findByCarGarageId(
		long carGarageId, int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCarGarageId(
			carGarageId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first car garage product in the ordered set where carGarageId = &#63;.
	 *
	 * @param carGarageId the car garage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage product
	 * @throws NoSuchCarGarageProductException if a matching car garage product could not be found
	 */
	public static CarGarageProduct findByCarGarageId_First(
			long carGarageId,
			OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByCarGarageId_First(
			carGarageId, orderByComparator);
	}

	/**
	 * Returns the first car garage product in the ordered set where carGarageId = &#63;.
	 *
	 * @param carGarageId the car garage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	public static CarGarageProduct fetchByCarGarageId_First(
		long carGarageId,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().fetchByCarGarageId_First(
			carGarageId, orderByComparator);
	}

	/**
	 * Returns the last car garage product in the ordered set where carGarageId = &#63;.
	 *
	 * @param carGarageId the car garage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage product
	 * @throws NoSuchCarGarageProductException if a matching car garage product could not be found
	 */
	public static CarGarageProduct findByCarGarageId_Last(
			long carGarageId,
			OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByCarGarageId_Last(
			carGarageId, orderByComparator);
	}

	/**
	 * Returns the last car garage product in the ordered set where carGarageId = &#63;.
	 *
	 * @param carGarageId the car garage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage product, or <code>null</code> if a matching car garage product could not be found
	 */
	public static CarGarageProduct fetchByCarGarageId_Last(
		long carGarageId,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().fetchByCarGarageId_Last(
			carGarageId, orderByComparator);
	}

	/**
	 * Returns the car garage products before and after the current car garage product in the ordered set where carGarageId = &#63;.
	 *
	 * @param carGarageProductId the primary key of the current car garage product
	 * @param carGarageId the car garage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next car garage product
	 * @throws NoSuchCarGarageProductException if a car garage product with the primary key could not be found
	 */
	public static CarGarageProduct[] findByCarGarageId_PrevAndNext(
			long carGarageProductId, long carGarageId,
			OrderByComparator<CarGarageProduct> orderByComparator)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByCarGarageId_PrevAndNext(
			carGarageProductId, carGarageId, orderByComparator);
	}

	/**
	 * Removes all the car garage products where carGarageId = &#63; from the database.
	 *
	 * @param carGarageId the car garage ID
	 */
	public static void removeByCarGarageId(long carGarageId) {
		getPersistence().removeByCarGarageId(carGarageId);
	}

	/**
	 * Returns the number of car garage products where carGarageId = &#63;.
	 *
	 * @param carGarageId the car garage ID
	 * @return the number of matching car garage products
	 */
	public static int countByCarGarageId(long carGarageId) {
		return getPersistence().countByCarGarageId(carGarageId);
	}

	/**
	 * Caches the car garage product in the entity cache if it is enabled.
	 *
	 * @param carGarageProduct the car garage product
	 */
	public static void cacheResult(CarGarageProduct carGarageProduct) {
		getPersistence().cacheResult(carGarageProduct);
	}

	/**
	 * Caches the car garage products in the entity cache if it is enabled.
	 *
	 * @param carGarageProducts the car garage products
	 */
	public static void cacheResult(List<CarGarageProduct> carGarageProducts) {
		getPersistence().cacheResult(carGarageProducts);
	}

	/**
	 * Creates a new car garage product with the primary key. Does not add the car garage product to the database.
	 *
	 * @param carGarageProductId the primary key for the new car garage product
	 * @return the new car garage product
	 */
	public static CarGarageProduct create(long carGarageProductId) {
		return getPersistence().create(carGarageProductId);
	}

	/**
	 * Removes the car garage product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageProductId the primary key of the car garage product
	 * @return the car garage product that was removed
	 * @throws NoSuchCarGarageProductException if a car garage product with the primary key could not be found
	 */
	public static CarGarageProduct remove(long carGarageProductId)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().remove(carGarageProductId);
	}

	public static CarGarageProduct updateImpl(
		CarGarageProduct carGarageProduct) {

		return getPersistence().updateImpl(carGarageProduct);
	}

	/**
	 * Returns the car garage product with the primary key or throws a <code>NoSuchCarGarageProductException</code> if it could not be found.
	 *
	 * @param carGarageProductId the primary key of the car garage product
	 * @return the car garage product
	 * @throws NoSuchCarGarageProductException if a car garage product with the primary key could not be found
	 */
	public static CarGarageProduct findByPrimaryKey(long carGarageProductId)
		throws commerce.training.car.garage.exception.
			NoSuchCarGarageProductException {

		return getPersistence().findByPrimaryKey(carGarageProductId);
	}

	/**
	 * Returns the car garage product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param carGarageProductId the primary key of the car garage product
	 * @return the car garage product, or <code>null</code> if a car garage product with the primary key could not be found
	 */
	public static CarGarageProduct fetchByPrimaryKey(long carGarageProductId) {
		return getPersistence().fetchByPrimaryKey(carGarageProductId);
	}

	/**
	 * Returns all the car garage products.
	 *
	 * @return the car garage products
	 */
	public static List<CarGarageProduct> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the car garage products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @return the range of car garage products
	 */
	public static List<CarGarageProduct> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the car garage products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of car garage products
	 */
	public static List<CarGarageProduct> findAll(
		int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the car garage products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of car garage products
	 * @param end the upper bound of the range of car garage products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of car garage products
	 */
	public static List<CarGarageProduct> findAll(
		int start, int end,
		OrderByComparator<CarGarageProduct> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the car garage products from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of car garage products.
	 *
	 * @return the number of car garage products
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CarGarageProductPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CarGarageProductPersistence, CarGarageProductPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CarGarageProductPersistence.class);

		ServiceTracker<CarGarageProductPersistence, CarGarageProductPersistence>
			serviceTracker =
				new ServiceTracker
					<CarGarageProductPersistence, CarGarageProductPersistence>(
						bundle.getBundleContext(),
						CarGarageProductPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}