create table CarGarage (
	uuid_ VARCHAR(75) null,
	carGarageId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	cpDefinitionId LONG,
	title VARCHAR(75) null,
	latitude DOUBLE,
	longitude DOUBLE
);

create table CarGarageProduct (
	uuid_ VARCHAR(75) null,
	carGarageProductId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	carGarageId LONG,
	cpDefinitionId LONG,
	title VARCHAR(75) null
);