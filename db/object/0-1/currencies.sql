--liquibase formatted sql

--changeset etsiurupa:currencies-01 logicalFilePath:db/object/0-1
--comment: creating table for currencies
create table currencies(
	id serial primary key,
	name varchar,
	sign varchar unique
);

--changeset etsiurupa:currencies-02 logicalFilePath:db/object/0-1
--comment: updating table for currencies
alter table currencies
add supported boolean not null default true;