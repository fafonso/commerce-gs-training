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

import commerce.training.car.garage.model.CarGarage;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the car garage service. This utility wraps <code>commerce.training.car.garage.service.persistence.impl.CarGaragePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Roselaine Marques
 * @see CarGaragePersistence
 * @generated
 */
public class CarGarageUtil {

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
	public static void clearCache(CarGarage carGarage) {
		getPersistence().clearCache(carGarage);
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
	public static Map<Serializable, CarGarage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CarGarage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CarGarage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CarGarage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CarGarage update(CarGarage carGarage) {
		return getPersistence().update(carGarage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CarGarage update(
		CarGarage carGarage, ServiceContext serviceContext) {

		return getPersistence().update(carGarage, serviceContext);
	}

	/**
	 * Returns all the car garages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching car garages
	 */
	public static List<CarGarage> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the car garages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @return the range of matching car garages
	 */
	public static List<CarGarage> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the car garages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching car garages
	 */
	public static List<CarGarage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the car garages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching car garages
	 */
	public static List<CarGarage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CarGarage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first car garage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public static CarGarage findByUuid_First(
			String uuid, OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first car garage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByUuid_First(
		String uuid, OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last car garage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public static CarGarage findByUuid_Last(
			String uuid, OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last car garage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByUuid_Last(
		String uuid, OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the car garages before and after the current car garage in the ordered set where uuid = &#63;.
	 *
	 * @param carGarageId the primary key of the current car garage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next car garage
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public static CarGarage[] findByUuid_PrevAndNext(
			long carGarageId, String uuid,
			OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByUuid_PrevAndNext(
			carGarageId, uuid, orderByComparator);
	}

	/**
	 * Removes all the car garages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of car garages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching car garages
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the car garage where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCarGarageException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public static CarGarage findByUUID_G(String uuid, long groupId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the car garage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the car garage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the car garage where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the car garage that was removed
	 */
	public static CarGarage removeByUUID_G(String uuid, long groupId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of car garages where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching car garages
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the car garages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching car garages
	 */
	public static List<CarGarage> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the car garages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @return the range of matching car garages
	 */
	public static List<CarGarage> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the car garages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching car garages
	 */
	public static List<CarGarage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the car garages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching car garages
	 */
	public static List<CarGarage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarGarage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public static CarGarage findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public static CarGarage findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the car garages before and after the current car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param carGarageId the primary key of the current car garage
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next car garage
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public static CarGarage[] findByUuid_C_PrevAndNext(
			long carGarageId, String uuid, long companyId,
			OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByUuid_C_PrevAndNext(
			carGarageId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the car garages where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of car garages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching car garages
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the car garage where cpDefinitionId = &#63; or throws a <code>NoSuchCarGarageException</code> if it could not be found.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public static CarGarage findByCPDefinitionId(long cpDefinitionId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByCPDefinitionId(cpDefinitionId);
	}

	/**
	 * Returns the car garage where cpDefinitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByCPDefinitionId(long cpDefinitionId) {
		return getPersistence().fetchByCPDefinitionId(cpDefinitionId);
	}

	/**
	 * Returns the car garage where cpDefinitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByCPDefinitionId(
		long cpDefinitionId, boolean useFinderCache) {

		return getPersistence().fetchByCPDefinitionId(
			cpDefinitionId, useFinderCache);
	}

	/**
	 * Removes the car garage where cpDefinitionId = &#63; from the database.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the car garage that was removed
	 */
	public static CarGarage removeByCPDefinitionId(long cpDefinitionId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().removeByCPDefinitionId(cpDefinitionId);
	}

	/**
	 * Returns the number of car garages where cpDefinitionId = &#63;.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the number of matching car garages
	 */
	public static int countByCPDefinitionId(long cpDefinitionId) {
		return getPersistence().countByCPDefinitionId(cpDefinitionId);
	}

	/**
	 * Returns all the car garages where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching car garages
	 */
	public static List<CarGarage> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the car garages where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @return the range of matching car garages
	 */
	public static List<CarGarage> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the car garages where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching car garages
	 */
	public static List<CarGarage> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the car garages where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching car garages
	 */
	public static List<CarGarage> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CarGarage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first car garage in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public static CarGarage findByGroupId_First(
			long groupId, OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first car garage in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByGroupId_First(
		long groupId, OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last car garage in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public static CarGarage findByGroupId_Last(
			long groupId, OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last car garage in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public static CarGarage fetchByGroupId_Last(
		long groupId, OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the car garages before and after the current car garage in the ordered set where groupId = &#63;.
	 *
	 * @param carGarageId the primary key of the current car garage
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next car garage
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public static CarGarage[] findByGroupId_PrevAndNext(
			long carGarageId, long groupId,
			OrderByComparator<CarGarage> orderByComparator)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByGroupId_PrevAndNext(
			carGarageId, groupId, orderByComparator);
	}

	/**
	 * Removes all the car garages where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of car garages where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching car garages
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the car garage in the entity cache if it is enabled.
	 *
	 * @param carGarage the car garage
	 */
	public static void cacheResult(CarGarage carGarage) {
		getPersistence().cacheResult(carGarage);
	}

	/**
	 * Caches the car garages in the entity cache if it is enabled.
	 *
	 * @param carGarages the car garages
	 */
	public static void cacheResult(List<CarGarage> carGarages) {
		getPersistence().cacheResult(carGarages);
	}

	/**
	 * Creates a new car garage with the primary key. Does not add the car garage to the database.
	 *
	 * @param carGarageId the primary key for the new car garage
	 * @return the new car garage
	 */
	public static CarGarage create(long carGarageId) {
		return getPersistence().create(carGarageId);
	}

	/**
	 * Removes the car garage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage that was removed
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public static CarGarage remove(long carGarageId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().remove(carGarageId);
	}

	public static CarGarage updateImpl(CarGarage carGarage) {
		return getPersistence().updateImpl(carGarage);
	}

	/**
	 * Returns the car garage with the primary key or throws a <code>NoSuchCarGarageException</code> if it could not be found.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public static CarGarage findByPrimaryKey(long carGarageId)
		throws commerce.training.car.garage.exception.NoSuchCarGarageException {

		return getPersistence().findByPrimaryKey(carGarageId);
	}

	/**
	 * Returns the car garage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage, or <code>null</code> if a car garage with the primary key could not be found
	 */
	public static CarGarage fetchByPrimaryKey(long carGarageId) {
		return getPersistence().fetchByPrimaryKey(carGarageId);
	}

	/**
	 * Returns all the car garages.
	 *
	 * @return the car garages
	 */
	public static List<CarGarage> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the car garages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @return the range of car garages
	 */
	public static List<CarGarage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the car garages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of car garages
	 */
	public static List<CarGarage> findAll(
		int start, int end, OrderByComparator<CarGarage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the car garages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarGarageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of car garages
	 * @param end the upper bound of the range of car garages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of car garages
	 */
	public static List<CarGarage> findAll(
		int start, int end, OrderByComparator<CarGarage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the car garages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of car garages.
	 *
	 * @return the number of car garages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CarGaragePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CarGaragePersistence, CarGaragePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CarGaragePersistence.class);

		ServiceTracker<CarGaragePersistence, CarGaragePersistence>
			serviceTracker =
				new ServiceTracker<CarGaragePersistence, CarGaragePersistence>(
					bundle.getBundleContext(), CarGaragePersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}