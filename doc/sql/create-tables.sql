CREATE TABLE usuario (
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