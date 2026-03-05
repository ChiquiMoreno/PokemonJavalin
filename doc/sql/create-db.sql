CREATE USER 'proy'@'localhost' IDENTIFIED BY 'password';

CREATE DATABASE pokemon_db;

GRANT ALL PRIVILEGES ON pokemon_db.* TO 'proy'@'localhost';

USE pokemon_db;