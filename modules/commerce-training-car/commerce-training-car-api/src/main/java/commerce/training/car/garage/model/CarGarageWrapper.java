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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CarGarage}.
 * </p>
 *
 * @author Roselaine Marques
 * @see CarGarage
 * @generated
 */
public class CarGarageWrapper
	extends BaseModelWrapper<CarGarage>
	implements CarGarage, ModelWrapper<CarGarage> {

	public CarGarageWrapper(CarGarage carGarage) {
		super(carGarage);
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
		attributes.put("title", getTitle());
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
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

	/**
	 * Returns the car garage ID of this car garage.
	 *
	 * @return the car garage ID of this car garage
	 */
	@Override
	public long getCarGarageId() {
		return model.getCarGarageId();
	}

	/**
	 * Returns the company ID of this car garage.
	 *
	 * @return the company ID of this car garage
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cp definition ID of this car garage.
	 *
	 * @return the cp definition ID of this car garage
	 */
	@Override
	public long getCpDefinitionId() {
		return model.getCpDefinitionId();
	}

	/**
	 * Returns the create date of this car garage.
	 *
	 * @return the create date of this car garage
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this car garage.
	 *
	 * @return the group ID of this car garage
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the latitude of this car garage.
	 *
	 * @return the latitude of this car garage
	 */
	@Override
	public double getLatitude() {
		return model.getLatitude();
	}

	/**
	 * Returns the longitude of this car garage.
	 *
	 * @return the longitude of this car garage
	 */
	@Override
	public double getLongitude() {
		return model.getLongitude();
	}

	/**
	 * Returns the modified date of this car garage.
	 *
	 * @return the modified date of this car garage
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this car garage.
	 *
	 * @return the primary key of this car garage
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this car garage.
	 *
	 * @return the title of this car garage
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this car garage.
	 *
	 * @return the user ID of this car garage
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this car garage.
	 *
	 * @return the user name of this car garage
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this car garage.
	 *
	 * @return the user uuid of this car garage
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this car garage.
	 *
	 * @return the uuid of this car garage
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the car garage ID of this car garage.
	 *
	 * @param carGarageId the car garage ID of this car garage
	 */
	@Override
	public void setCarGarageId(long carGarageId) {
		model.setCarGarageId(carGarageId);
	}

	/**
	 * Sets the company ID of this car garage.
	 *
	 * @param companyId the company ID of this car garage
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cp definition ID of this car garage.
	 *
	 * @param cpDefinitionId the cp definition ID of this car garage
	 */
	@Override
	public void setCpDefinitionId(long cpDefinitionId) {
		model.setCpDefinitionId(cpDefinitionId);
	}

	/**
	 * Sets the create date of this car garage.
	 *
	 * @param createDate the create date of this car garage
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this car garage.
	 *
	 * @param groupId the group ID of this car garage
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the latitude of this car garage.
	 *
	 * @param latitude the latitude of this car garage
	 */
	@Override
	public void setLatitude(double latitude) {
		model.setLatitude(latitude);
	}

	/**
	 * Sets the longitude of this car garage.
	 *
	 * @param longitude the longitude of this car garage
	 */
	@Override
	public void setLongitude(double longitude) {
		model.setLongitude(longitude);
	}

	/**
	 * Sets the modified date of this car garage.
	 *
	 * @param modifiedDate the modified date of this car garage
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this car garage.
	 *
	 * @param primaryKey the primary key of this car garage
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this car garage.
	 *
	 * @param title the title of this car garage
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this car garage.
	 *
	 * @param userId the user ID of this car garage
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this car garage.
	 *
	 * @param userName the user name of this car garage
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this car garage.
	 *
	 * @param userUuid the user uuid of this car garage
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this car garage.
	 *
	 * @param uuid the uuid of this car garage
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CarGarageWrapper wrap(CarGarage carGarage) {
		return new CarGarageWrapper(carGarage);
	}

}