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
 * This class is a wrapper for {@link CarGarageProduct}.
 * </p>
 *
 * @author Gavin Hinfey
 * @see CarGarageProduct
 * @generated
 */
@ProviderType
public class CarGarageProductWrapper
	implements CarGarageProduct, ModelWrapper<CarGarageProduct> {

	public CarGarageProductWrapper(CarGarageProduct carGarageProduct) {
		_carGarageProduct = carGarageProduct;
	}

	@Override
	public Class<?> getModelClass() {
		return CarGarageProduct.class;
	}

	@Override
	public String getModelClassName() {
		return CarGarageProduct.class.getName();
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

	@Override
	public Object clone() {
		return new CarGarageProductWrapper(
			(CarGarageProduct)_carGarageProduct.clone());
	}

	@Override
	public int compareTo(
		commerce.training.car.garage.model.CarGarageProduct carGarageProduct) {

		return _carGarageProduct.compareTo(carGarageProduct);
	}

	/**
	 * Returns the car garage ID of this car garage product.
	 *
	 * @return the car garage ID of this car garage product
	 */
	@Override
	public long getCarGarageId() {
		return _carGarageProduct.getCarGarageId();
	}

	/**
	 * Returns the car garage product ID of this car garage product.
	 *
	 * @return the car garage product ID of this car garage product
	 */
	@Override
	public long getCarGarageProductId() {
		return _carGarageProduct.getCarGarageProductId();
	}

	/**
	 * Returns the company ID of this car garage product.
	 *
	 * @return the company ID of this car garage product
	 */
	@Override
	public long getCompanyId() {
		return _carGarageProduct.getCompanyId();
	}

	/**
	 * Returns the cp definition ID of this car garage product.
	 *
	 * @return the cp definition ID of this car garage product
	 */
	@Override
	public long getCpDefinitionId() {
		return _carGarageProduct.getCpDefinitionId();
	}

	/**
	 * Returns the create date of this car garage product.
	 *
	 * @return the create date of this car garage product
	 */
	@Override
	public Date getCreateDate() {
		return _carGarageProduct.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _carGarageProduct.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this car garage product.
	 *
	 * @return the group ID of this car garage product
	 */
	@Override
	public long getGroupId() {
		return _carGarageProduct.getGroupId();
	}

	/**
	 * Returns the modified date of this car garage product.
	 *
	 * @return the modified date of this car garage product
	 */
	@Override
	public Date getModifiedDate() {
		return _carGarageProduct.getModifiedDate();
	}

	/**
	 * Returns the primary key of this car garage product.
	 *
	 * @return the primary key of this car garage product
	 */
	@Override
	public long getPrimaryKey() {
		return _carGarageProduct.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _carGarageProduct.getPrimaryKeyObj();
	}

	/**
	 * Returns the title of this car garage product.
	 *
	 * @return the title of this car garage product
	 */
	@Override
	public String getTitle() {
		return _carGarageProduct.getTitle();
	}

	/**
	 * Returns the user ID of this car garage product.
	 *
	 * @return the user ID of this car garage product
	 */
	@Override
	public long getUserId() {
		return _carGarageProduct.getUserId();
	}

	/**
	 * Returns the user name of this car garage product.
	 *
	 * @return the user name of this car garage product
	 */
	@Override
	public String getUserName() {
		return _carGarageProduct.getUserName();
	}

	/**
	 * Returns the user uuid of this car garage product.
	 *
	 * @return the user uuid of this car garage product
	 */
	@Override
	public String getUserUuid() {
		return _carGarageProduct.getUserUuid();
	}

	/**
	 * Returns the uuid of this car garage product.
	 *
	 * @return the uuid of this car garage product
	 */
	@Override
	public String getUuid() {
		return _carGarageProduct.getUuid();
	}

	@Override
	public int hashCode() {
		return _carGarageProduct.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _carGarageProduct.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _carGarageProduct.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _carGarageProduct.isNew();
	}

	@Override
	public void persist() {
		_carGarageProduct.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_carGarageProduct.setCachedModel(cachedModel);
	}

	/**
	 * Sets the car garage ID of this car garage product.
	 *
	 * @param carGarageId the car garage ID of this car garage product
	 */
	@Override
	public void setCarGarageId(long carGarageId) {
		_carGarageProduct.setCarGarageId(carGarageId);
	}

	/**
	 * Sets the car garage product ID of this car garage product.
	 *
	 * @param carGarageProductId the car garage product ID of this car garage product
	 */
	@Override
	public void setCarGarageProductId(long carGarageProductId) {
		_carGarageProduct.setCarGarageProductId(carGarageProductId);
	}

	/**
	 * Sets the company ID of this car garage product.
	 *
	 * @param companyId the company ID of this car garage product
	 */
	@Override
	public void setCompanyId(long companyId) {
		_carGarageProduct.setCompanyId(companyId);
	}

	/**
	 * Sets the cp definition ID of this car garage product.
	 *
	 * @param cpDefinitionId the cp definition ID of this car garage product
	 */
	@Override
	public void setCpDefinitionId(long cpDefinitionId) {
		_carGarageProduct.setCpDefinitionId(cpDefinitionId);
	}

	/**
	 * Sets the create date of this car garage product.
	 *
	 * @param createDate the create date of this car garage product
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_carGarageProduct.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_carGarageProduct.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_carGarageProduct.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_carGarageProduct.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this car garage product.
	 *
	 * @param groupId the group ID of this car garage product
	 */
	@Override
	public void setGroupId(long groupId) {
		_carGarageProduct.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this car garage product.
	 *
	 * @param modifiedDate the modified date of this car garage product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_carGarageProduct.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_carGarageProduct.setNew(n);
	}

	/**
	 * Sets the primary key of this car garage product.
	 *
	 * @param primaryKey the primary key of this car garage product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_carGarageProduct.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_carGarageProduct.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the title of this car garage product.
	 *
	 * @param title the title of this car garage product
	 */
	@Override
	public void setTitle(String title) {
		_carGarageProduct.setTitle(title);
	}

	/**
	 * Sets the user ID of this car garage product.
	 *
	 * @param userId the user ID of this car garage product
	 */
	@Override
	public void setUserId(long userId) {
		_carGarageProduct.setUserId(userId);
	}

	/**
	 * Sets the user name of this car garage product.
	 *
	 * @param userName the user name of this car garage product
	 */
	@Override
	public void setUserName(String userName) {
		_carGarageProduct.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this car garage product.
	 *
	 * @param userUuid the user uuid of this car garage product
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_carGarageProduct.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this car garage product.
	 *
	 * @param uuid the uuid of this car garage product
	 */
	@Override
	public void setUuid(String uuid) {
		_carGarageProduct.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<commerce.training.car.garage.model.CarGarageProduct> toCacheModel() {

		return _carGarageProduct.toCacheModel();
	}

	@Override
	public commerce.training.car.garage.model.CarGarageProduct
		toEscapedModel() {

		return new CarGarageProductWrapper(_carGarageProduct.toEscapedModel());
	}

	@Override
	public String toString() {
		return _carGarageProduct.toString();
	}

	@Override
	public commerce.training.car.garage.model.CarGarageProduct
		toUnescapedModel() {

		return new CarGarageProductWrapper(
			_carGarageProduct.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _carGarageProduct.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CarGarageProductWrapper)) {
			return false;
		}

		CarGarageProductWrapper carGarageProductWrapper =
			(CarGarageProductWrapper)obj;

		if (Objects.equals(
				_carGarageProduct, carGarageProductWrapper._carGarageProduct)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _carGarageProduct.getStagedModelType();
	}

	@Override
	public CarGarageProduct getWrappedModel() {
		return _carGarageProduct;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _carGarageProduct.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _carGarageProduct.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_carGarageProduct.resetOriginalValues();
	}

	private final CarGarageProduct _carGarageProduct;

}