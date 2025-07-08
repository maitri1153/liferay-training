package com.employee.rest.client.dto.v1_0;

import com.employee.rest.client.function.UnsafeSupplier;
import com.employee.rest.client.serdes.v1_0.EmployeeDetailObjectSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author ignek
 * @generated
 */
@Generated("")
public class EmployeeDetailObject implements Cloneable, Serializable {

	public static EmployeeDetailObject toDTO(String json) {
		return EmployeeDetailObjectSerDes.toDTO(json);
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine1(
		UnsafeSupplier<String, Exception> addressLine1UnsafeSupplier) {

		try {
			addressLine1 = addressLine1UnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String addressLine1;

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setAddressLine2(
		UnsafeSupplier<String, Exception> addressLine2UnsafeSupplier) {

		try {
			addressLine2 = addressLine2UnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String addressLine2;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCity(UnsafeSupplier<String, Exception> cityUnsafeSupplier) {
		try {
			city = cityUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String city;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setDesignation(
		UnsafeSupplier<String, Exception> designationUnsafeSupplier) {

		try {
			designation = designationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String designation;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String email;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeId(
		UnsafeSupplier<Long, Exception> employeeIdUnsafeSupplier) {

		try {
			employeeId = employeeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long employeeId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFirstName(
		UnsafeSupplier<String, Exception> firstNameUnsafeSupplier) {

		try {
			firstName = firstNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String firstName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLastName(
		UnsafeSupplier<String, Exception> lastNameUnsafeSupplier) {

		try {
			lastName = lastNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String lastName;

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPhoneNumber(
		UnsafeSupplier<Long, Exception> phoneNumberUnsafeSupplier) {

		try {
			phoneNumber = phoneNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long phoneNumber;

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	public void setZipCode(
		UnsafeSupplier<Long, Exception> zipCodeUnsafeSupplier) {

		try {
			zipCode = zipCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long zipCode;

	@Override
	public EmployeeDetailObject clone() throws CloneNotSupportedException {
		return (EmployeeDetailObject)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDetailObject)) {
			return false;
		}

		EmployeeDetailObject employeeDetailObject =
			(EmployeeDetailObject)object;

		return Objects.equals(toString(), employeeDetailObject.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return EmployeeDetailObjectSerDes.toJSON(this);
	}

}