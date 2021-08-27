INSERT INTO `genre` (`name`, `description`) VALUES ('Rock', 'Rock desc');
INSERT INTO `artist` ( `id`, `name`) VALUES (1, 'Kirk Hammett');
INSERT INTO `playlist` (`name`, `description`, `artwork`) VALUES ('Rock Playlist', 'Rock Description', 'Rock Artwork');
INSERT INTO `album` (`name`, `artist_id`, `cover`) VALUES ('Rock album', 1,'Rock Cover');
INSERT INTO `track` (`name`, `duration`, `lyrics`, `album_id`, `genre_id`) VALUES ('TestTrack', 100, 'TestLyrics', 1, 1);
