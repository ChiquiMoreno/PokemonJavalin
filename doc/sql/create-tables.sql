CREATE TABLE pokemon_db.usuario (
             alias varchar(60) NOT NULL,
             passwd varchar(60) DEFAULT NULL,
             nombre varchar(60) DEFAULT NULL,
             apellido varchar(60) DEFAULT NULL

             PRIMARY KEY (id)

);

CREATE TABLE torneo (
			id int auto_increment,
            lugar varchar(60) not null,
			rondas int not null,
            fecha varchar(20) not null,
            descripcion varchar(100) not null,
            tipo varchar(20) not null,
            PRIMARY KEY (id)
            );