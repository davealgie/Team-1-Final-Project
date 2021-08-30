INSERT INTO `genre` (`name`, `description`) VALUES ('Rock', 'lead guitar');
INSERT INTO `artist` (`name`) VALUES ('Kirk Hammett');
INSERT INTO `playlist` (`name`, `description`, `artwork`) VALUES ('Rock Playlist', 'Rock Description', 'Rock Artwork');
INSERT INTO `album` (`name`, `artist_id`, `cover`) VALUES ('Rock album', 1,'Rock Cover');
INSERT INTO `track` (`name`, `duration`, `lyrics`, `album_id`, `genre_id`) VALUES ('Nothing', 100, 'else', 1, 1);
INSERT INTO `users` (`full_name`, `user_name`, `password`) VALUES ('Dave', 'davealg', 'davidalgie');