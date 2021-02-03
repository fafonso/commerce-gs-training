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
 * This class is a wrapper for {@link CarGarageProduct}.
 * </p>
 *
 * @author Roselaine Marques
 * @see CarGarageProduct
 * @generated
 */
public class CarGarageProductWrapper
	extends BaseModelWrapper<CarGarageProduct>
	implements CarGarageProduct, ModelWrapper<CarGarageProduct> {

	public CarGarageProductWrapper(CarGarageProduct carGarageProduct) {
		super(carGarageProduct);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("carGarageProductId", getCarGarageProductId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("carGarageId", getCarGarageId());
		attributes.put("cpDefinitionId", getCpDefinitionId());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long carGarageProductId = (Long)attributes.get("carGarageProductId");

		if (carGarageProductId != null) {
			setCarGarageProductId(carGarageProductId);
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

		Long carGarageId = (Long)attributes.get("carGarageId");

		if (carGarageId != null) {
			setCarGarageId(carGarageId);
		}

		Long cpDefinitionId = (Long)attributes.get("cpDefinitionId");

		if (cpDefinitionId != null) {
			setCpDefinitionId(cpDefinitionId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	/**
	 * Returns the car garage ID of this car garage product.
	 *
	 * @return the car garage ID of this car garage product
	 */
	@Override
	public long getCarGarageId() {
		return model.getCarGarageId();
	}

	/**
	 * Returns the car garage product ID of this car garage product.
	 *
	 * @return the car garage product ID of this car garage product
	 */
	@Override
	public long getCarGarageProductId() {
		return model.getCarGarageProductId();
	}

	/**
	 * Returns the company ID of this car garage product.
	 *
	 * @return the company ID of this car garage product
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cp definition ID of this car garage product.
	 *
	 * @return the cp definition ID of this car garage product
	 */
	@Override
	public long getCpDefinitionId() {
		return model.getCpDefinitionId();
	}

	/**
	 * Returns the create date of this car garage product.
	 *
	 * @return the create date of this car garage product
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this car garage product.
	 *
	 * @return the group ID of this car garage product
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this car garage product.
	 *
	 * @return the modified date of this car garage product
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this car garage product.
	 *
	 * @return the primary key of this car garage product
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this car garage product.
	 *
	 * @return the title of this car garage product
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this car garage product.
	 *
	 * @return the user ID of this car garage product
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this car garage product.
	 *
	 * @return the user name of this car garage product
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this car garage product.
	 *
	 * @return the user uuid of this car garage product
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this car garage product.
	 *
	 * @return the uuid of this car garage product
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
	 * Sets the car garage ID of this car garage product.
	 *
	 * @param carGarageId the car garage ID of this car garage product
	 */
	@Override
	public void setCarGarageId(long carGarageId) {
		model.setCarGarageId(carGarageId);
	}

	/**
	 * Sets the car garage product ID of this car garage product.
	 *
	 * @param carGarageProductId the car garage product ID of this car garage product
	 */
	@Override
	public void setCarGarageProductId(long carGarageProductId) {
		model.setCarGarageProductId(carGarageProductId);
	}

	/**
	 * Sets the company ID of this car garage product.
	 *
	 * @param companyId the company ID of this car garage product
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cp definition ID of this car garage product.
	 *
	 * @param cpDefinitionId the cp definition ID of this car garage product
	 */
	@Override
	public void setCpDefinitionId(long cpDefinitionId) {
		model.setCpDefinitionId(cpDefinitionId);
	}

	/**
	 * Sets the create date of this car garage product.
	 *
	 * @param createDate the create date of this car garage product
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this car garage product.
	 *
	 * @param groupId the group ID of this car garage product
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this car garage product.
	 *
	 * @param modifiedDate the modified date of this car garage product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this car garage product.
	 *
	 * @param primaryKey the primary key of this car garage product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this car garage product.
	 *
	 * @param title the title of this car garage product
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this car garage product.
	 *
	 * @param userId the user ID of this car garage product
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this car garage product.
	 *
	 * @param userName the user name of this car garage product
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this car garage product.
	 *
	 * @param userUuid the user uuid of this car garage product
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this car garage product.
	 *
	 * @param uuid the uuid of this car garage product
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
	protected CarGarageProductWrapper wrap(CarGarageProduct carGarageProduct) {
		return new CarGarageProductWrapper(carGarageProduct);
	}

}