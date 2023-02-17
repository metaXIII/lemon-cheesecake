CREATE TABLE if not exists item
(
    id          UUID NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    CONSTRAINT pk_item PRIMARY KEY (id)
);