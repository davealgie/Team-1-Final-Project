DROP TABLE if EXISTS album CASCADE;
DROP TABLE if EXISTS artist CASCADE; 
DROP TABLE if EXISTS genre CASCADE;
DROP TABLE if EXISTS playlist CASCADE;
DROP TABLE if EXISTS track CASCADE;
CREATE TABLE album (id bigint , NAME varchar(100),cover varchar(45) NOT null, artist_id bigint,PRIMARY KEY (id));
CREATE TABLE artist (id bigint , NAME varchar(100) NOT null, PRIMARY KEY (id));
CREATE TABLE genre (id bigint, NAME varchar(100)NOT null, description varchar(250)  NOT null, PRIMARY KEY (id));
CREATE TABLE playlist (id bigint, NAME varchar(100) NOT null, users_id bigint, description varchar(500) NOT null,artwork varchar(1000) NOT null , PRIMARY KEY (id));
CREATE TABLE track (id bigint , NAME varchar(100) NOT null, duration integer NOT null, lyrics varchar(1000), album_id bigint, genre_id bigint, PRIMARY KEY (id));