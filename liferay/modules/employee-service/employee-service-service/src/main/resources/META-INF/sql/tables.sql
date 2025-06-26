create table IgnekIntranet_EmployeeDetail (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	phoneNumber LONG,
	addressLine1 VARCHAR(75) null,
	addressLine2 VARCHAR(75) null,
	city VARCHAR(75) null,
	zipCode LONG,
	designation VARCHAR(75) null
);