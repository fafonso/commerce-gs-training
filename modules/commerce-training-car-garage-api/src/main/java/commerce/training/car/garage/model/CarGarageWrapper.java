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

package commerce.training.car.garage.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CarGarage}.
 * </p>
 *
 * @author Gavin Hinfey
 * @see CarGarage
 * @generated
 */
@ProviderType
public class CarGarageWrapper implements CarGarage, ModelWrapper<CarGarage> {

	public CarGarageWrapper(CarGarage carGarage) {
		_carGarage = carGarage;
	}

	@Override
	public Class<?> getModelClass() {
		return CarGarage.class;
	}

	@Override
	public String getModelClassName() {
		return CarGarage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("carGarageId", getCarGarageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("cpDefinitionId", getCpDefinitionId());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long carGarageId = (Long)attributes.get("carGarageId");

		if (carGarageId != null) {
			setCarGarageId(carGarageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long cpDefinitionId = (Long)attributes.get("cpDefinitionId");

		if (cpDefinitionId != null) {
			setCpDefinitionId(cpDefinitionId);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}
	}

	@Override
	public Object clone() {
		return new CarGarageWrapper((CarGarage)_carGarage.clone());
	}

	@Override
	public int compareTo(
		commerce.training.car.garage.model.CarGarage carGarage) {

		return _carGarage.compareTo(carGarage);
	}

	/**
	 * Returns the car garage ID of this car garage.
	 *
	 * @return the car garage ID of this car garage
	 */
	@Override
	public long getCarGarageId() {
		return _carGarage.getCarGarageId();
	}

	/**
	 * Returns the company ID of this car garage.
	 *
	 * @return the company ID of this car garage
	 */
	@Override
	public long getCompanyId() {
		return _carGarage.getCompanyId();
	}

	/**
	 * Returns the cp definition ID of this car garage.
	 *
	 * @return the cp definition ID of this car garage
	 */
	@Override
	public long getCpDefinitionId() {
		return _carGarage.getCpDefinitionId();
	}

	/**
	 * Returns the create date of this car garage.
	 *
	 * @return the create date of this car garage
	 */
	@Override
	public Date getCreateDate() {
		return _carGarage.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _carGarage.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this car garage.
	 *
	 * @return the group ID of this car garage
	 */
	@Override
	public long getGroupId() {
		return _carGarage.getGroupId();
	}

	/**
	 * Returns the latitude of this car garage.
	 *
	 * @return the latitude of this car garage
	 */
	@Override
	public double getLatitude() {
		return _carGarage.getLatitude();
	}

	/**
	 * Returns the longitude of this car garage.
	 *
	 * @return the longitude of this car garage
	 */
	@Override
	public double getLongitude() {
		return _carGarage.getLongitude();
	}

	/**
	 * Returns the modified date of this car garage.
	 *
	 * @return the modified date of this car garage
	 */
	@Override
	public Date getModifiedDate() {
		return _carGarage.getModifiedDate();
	}

	/**
	 * Returns the primary key of this car garage.
	 *
	 * @return the primary key of this car garage
	 */
	@Override
	public long getPrimaryKey() {
		return _carGarage.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _carGarage.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this car garage.
	 *
	 * @return the user ID of this car garage
	 */
	@Override
	public long getUserId() {
		return _carGarage.getUserId();
	}

	/**
	 * Returns the user name of this car garage.
	 *
	 * @return the user name of this car garage
	 */
	@Override
	public String getUserName() {
		return _carGarage.getUserName();
	}

	/**
	 * Returns the user uuid of this car garage.
	 *
	 * @return the user uuid of this car garage
	 */
	@Override
	public String getUserUuid() {
		return _carGarage.getUserUuid();
	}

	/**
	 * Returns the uuid of this car garage.
	 *
	 * @return the uuid of this car garage
	 */
	@Override
	public String getUuid() {
		return _carGarage.getUuid();
	}

	@Override
	public int hashCode() {
		return _carGarage.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _carGarage.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _carGarage.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _carGarage.isNew();
	}

	@Override
	public void persist() {
		_carGarage.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_carGarage.setCachedModel(cachedModel);
	}

	/**
	 * Sets the car garage ID of this car garage.
	 *
	 * @param carGarageId the car garage ID of this car garage
	 */
	@Override
	public void setCarGarageId(long carGarageId) {
		_carGarage.setCarGarageId(carGarageId);
	}

	/**
	 * Sets the company ID of this car garage.
	 *
	 * @param companyId the company ID of this car garage
	 */
	@Override
	public void setCompanyId(long companyId) {
		_carGarage.setCompanyId(companyId);
	}

	/**
	 * Sets the cp definition ID of this car garage.
	 *
	 * @param cpDefinitionId the cp definition ID of this car garage
	 */
	@Override
	public void setCpDefinitionId(long cpDefinitionId) {
		_carGarage.setCpDefinitionId(cpDefinitionId);
	}

	/**
	 * Sets the create date of this car garage.
	 *
	 * @param createDate the create date of this car garage
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_carGarage.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_carGarage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_carGarage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_carGarage.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this car garage.
	 *
	 * @param groupId the group ID of this car garage
	 */
	@Override
	public void setGroupId(long groupId) {
		_carGarage.setGroupId(groupId);
	}

	/**
	 * Sets the latitude of this car garage.
	 *
	 * @param latitude the latitude of this car garage
	 */
	@Override
	public void setLatitude(double latitude) {
		_carGarage.setLatitude(latitude);
	}

	/**
	 * Sets the longitude of this car garage.
	 *
	 * @param longitude the longitude of this car garage
	 */
	@Override
	public void setLongitude(double longitude) {
		_carGarage.setLongitude(longitude);
	}

	/**
	 * Sets the modified date of this car garage.
	 *
	 * @param modifiedDate the modified date of this car garage
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_carGarage.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_carGarage.setNew(n);
	}

	/**
	 * Sets the primary key of this car garage.
	 *
	 * @param primaryKey the primary key of this car garage
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_carGarage.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_carGarage.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this car garage.
	 *
	 * @param userId the user ID of this car garage
	 */
	@Override
	public void setUserId(long userId) {
		_carGarage.setUserId(userId);
	}

	/**
	 * Sets the user name of this car garage.
	 *
	 * @param userName the user name of this car garage
	 */
	@Override
	public void setUserName(String userName) {
		_carGarage.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this car garage.
	 *
	 * @param userUuid the user uuid of this car garage
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_carGarage.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this car garage.
	 *
	 * @param uuid the uuid of this car garage
	 */
	@Override
	public void setUuid(String uuid) {
		_carGarage.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<commerce.training.car.garage.model.CarGarage> toCacheModel() {

		return _carGarage.toCacheModel();
	}

	@Override
	public commerce.training.car.garage.model.CarGarage toEscapedModel() {
		return new CarGarageWrapper(_carGarage.toEscapedModel());
	}

	@Override
	public String toString() {
		return _carGarage.toString();
	}

	@Override
	public commerce.training.car.garage.model.CarGarage toUnescapedModel() {
		return new CarGarageWrapper(_carGarage.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _carGarage.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CarGarageWrapper)) {
			return false;
		}

		CarGarageWrapper carGarageWrapper = (CarGarageWrapper)obj;

		if (Objects.equals(_carGarage, carGarageWrapper._carGarage)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _carGarage.getStagedModelType();
	}

	@Override
	public CarGarage getWrappedModel() {
		return _carGarage;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _carGarage.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _carGarage.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_carGarage.resetOriginalValues();
	}

	private final CarGarage _carGarage;

}