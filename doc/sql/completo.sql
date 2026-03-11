DROP USER IF EXISTS 'proy'@'localhost';
CREATE USER 'proy'@'localhost' IDENTIFIED BY 'password';

drop database if exists pokemon_db;
CREATE DATABASE pokemon_db;

GRANT ALL PRIVILEGES ON pokemon_db.* TO 'proy'@'localhost';

USE pokemon_db;

CREATE TABLE pokemon_db.usuario (
             alias varchar(60) NOT NULL,
             passwd varchar(60) DEFAULT NULL,
             nombre varchar(60) DEFAULT NULL,
             apellido varchar(60) DEFAULT NULL,

             PRIMARY KEY (alias)

);

CREATE TABLE liga (
			id int auto_increment,
            lugar varchar(60) not null,
			rondas varchar(3) not null,
            fecha varchar(20) not null,
            descripcion varchar(100) not null,
            tipo varchar(20) not null,
            estado int default -1,
            PRIMARY KEY (id)
);


CREATE TABLE jugador (
			puntaje int not null default 0,
            idLiga int not null,
            aliasUsuario varchar(60),
            posicion int not null default 0,

            CONSTRAINT fkTorneo FOREIGN KEY (idLiga) REFERENCES liga(id),
            CONSTRAINT fkUsuario FOREIGN KEY (aliasUsuario) REFERENCES usuario(alias),
            PRIMARY KEY (idLiga,aliasUsuario)
);

create table if not exists mesa(
	numMesa int primary key,
	idliga int not null,
	aliasJugadorA varchar(60),
    aliasJugadorB varchar(60),
    aliasGanador varchar(60),
    CONSTRAINT fkJugadorA FOREIGN KEY (aliasJugadorA, idliga) REFERENCES jugador(aliasUsuario, idliga),
    CONSTRAINT fkJugadorB FOREIGN KEY (aliasJugadorB, idliga) REFERENCES jugador(aliasUsuario, idliga),
    CONSTRAINT fkGanador FOREIGN KEY (aliasGanador, idliga) REFERENCES jugador(aliasUsuario, idliga)
);

create table if not exists Partida(
	idPartida int,
    numMesa int,
    primary key(idPartida, numMesa),
	CONSTRAINT fkPartidaMesa FOREIGN KEY (numMesa) REFERENCES mesa(numMesa)
);

INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("urko", "1234","Urko","Martinez");
INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("chiqui", "1234","Chiqui","Moreno");
INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("alvaro", "1234","Álvaro","Marturet");

INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Comics Pamplona", "BO3" , "11/02/2026 16:30", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Itaroa", "BO5" , "16/04/2026 17:30", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Amistoso");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Comics Pamplona", "BO3" , "28/02/2026 18:00", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Morea", "BO3" , "30/03/2026 17:00", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");

update liga set estado = 0 where id = 1;
update liga set estado = 1 where id = 3;
update liga set estado = 2 where id = 2;


-- 20 usuarios
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador01", "1234", "Entrenador", "01");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador02", "1234", "Entrenador", "02");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador03", "1234", "Entrenador", "03");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador04", "1234", "Entrenador", "04");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador05", "1234", "Entrenador", "05");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador06", "1234", "Entrenador", "06");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador07", "1234", "Entrenador", "07");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador08", "1234", "Entrenador", "08");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador09", "1234", "Entrenador", "09");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador10", "1234", "Entrenador", "10");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador11", "1234", "Entrenador", "11");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador12", "1234", "Entrenador", "12");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador13", "1234", "Entrenador", "13");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador14", "1234", "Entrenador", "14");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador15", "1234", "Entrenador", "15");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador16", "1234", "Entrenador", "16");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador17", "1234", "Entrenador", "17");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador18", "1234", "Entrenador", "18");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador19", "1234", "Entrenador", "19");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("entrenador20", "1234", "Entrenador", "20");

-- 6 ligas (ids fijos para poder referenciar en jugador)
INSERT IGNORE INTO pokemon_db.liga (id, lugar, rondas, fecha, descripcion, tipo, estado) VALUES (101, "Pamplona Centro", "BO3", "10/01/2027 17:00", "Liga regional de invierno", "Competitiva", 0);
INSERT IGNORE INTO pokemon_db.liga (id, lugar, rondas, fecha, descripcion, tipo, estado) VALUES (102, "Burlada", "BO3", "17/01/2027 17:00", "Liga regional de invierno", "Competitiva", 0);
INSERT IGNORE INTO pokemon_db.liga (id, lugar, rondas, fecha, descripcion, tipo, estado) VALUES (103, "Noain", "BO5", "24/01/2027 17:00", "Liga de preparación de temporada", "Amistosa", 0);
INSERT IGNORE INTO pokemon_db.liga (id, lugar, rondas, fecha, descripcion, tipo, estado) VALUES (104, "Itaroa", "BO3", "31/01/2027 17:00", "Liga de preparación de temporada", "Competitiva", 0);
INSERT IGNORE INTO pokemon_db.liga (id, lugar, rondas, fecha, descripcion, tipo, estado) VALUES (105, "Morea", "BO5", "07/02/2027 17:00", "Liga clasificatoria", "Competitiva", 0);
INSERT IGNORE INTO pokemon_db.liga (id, lugar, rondas, fecha, descripcion, tipo, estado) VALUES (106, "Sarriguren", "BO3", "14/02/2027 17:00", "Liga mixta con jugadores repetidos", "Mixta", 0);

-- 24 inscripciones (4 por liga = número par)
-- Liga 101
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (101, "entrenador01", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (101, "entrenador02", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (101, "entrenador03", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (101, "entrenador04", 0, 0);

-- Liga 102
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (102, "entrenador05", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (102, "entrenador06", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (102, "entrenador07", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (102, "entrenador08", 0, 0);

-- Liga 103
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (103, "entrenador09", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (103, "entrenador10", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (103, "entrenador11", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (103, "entrenador12", 0, 0);

-- Liga 104
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (104, "entrenador13", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (104, "entrenador14", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (104, "entrenador15", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (104, "entrenador16", 0, 0);

-- Liga 105
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (105, "entrenador17", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (105, "entrenador18", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (105, "entrenador19", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (105, "entrenador20", 0, 0);

-- Liga 106 (repetidos de otras ligas)
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (106, "entrenador03", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (106, "entrenador08", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (106, "entrenador12", 0, 0);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (106, "entrenador17", 0, 0);
