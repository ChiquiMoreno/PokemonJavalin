CREATE TABLE pokemon_db.usuario (
             alias varchar(60) NOT NULL,
             passwd varchar(60) DEFAULT NULL,
             nombre varchar(60) DEFAULT NULL,
             apellido varchar(60) DEFAULT NULL,
             PRIMARY KEY(alias)

);