/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetail
 * @generated
 */
public class EmployeeDetailWrapper
	extends BaseModelWrapper<EmployeeDetail>
	implements EmployeeDetail, ModelWrapper<EmployeeDetail> {

	public EmployeeDetailWrapper(EmployeeDetail employeeDetail) {
		super(employeeDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("addressLine1", getAddressLine1());
		attributes.put("addressLine2", getAddressLine2());
		attributes.put("city", getCity());
		attributes.put("zipCode", getZipCode());
		attributes.put("designation", getDesignation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long phoneNumber = (Long)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String addressLine1 = (String)attributes.get("addressLine1");

		if (addressLine1 != null) {
			setAddressLine1(addressLine1);
		}

		String addressLine2 = (String)attributes.get("addressLine2");

		if (addressLine2 != null) {
			setAddressLine2(addressLine2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		Long zipCode = (Long)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}
	}

	@Override
	public EmployeeDetail cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address line1 of this employee detail.
	 *
	 * @return the address line1 of this employee detail
	 */
	@Override
	public String getAddressLine1() {
		return model.getAddressLine1();
	}

	/**
	 * Returns the address line2 of this employee detail.
	 *
	 * @return the address line2 of this employee detail
	 */
	@Override
	public String getAddressLine2() {
		return model.getAddressLine2();
	}

	/**
	 * Returns the city of this employee detail.
	 *
	 * @return the city of this employee detail
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this employee detail.
	 *
	 * @return the company ID of this employee detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee detail.
	 *
	 * @return the create date of this employee detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation of this employee detail.
	 *
	 * @return the designation of this employee detail
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the email of this employee detail.
	 *
	 * @return the email of this employee detail
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the employee ID of this employee detail.
	 *
	 * @return the employee ID of this employee detail
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the first name of this employee detail.
	 *
	 * @return the first name of this employee detail
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this employee detail.
	 *
	 * @return the group ID of this employee detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last name of this employee detail.
	 *
	 * @return the last name of this employee detail
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified date of this employee detail.
	 *
	 * @return the modified date of this employee detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone number of this employee detail.
	 *
	 * @return the phone number of this employee detail
	 */
	@Override
	public long getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this employee detail.
	 *
	 * @return the primary key of this employee detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this employee detail.
	 *
	 * @return the user ID of this employee detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this employee detail.
	 *
	 * @return the user name of this employee detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this employee detail.
	 *
	 * @return the user uuid of this employee detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this employee detail.
	 *
	 * @return the uuid of this employee detail
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the zip code of this employee detail.
	 *
	 * @return the zip code of this employee detail
	 */
	@Override
	public long getZipCode() {
		return model.getZipCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address line1 of this employee detail.
	 *
	 * @param addressLine1 the address line1 of this employee detail
	 */
	@Override
	public void setAddressLine1(String addressLine1) {
		model.setAddressLine1(addressLine1);
	}

	/**
	 * Sets the address line2 of this employee detail.
	 *
	 * @param addressLine2 the address line2 of this employee detail
	 */
	@Override
	public void setAddressLine2(String addressLine2) {
		model.setAddressLine2(addressLine2);
	}

	/**
	 * Sets the city of this employee detail.
	 *
	 * @param city the city of this employee detail
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this employee detail.
	 *
	 * @param companyId the company ID of this employee detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee detail.
	 *
	 * @param createDate the create date of this employee detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation of this employee detail.
	 *
	 * @param designation the designation of this employee detail
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the email of this employee detail.
	 *
	 * @param email the email of this employee detail
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the employee ID of this employee detail.
	 *
	 * @param employeeId the employee ID of this employee detail
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the first name of this employee detail.
	 *
	 * @param firstName the first name of this employee detail
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this employee detail.
	 *
	 * @param groupId the group ID of this employee detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last name of this employee detail.
	 *
	 * @param lastName the last name of this employee detail
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified date of this employee detail.
	 *
	 * @param modifiedDate the modified date of this employee detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone number of this employee detail.
	 *
	 * @param phoneNumber the phone number of this employee detail
	 */
	@Override
	public void setPhoneNumber(long phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this employee detail.
	 *
	 * @param primaryKey the primary key of this employee detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this employee detail.
	 *
	 * @param userId the user ID of this employee detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this employee detail.
	 *
	 * @param userName the user name of this employee detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this employee detail.
	 *
	 * @param userUuid the user uuid of this employee detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this employee detail.
	 *
	 * @param uuid the uuid of this employee detail
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the zip code of this employee detail.
	 *
	 * @param zipCode the zip code of this employee detail
	 */
	@Override
	public void setZipCode(long zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EmployeeDetailWrapper wrap(EmployeeDetail employeeDetail) {
		return new EmployeeDetailWrapper(employeeDetail);
	}

}