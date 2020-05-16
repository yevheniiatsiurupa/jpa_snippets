--liquibase formatted sql

--changeset etsiurupa:authorities-01 logicalFilePath:db/object/0-1
--comment: creating table for authorities
create table authorities(
	id serial primary key,
	name varchar
);