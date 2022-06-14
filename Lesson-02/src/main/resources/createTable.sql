DROP TABLE IF EXISTS footballer;

CREATE TABLE footballer

(
    id       INT GENERATED ALWAYS AS IDENTITY,
    name     VARCHAR(64) NOT NULL,
    surname  VARCHAR(64) NOT NULL,
    team     VARCHAR(64) NOT NULL,
    position VARCHAR(64) NOT NULL,
    salary   INT,
    PRIMARY KEY (id)
);