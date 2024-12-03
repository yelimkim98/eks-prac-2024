create table region
(
    region_id          SERIAL primary key,
    region_name        VARCHAR(100) not null,
    creation_timestamp TIMESTAMP    not null
) default charset utf8mb4;
