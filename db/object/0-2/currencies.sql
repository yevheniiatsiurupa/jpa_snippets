--liquibase formatted sql

--changeset etsiurupa:currencies-01 logicalFilePath:db/object/0-2
alter table currencies
add hidden boolean not null default true;