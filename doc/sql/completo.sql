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

INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("urko", "1234","Urko","Martinez");
INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("chiqui", "1234","Chiqui","Moreno");
INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("alvaro", "1234","Álvaro","Marturet");

INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Comics Pamplona", "BO3" , "11/02/2026 16:30", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Itaroa", "BO5" , "16/04/2026 17:30", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Amistoso");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Comics Pamplona", "BO3" , "28/02/2026 18:00", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Morea", "BO3" , "30/03/2026 17:00", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");

