

DROP TABLE IF EXISTS album CASCADE;
CREATE TABLE `album` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `cover` varchar(45) DEFAULT NULL,
  `artist_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `artist_id_idx` (`artist_id`),
  CONSTRAINT `artist_id` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


DROP TABLE IF EXISTS artist CASCADE;
CREATE TABLE `artist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

DROP TABLE IF EXISTS genre CASCADE;
CREATE TABLE `genre` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `description_UNIQUE` (`description`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

DROP TABLE IF EXISTS playlist CASCADE;
CREATE TABLE `playlist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `users_id` bigint DEFAULT NULL,
  `description` varchar(500) NOT NULL,
  `artwork` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `description_UNIQUE` (`description`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `artwork_UNIQUE` (`artwork`),
  KEY `user_id_idx` (`users_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
DROP TABLE IF EXISTS playlists_tracks CASCADE;
CREATE TABLE `playlists_tracks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `playlist_id` bigint NOT NULL,
  `track_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `playlist_id_idx` (`playlist_id`),
  KEY `track_id_idx` (`track_id`),
  CONSTRAINT `playlist_id` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `track_id` FOREIGN KEY (`track_id`) REFERENCES `track` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

DROP TABLE IF EXISTS track CASCADE;
CREATE TABLE `track` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `duration` int DEFAULT NULL,
  `lyrics` varchar(1000) DEFAULT NULL,
  `album_id` bigint DEFAULT NULL,
  `genre_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `album_id_idx` (`album_id`),
  KEY `genre_id_idx` (`genre_id`),
  CONSTRAINT `album_id` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `genre_id` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci