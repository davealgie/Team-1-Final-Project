INSERT INTO users (full_name, user_name, password) VALUES ('Dave', 'dave', 'davidalgie');

INSERT INTO artist(name) VALUES ('Kirk Hammett');

INSERT INTO genre(name, description) VALUES ('Rock', 'lead guitar');

INSERT INTO album(name, cover, artist_id) VALUES ('Black album', 'Snake', 1);

INSERT INTO playlist(name, users_user_id,description, artwork) VALUES ('Chill vibes', 1, 'relaxing playlist', 'cup of tea');

INSERT INTO track(name, duration, lyrics, album_id, genre_id) VALUES ('Nothing else matters', 280, 'and nothing else matters', 1, 1);