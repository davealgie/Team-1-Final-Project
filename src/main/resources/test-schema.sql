DROP TABLE IF EXISTS `playlist_tracks`;
DROP TABLE IF EXISTS `tracks`;
DROP TABLE IF EXISTS `playlists`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `albums`;
DROP TABLE IF EXISTS `genres`;
DROP TABLE IF EXISTS `artists`;
 
CREATE TABLE `albums` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `cover` varchar(45) DEFAULT NULL,
  `artist_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `artist_id_idx` (`artist_id`),
  CONSTRAINT `artist_id` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) 



CREATE TABLE `artists` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
)


CREATE TABLE `genres` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `description_UNIQUE` (`description`)
) 

CREATE TABLE `playlists` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `user_id` bigint NOT NULL,
  `description` varchar(500) NOT NULL,
  `artwork` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `artwork_UNIQUE` (`artwork`),
  UNIQUE KEY `description_UNIQUE` (`description`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) 

CREATE TABLE `playlists_tracks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `playlist_id` bigint NOT NULL,
  `track_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `playlist_id_idx` (`playlist_id`),
  KEY `track_id_idx` (`track_id`),
  CONSTRAINT `playlist_id` FOREIGN KEY (`playlist_id`) REFERENCES `playlists` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `track_id` FOREIGN KEY (`track_id`) REFERENCES `tracks` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) 

CREATE TABLE `tracks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `duration` int DEFAULT NULL,
  `lyrics` varchar(1000) DEFAULT NULL,
  `album_id` bigint DEFAULT NULL,
  `genre_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `album_id_idx` (`album_id`),
  KEY `genre_id_idx` (`genre_id`),
  CONSTRAINT `album_id` FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `genre_id` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`) ON UPDATE CASCADE
)

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
)