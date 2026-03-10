INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("urko", "1234","Urko","Martinez");
INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("chiqui", "1234","Chiqui","Moreno");
INSERT into pokemon_db.usuario (alias,passwd, nombre, apellido) values ("alvaro", "1234","Álvaro","Marturet");

INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Comics Pamplona", "BO3" , "11/02/2026 16:30", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Itaroa", "BO5" , "16/04/2026 17:30", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Amistoso");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Comics Pamplona", "BO3" , "28/02/2026 18:00", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");
INSERT into pokemon_db.liga (lugar, rondas, fecha, descripcion, tipo) values ("Morea", "BO3" , "30/03/2026 17:00", "Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.", "Competitivo estandar");

-- Datos de prueba (idempotentes) para la liga con id=1
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("misty", "1234", "Misty", "Waterflower");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("brock", "1234", "Brock", "Harrison");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("gary", "1234", "Gary", "Oak");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("dawn", "1234", "Dawn", "Berlitz");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("serena", "1234", "Serena", "Yvonne");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("ash", "1234", "Ash", "Ketchum");
INSERT IGNORE INTO pokemon_db.usuario (alias, passwd, nombre, apellido) VALUES ("may", "1234", "May", "Maple");

INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (1, "urko", 9, 1);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (1, "misty", 6, 2);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (1, "brock", 6, 3);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (1, "gary", 3, 4);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (1, "dawn", 3, 5);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (1, "serena", 0, 6);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (1, "ash", 0, 7);
INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (1, "may", 0, 8);
