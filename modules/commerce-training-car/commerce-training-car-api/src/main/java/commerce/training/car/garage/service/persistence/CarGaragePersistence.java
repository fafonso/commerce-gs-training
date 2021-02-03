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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import commerce.training.car.garage.exception.NoSuchCarGarageException;
import commerce.training.car.garage.model.CarGarage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the car garage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Roselaine Marques
 * @see CarGarageUtil
 * @generated
 */
@ProviderType
public interface CarGaragePersistence extends BasePersistence<CarGarage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CarGarageUtil} to access the car garage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the car garages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching car garages
	 */
	public java.util.List<CarGarage> findByUuid(String uuid);

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
	public java.util.List<CarGarage> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CarGarage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

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
	public java.util.List<CarGarage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first car garage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public CarGarage findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Returns the first car garage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

	/**
	 * Returns the last car garage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public CarGarage findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Returns the last car garage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

	/**
	 * Returns the car garages before and after the current car garage in the ordered set where uuid = &#63;.
	 *
	 * @param carGarageId the primary key of the current car garage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next car garage
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public CarGarage[] findByUuid_PrevAndNext(
			long carGarageId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Removes all the car garages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of car garages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching car garages
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the car garage where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCarGarageException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public CarGarage findByUUID_G(String uuid, long groupId)
		throws NoSuchCarGarageException;

	/**
	 * Returns the car garage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the car garage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the car garage where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the car garage that was removed
	 */
	public CarGarage removeByUUID_G(String uuid, long groupId)
		throws NoSuchCarGarageException;

	/**
	 * Returns the number of car garages where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching car garages
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the car garages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching car garages
	 */
	public java.util.List<CarGarage> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<CarGarage> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CarGarage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

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
	public java.util.List<CarGarage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public CarGarage findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Returns the first car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

	/**
	 * Returns the last car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public CarGarage findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Returns the last car garage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

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
	public CarGarage[] findByUuid_C_PrevAndNext(
			long carGarageId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Removes all the car garages where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of car garages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching car garages
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the car garage where cpDefinitionId = &#63; or throws a <code>NoSuchCarGarageException</code> if it could not be found.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public CarGarage findByCPDefinitionId(long cpDefinitionId)
		throws NoSuchCarGarageException;

	/**
	 * Returns the car garage where cpDefinitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByCPDefinitionId(long cpDefinitionId);

	/**
	 * Returns the car garage where cpDefinitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByCPDefinitionId(
		long cpDefinitionId, boolean useFinderCache);

	/**
	 * Removes the car garage where cpDefinitionId = &#63; from the database.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the car garage that was removed
	 */
	public CarGarage removeByCPDefinitionId(long cpDefinitionId)
		throws NoSuchCarGarageException;

	/**
	 * Returns the number of car garages where cpDefinitionId = &#63;.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the number of matching car garages
	 */
	public int countByCPDefinitionId(long cpDefinitionId);

	/**
	 * Returns all the car garages where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching car garages
	 */
	public java.util.List<CarGarage> findByGroupId(long groupId);

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
	public java.util.List<CarGarage> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<CarGarage> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

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
	public java.util.List<CarGarage> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first car garage in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public CarGarage findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Returns the first car garage in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

	/**
	 * Returns the last car garage in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage
	 * @throws NoSuchCarGarageException if a matching car garage could not be found
	 */
	public CarGarage findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Returns the last car garage in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching car garage, or <code>null</code> if a matching car garage could not be found
	 */
	public CarGarage fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

	/**
	 * Returns the car garages before and after the current car garage in the ordered set where groupId = &#63;.
	 *
	 * @param carGarageId the primary key of the current car garage
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next car garage
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public CarGarage[] findByGroupId_PrevAndNext(
			long carGarageId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
				orderByComparator)
		throws NoSuchCarGarageException;

	/**
	 * Removes all the car garages where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of car garages where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching car garages
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the car garage in the entity cache if it is enabled.
	 *
	 * @param carGarage the car garage
	 */
	public void cacheResult(CarGarage carGarage);

	/**
	 * Caches the car garages in the entity cache if it is enabled.
	 *
	 * @param carGarages the car garages
	 */
	public void cacheResult(java.util.List<CarGarage> carGarages);

	/**
	 * Creates a new car garage with the primary key. Does not add the car garage to the database.
	 *
	 * @param carGarageId the primary key for the new car garage
	 * @return the new car garage
	 */
	public CarGarage create(long carGarageId);

	/**
	 * Removes the car garage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage that was removed
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public CarGarage remove(long carGarageId) throws NoSuchCarGarageException;

	public CarGarage updateImpl(CarGarage carGarage);

	/**
	 * Returns the car garage with the primary key or throws a <code>NoSuchCarGarageException</code> if it could not be found.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage
	 * @throws NoSuchCarGarageException if a car garage with the primary key could not be found
	 */
	public CarGarage findByPrimaryKey(long carGarageId)
		throws NoSuchCarGarageException;

	/**
	 * Returns the car garage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param carGarageId the primary key of the car garage
	 * @return the car garage, or <code>null</code> if a car garage with the primary key could not be found
	 */
	public CarGarage fetchByPrimaryKey(long carGarageId);

	/**
	 * Returns all the car garages.
	 *
	 * @return the car garages
	 */
	public java.util.List<CarGarage> findAll();

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
	public java.util.List<CarGarage> findAll(int start, int end);

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
	public java.util.List<CarGarage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator);

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
	public java.util.List<CarGarage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarGarage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the car garages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of car garages.
	 *
	 * @return the number of car garages
	 */
	public int countAll();

}