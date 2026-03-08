CREATE TABLE pokemon_db.usuario (
             alias varchar(60) NOT NULL,
             passwd varchar(60) DEFAULT NULL,
             nombre varchar(60) DEFAULT NULL,
             apellido varchar(60) DEFAULT NULL,

             PRIMARY KEY (alias)

);

CREATE TABLE torneo (
			id int auto_increment,
            lugar varchar(60) not null,
			rondas varchar(3) not null,
            fecha varchar(20) not null,
            descripcion varchar(100) not null,
            tipo varchar(20) not null,
            estado varchar(20) default "Iniciar",
            PRIMARY KEY (id)
);


CREATE TABLE jugador (
			puntaje int not null default 0,
            liga int not null,
            aliasJugador varchar(60),
            posicion int not null default 0,

            CONSTRAINT fkTorneo FOREIGN KEY (liga) REFERENCES torneo(id),
            CONSTRAINT fkUsuario FOREIGN KEY (aliasJugador) REFERENCES usuario(alias),
            PRIMARY KEY (liga,aliasJugador)
);