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
public class CarGarageSoap implements Serializable {

	public static CarGarageSoap toSoapModel(CarGarage model) {
		CarGarageSoap soapModel = new CarGarageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCarGarageId(model.getCarGarageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCpDefinitionId(model.getCpDefinitionId());
		soapModel.setTitle(model.getTitle());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());

		return soapModel;
	}

	public static CarGarageSoap[] toSoapModels(CarGarage[] models) {
		CarGarageSoap[] soapModels = new CarGarageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CarGarageSoap[][] toSoapModels(CarGarage[][] models) {
		CarGarageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CarGarageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CarGarageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CarGarageSoap[] toSoapModels(List<CarGarage> models) {
		List<CarGarageSoap> soapModels = new ArrayList<CarGarageSoap>(
			models.size());

		for (CarGarage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CarGarageSoap[soapModels.size()]);
	}

	public CarGarageSoap() {
	}

	public long getPrimaryKey() {
		return _carGarageId;
	}

	public void setPrimaryKey(long pk) {
		setCarGarageId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCarGarageId() {
		return _carGarageId;
	}

	public void setCarGarageId(long carGarageId) {
		_carGarageId = carGarageId;
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

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	private String _uuid;
	private long _carGarageId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _cpDefinitionId;
	private String _title;
	private double _latitude;
	private double _longitude;

}