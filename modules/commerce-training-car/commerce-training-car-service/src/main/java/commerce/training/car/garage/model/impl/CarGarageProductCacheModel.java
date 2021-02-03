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

import commerce.training.car.garage.model.CarGarageProduct;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CarGarageProduct in entity cache.
 *
 * @author Roselaine Marques
 * @generated
 */
public class CarGarageProductCacheModel
	implements CacheModel<CarGarageProduct>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CarGarageProductCacheModel)) {
			return false;
		}

		CarGarageProductCacheModel carGarageProductCacheModel =
			(CarGarageProductCacheModel)obj;

		if (carGarageProductId ==
				carGarageProductCacheModel.carGarageProductId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, carGarageProductId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", carGarageProductId=");
		sb.append(carGarageProductId);
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
		sb.append(", carGarageId=");
		sb.append(carGarageId);
		sb.append(", cpDefinitionId=");
		sb.append(cpDefinitionId);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CarGarageProduct toEntityModel() {
		CarGarageProductImpl carGarageProductImpl = new CarGarageProductImpl();

		if (uuid == null) {
			carGarageProductImpl.setUuid("");
		}
		else {
			carGarageProductImpl.setUuid(uuid);
		}

		carGarageProductImpl.setCarGarageProductId(carGarageProductId);
		carGarageProductImpl.setGroupId(groupId);
		carGarageProductImpl.setCompanyId(companyId);
		carGarageProductImpl.setUserId(userId);

		if (userName == null) {
			carGarageProductImpl.setUserName("");
		}
		else {
			carGarageProductImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			carGarageProductImpl.setCreateDate(null);
		}
		else {
			carGarageProductImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			carGarageProductImpl.setModifiedDate(null);
		}
		else {
			carGarageProductImpl.setModifiedDate(new Date(modifiedDate));
		}

		carGarageProductImpl.setCarGarageId(carGarageId);
		carGarageProductImpl.setCpDefinitionId(cpDefinitionId);

		if (title == null) {
			carGarageProductImpl.setTitle("");
		}
		else {
			carGarageProductImpl.setTitle(title);
		}

		carGarageProductImpl.resetOriginalValues();

		return carGarageProductImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		carGarageProductId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		carGarageId = objectInput.readLong();

		cpDefinitionId = objectInput.readLong();
		title = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(carGarageProductId);

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

		objectOutput.writeLong(carGarageId);

		objectOutput.writeLong(cpDefinitionId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}
	}

	public String uuid;
	public long carGarageProductId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long carGarageId;
	public long cpDefinitionId;
	public String title;

}