CREATE TABLE pokemon_db.usuario (
             alias varchar(60) NOT NULL,
             passwd varchar(60) DEFAULT NULL,
             nombre varchar(60) DEFAULT NULL,
             apellido varchar(60) DEFAULT NULL,
             rol int default 1,

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

            CONSTRAINT fkTorneo FOREIGN KEY (idLiga) REFERENCES liga(id) ON DELETE CASCADE,
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