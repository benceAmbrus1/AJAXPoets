DROP TABLE IF EXISTS poems;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
	CONSTRAINT email_not_empty CHECK (email <> ''),
	CONSTRAINT password_not_empty CHECK (password <> '')
);

INSERT INTO users (name, email, password) VALUES
	('Petőfi', 'user1@user1', 'user1'),
	('Arany', 'user2@user2', 'user2'),
	('Weöres', 'user2@user3', 'user3');

CREATE TABLE poems (
    id SERIAL PRIMARY KEY,
    title TEXT NULL,
    poem TEXT NULL,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

INSERT INTO poems (title, poem, user_id) VALUES
    ('A BÁNAT EGY NAGY ÓCEÁN', 'A bánat egy nagy óceán.<br> S az öröm Az óceán kis gyöngye.<br> Talán, Mire felhozom,<br> össze is töröm.', 1),
    ('A HUSZÁR', 'Szegény legény vagyok,<br> Nincs semmi vagyonom;<br> Szívem sem az enyém,<br> Rég birja galambom...', 1),
    ('ANYÁM TYÚKJA', 'Ej mi a kô! tyúkanyó,<br> kend A szobában lakik itt bent <br> Lám, csak jó az isten, jót ád,<br> Hogy fölvitte a kend dolgát!...', 1),

    ('?','?',2),
    ('?','?',2),
    ('?','?',2),

    ('?','?',3),
    ('?','?',3),
    ('?','?',3);
