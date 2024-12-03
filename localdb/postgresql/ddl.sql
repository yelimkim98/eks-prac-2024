CREATE TABLE region
(
    region_id          SERIAL PRIMARY KEY,
    region_name        VARCHAR(100) NOT NULL,
    creation_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
