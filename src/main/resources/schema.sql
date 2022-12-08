CREATE TABLE author (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY (id)
);


CREATE TABLE tutorial (
    id bigint NOT NULL AUTO_INCREMENT,
    title varchar(255),
    description varchar(255),
    author_id bigint,
    published boolean,
    PRIMARY KEY (id)
);

ALTER TABLE tutorial
    ADD CONSTRAINT TUTORIAL_AUTHOR_ID_AUTHOR_ID_FK
        FOREIGN KEY (author_id) REFERENCES author(id);