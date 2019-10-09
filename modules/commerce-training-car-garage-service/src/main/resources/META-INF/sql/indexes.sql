create index IX_D933D890 on CarGarage (cpDefinitionId);
create index IX_F5755CC9 on CarGarage (groupId);
create index IX_ADD44CB5 on CarGarage (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5E027C77 on CarGarage (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CB26C44C on CarGarageProduct (carGarageId);
create index IX_83646AAE on CarGarageProduct (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5EC3C4B0 on CarGarageProduct (uuid_[$COLUMN_LENGTH:75$], groupId);