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

package commerce.training.car.garage.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import commerce.training.car.garage.model.CarGarage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CarGarage in entity cache.
 *
 * @author Roselaine Marques
 * @generated
 */
public class CarGarageCacheModel
	implements CacheModel<CarGarage>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CarGarageCacheModel)) {
			return false;
		}

		CarGarageCacheModel carGarageCacheModel = (CarGarageCacheModel)obj;

		if (carGarageId == carGarageCacheModel.carGarageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, carGarageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", carGarageId=");
		sb.append(carGarageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", cpDefinitionId=");
		sb.append(cpDefinitionId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CarGarage toEntityModel() {
		CarGarageImpl carGarageImpl = new CarGarageImpl();

		if (uuid == null) {
			carGarageImpl.setUuid("");
		}
		else {
			carGarageImpl.setUuid(uuid);
		}

		carGarageImpl.setCarGarageId(carGarageId);
		carGarageImpl.setGroupId(groupId);
		carGarageImpl.setCompanyId(companyId);
		carGarageImpl.setUserId(userId);

		if (userName == null) {
			carGarageImpl.setUserName("");
		}
		else {
			carGarageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			carGarageImpl.setCreateDate(null);
		}
		else {
			carGarageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			carGarageImpl.setModifiedDate(null);
		}
		else {
			carGarageImpl.setModifiedDate(new Date(modifiedDate));
		}

		carGarageImpl.setCpDefinitionId(cpDefinitionId);

		if (title == null) {
			carGarageImpl.setTitle("");
		}
		else {
			carGarageImpl.setTitle(title);
		}

		carGarageImpl.setLatitude(latitude);
		carGarageImpl.setLongitude(longitude);

		carGarageImpl.resetOriginalValues();

		return carGarageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		carGarageId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		cpDefinitionId = objectInput.readLong();
		title = objectInput.readUTF();

		latitude = objectInput.readDouble();

		longitude = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(carGarageId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(cpDefinitionId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeDouble(latitude);

		objectOutput.writeDouble(longitude);
	}

	public String uuid;
	public long carGarageId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long cpDefinitionId;
	public String title;
	public double latitude;
	public double longitude;

}