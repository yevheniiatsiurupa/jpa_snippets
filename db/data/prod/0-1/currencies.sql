--liquibase formatted sql

--changeset etsiurupa:currencies-01 logicalFilePath:db/data/prod/0-1
--comment: inserting values
insert into currencies (name, sign)
values ('ruble', 'RUB'),
       ('dollar','USD'),
       ('euro','EUR');