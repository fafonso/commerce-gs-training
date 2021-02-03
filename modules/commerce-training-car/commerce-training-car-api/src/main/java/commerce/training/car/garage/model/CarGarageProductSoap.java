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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Roselaine Marques
 * @generated
 */
public class CarGarageProductSoap implements Serializable {

	public static CarGarageProductSoap toSoapModel(CarGarageProduct model) {
		CarGarageProductSoap soapModel = new CarGarageProductSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCarGarageProductId(model.getCarGarageProductId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCarGarageId(model.getCarGarageId());
		soapModel.setCpDefinitionId(model.getCpDefinitionId());
		soapModel.setTitle(model.getTitle());

		return soapModel;
	}

	public static CarGarageProductSoap[] toSoapModels(
		CarGarageProduct[] models) {

		CarGarageProductSoap[] soapModels =
			new CarGarageProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CarGarageProductSoap[][] toSoapModels(
		CarGarageProduct[][] models) {

		CarGarageProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CarGarageProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CarGarageProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CarGarageProductSoap[] toSoapModels(
		List<CarGarageProduct> models) {

		List<CarGarageProductSoap> soapModels =
			new ArrayList<CarGarageProductSoap>(models.size());

		for (CarGarageProduct model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CarGarageProductSoap[soapModels.size()]);
	}

	public CarGarageProductSoap() {
	}

	public long getPrimaryKey() {
		return _carGarageProductId;
	}

	public void setPrimaryKey(long pk) {
		setCarGarageProductId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCarGarageProductId() {
		return _carGarageProductId;
	}

	public void setCarGarageProductId(long carGarageProductId) {
		_carGarageProductId = carGarageProductId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCarGarageId() {
		return _carGarageId;
	}

	public void setCarGarageId(long carGarageId) {
		_carGarageId = carGarageId;
	}

	public long getCpDefinitionId() {
		return _cpDefinitionId;
	}

	public void setCpDefinitionId(long cpDefinitionId) {
		_cpDefinitionId = cpDefinitionId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private String _uuid;
	private long _carGarageProductId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _carGarageId;
	private long _cpDefinitionId;
	private String _title;

}