drop table if exists users CASCADE;
CREATE TABLE users (user_id bigint NOT NULL AUTO_INCREMENT, full_name varchar(45) NOT NULL, user_name varchar(45) NOT NULL, password varchar(45) NOT NULL,PRIMARY KEY (user_id), UNIQUE KEY username_UNIQUE (user_name));

drop table if exists artist CASCADE;
CREATE TABLE artist (id bigint NOT NULL AUTO_INCREMENT, name varchar(100) NOT NULL, PRIMARY KEY (id), UNIQUE KEY name_UNIQUE (name));