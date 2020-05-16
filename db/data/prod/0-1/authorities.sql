--liquibase formatted sql

--changeset etsiurupa:authorities-01 logicalFilePath:db/object/0-1
--comment: inserting values
insert into authorities (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');