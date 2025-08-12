/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.model.impl;

import com.employee.service.model.EmployeeDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDetailCacheModel
	implements CacheModel<EmployeeDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDetailCacheModel)) {
			return false;
		}

		EmployeeDetailCacheModel employeeDetailCacheModel =
			(EmployeeDetailCacheModel)object;

		if (employeeId == employeeDetailCacheModel.employeeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeeId=");
		sb.append(employeeId);
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
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", addressLine1=");
		sb.append(addressLine1);
		sb.append(", addressLine2=");
		sb.append(addressLine2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", designation=");
		sb.append(designation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDetail toEntityModel() {
		EmployeeDetailImpl employeeDetailImpl = new EmployeeDetailImpl();

		if (uuid == null) {
			employeeDetailImpl.setUuid("");
		}
		else {
			employeeDetailImpl.setUuid(uuid);
		}

		employeeDetailImpl.setEmployeeId(employeeId);
		employeeDetailImpl.setGroupId(groupId);
		employeeDetailImpl.setCompanyId(companyId);
		employeeDetailImpl.setUserId(userId);

		if (userName == null) {
			employeeDetailImpl.setUserName("");
		}
		else {
			employeeDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeDetailImpl.setCreateDate(null);
		}
		else {
			employeeDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDetailImpl.setModifiedDate(null);
		}
		else {
			employeeDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			employeeDetailImpl.setFirstName("");
		}
		else {
			employeeDetailImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			employeeDetailImpl.setLastName("");
		}
		else {
			employeeDetailImpl.setLastName(lastName);
		}

		if (email == null) {
			employeeDetailImpl.setEmail("");
		}
		else {
			employeeDetailImpl.setEmail(email);
		}

		employeeDetailImpl.setPhoneNumber(phoneNumber);

		if (addressLine1 == null) {
			employeeDetailImpl.setAddressLine1("");
		}
		else {
			employeeDetailImpl.setAddressLine1(addressLine1);
		}

		if (addressLine2 == null) {
			employeeDetailImpl.setAddressLine2("");
		}
		else {
			employeeDetailImpl.setAddressLine2(addressLine2);
		}

		if (city == null) {
			employeeDetailImpl.setCity("");
		}
		else {
			employeeDetailImpl.setCity(city);
		}

		employeeDetailImpl.setZipCode(zipCode);

		if (designation == null) {
			employeeDetailImpl.setDesignation("");
		}
		else {
			employeeDetailImpl.setDesignation(designation);
		}

		employeeDetailImpl.resetOriginalValues();

		return employeeDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();

		phoneNumber = objectInput.readLong();
		addressLine1 = objectInput.readUTF();
		addressLine2 = objectInput.readUTF();
		city = objectInput.readUTF();

		zipCode = objectInput.readLong();
		designation = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeeId);

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

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(phoneNumber);

		if (addressLine1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressLine1);
		}

		if (addressLine2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressLine2);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		objectOutput.writeLong(zipCode);

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}
	}

	public String uuid;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String email;
	public long phoneNumber;
	public String addressLine1;
	public String addressLine2;
	public String city;
	public long zipCode;
	public String designation;

}