drop table if exists users CASCADE;
CREATE TABLE users (user_id bigint NOT NULL AUTO_INCREMENT, full_name varchar(45) NOT NULL, user_name varchar(45) NOT NULL, password varchar(45) NOT NULL,PRIMARY KEY (user_id), UNIQUE KEY username_UNIQUE (user_name));

drop table if exists artist CASCADE;
CREATE TABLE artist (id bigint NOT NULL AUTO_INCREMENT, name varchar(100) NOT NULL, PRIMARY KEY (id), UNIQUE KEY name_UNIQUE (name));

drop table if exists genre CASCADE;
CREATE TABLE genre(id bigint NOT NULL AUTO_INCREMENT, name varchar(100) NOT NULL, description varchar(250) NOT NULL, PRIMARY KEY (id), UNIQUE KEY genrename_UNIQUE (name), UNIQUE KEY description_UNIQUE (description));

drop table if exists album CASCADE;
CREATE TABLE album(id bigint NOT NULL AUTO_INCREMENT, name varchar(100) NOT NULL, cover varchar(45) NOT NULL, artist_id bigint NOT NULL, PRIMARY KEY (id), UNIQUE KEY albumname_UNIQUE (name));

drop table if exists playlist CASCADE;
CREATE TABLE playlist(id bigint NOT NULL AUTO_INCREMENT, name varchar(100) NOT NULL, users_user_id bigint NOT NULL, description varchar(250) NOT NULL, artwork varchar(1000) NOT NULL, PRIMARY KEY (id), UNIQUE KEY playlistname_UNIQUE (name), UNIQUE KEY playlistdescription_UNIQUE (description), UNIQUE KEY artwork_UNIQUE (artwork));

drop table if exists track CASCADE;
CREATE TABLE track(id bigint NOT NULL AUTO_INCREMENT, name varchar(100) NOT NULL, duration int NOT NULL, lyrics varchar(1000), album_id bigint, genre_id bigint, PRIMARY KEY (id), UNIQUE KEY trackname_UNIQUE (name));