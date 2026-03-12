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

INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('wednesday', '1234', 'Wednesday', 'Addams');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('eleven', '1234', 'Eleven', 'Ives');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('mike', '1234', 'Mike', 'Wheeler');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('max', '1234', 'Max', 'Mayfield');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('hopper', '1234', 'Jim', 'Hopper');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('din', '1234', 'Din', 'Djarin');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('grogu', '1234', 'Grogu', 'Mandaloriano');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('ahsoka', '1234', 'Ahsoka', 'Tano');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('cassian', '1234', 'Cassian', 'Andor');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('joel', '1234', 'Joel', 'Miller');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('ellie', '1234', 'Ellie', 'Williams');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('loki', '1234', 'Loki', 'Odinson');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('wanda', '1234', 'Wanda', 'Maximoff');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('geralt', '1234', 'Geralt', 'De Rivia');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('yennefer', '1234', 'Yennefer', 'De Vengerberg');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('ciri', '1234', 'Cirilla', 'Fiona');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('rhaenyra', '1234', 'Rhaenyra', 'Targaryen');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('daemon', '1234', 'Daemon', 'Targaryen');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('homelander', '1234', 'John', 'Gillman');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('starlight', '1234', 'Annie', 'January');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('vi', '1234', 'Violet', 'Arcane');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('jinx', '1234', 'Powder', 'Arcane');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('tanjiro', '1234', 'Tanjiro', 'Kamado');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('nezuko', '1234', 'Nezuko', 'Kamado');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('gojo', '1234', 'Satoru', 'Gojo');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('yuji', '1234', 'Yuji', 'Itadori');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('makima', '1234', 'Makima', 'Publica');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('denji', '1234', 'Denji', 'Chainsaw');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('luffy', '1234', 'Monkey D.', 'Luffy');
INSERT INTO usuario (alias, passwd, nombre, apellido) VALUES ('nami', '1234', 'Nami', 'Cat Burglar');

INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO3', '01/03/2027 16:30', 'Liga Demo 01 - Competitivo estandar', 'Competitivo estándar', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO5', '02/03/2027 16:30', 'Liga Demo 02 - Expandido', 'Expandido', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO3', '03/03/2027 16:30', 'Liga Demo 03 - Competitivo estandar', 'Competitivo estándar', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO5', '04/03/2027 16:30', 'Liga Demo 04 - Expandido', 'Expandido', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO3', '05/03/2027 16:30', 'Liga Demo 05 - Competitivo estandar', 'Competitivo estándar', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO5', '06/03/2027 16:30', 'Liga Demo 06 - Expandido', 'Expandido', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO3', '07/03/2027 16:30', 'Liga Demo 07 - Competitivo estandar', 'Competitivo estándar', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO5', '08/03/2027 16:30', 'Liga Demo 08 - Expandido', 'Expandido', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO3', '09/03/2027 16:30', 'Liga Demo 09 - Competitivo estandar', 'Competitivo estándar', 0);
INSERT INTO liga (lugar, rondas, fecha, descripcion, tipo, estado) VALUES ('Comics Pamplona', 'BO5', '10/03/2027 16:30', 'Liga Demo 10 - Expandido', 'Expandido', 0);

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('wednesday','eleven','mike','max','hopper','din','grogu','ahsoka','cassian','joel')
WHERE l.descripcion = 'Liga Demo 01 - Competitivo estandar';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('ellie','loki','wanda','geralt','yennefer','ciri','rhaenyra','daemon','homelander','starlight')
WHERE l.descripcion = 'Liga Demo 02 - Expandido';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('vi','jinx','tanjiro','nezuko','gojo','yuji','makima','denji','luffy','nami')
WHERE l.descripcion = 'Liga Demo 03 - Competitivo estandar';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('wednesday','eleven','mike','max','ellie','loki','wanda','gojo','yuji','makima')
WHERE l.descripcion = 'Liga Demo 04 - Expandido';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('din','grogu','ahsoka','cassian','joel','geralt','yennefer','ciri','luffy','nami')
WHERE l.descripcion = 'Liga Demo 05 - Competitivo estandar';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('rhaenyra','daemon','homelander','starlight','vi','jinx','tanjiro','nezuko','denji','makima')
WHERE l.descripcion = 'Liga Demo 06 - Expandido';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('wednesday','joel','ellie','din','grogu','ahsoka','cassian','vi','jinx','loki')
WHERE l.descripcion = 'Liga Demo 07 - Competitivo estandar';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('wanda','geralt','yennefer','ciri','rhaenyra','daemon','homelander','starlight','gojo','yuji')
WHERE l.descripcion = 'Liga Demo 08 - Expandido';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('tanjiro','nezuko','makima','denji','luffy','nami','mike','max','hopper','eleven')
WHERE l.descripcion = 'Liga Demo 09 - Competitivo estandar';

INSERT INTO jugador (idLiga, aliasUsuario, puntaje, posicion)
SELECT l.id, u.alias, 0, 0
FROM liga l
JOIN usuario u ON u.alias IN ('wednesday','ellie','joel','loki','wanda','gojo','yuji','luffy','nami','vi')
WHERE l.descripcion = 'Liga Demo 10 - Expandido';
