-- Creación de la base de datos
-- DROP DATABASE recomendacion;
CREATE DATABASE IF NOT EXISTS recomendacion;
USE recomendacion;

-- Creación de tablas
CREATE TABLE IF NOT EXISTS usuarios(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(20),
    contrasena_usuario VARCHAR(40),
    nombre_completo VARCHAR(40),
    edad INT,
    genero VARCHAR(30),
    correo VARCHAR(40)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS peliculasFav(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS generosFav(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS actoresFav(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS directoresFav(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30)
)ENGINE=InnoDB;

-- Creación de relaciones [Muchos a Muchos]
CREATE TABLE IF NOT EXISTS usuarios_peliculasFav(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_pelicula INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_pelicula) REFERENCES peliculasFav(id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS usuarios_generosFav(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_genero INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_genero) REFERENCES generosFav(id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS usuarios_actoresFav(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_actor INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_actor) REFERENCES actoresFav(id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS usuarios_directoresFav(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_director INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_director) REFERENCES directoresFav(id)
)ENGINE=InnoDB;

-- Obtener todos los usuarios.
SELECT * FROM usuarios;
SELECT * FROM peliculasFav;
SELECT * FROM generosFav;
SELECT * FROM directoresFav;
SELECT * FROM actoresFav;
SELECT * FROM usuarios_peliculasFav;
SELECT * FROM usuarios_generosFav;
SELECT * FROM usuarios_directoresFav;
SELECT * FROM usuarios_actoresFav;
SELECT id_genero FROM usuarios_generosfav WHERE id_usuario = 1;
SELECT id FROM usuarios WHERE nombre_usuario = "FMLA";

-- Obtener el último ID que registró, para la persistencia de los registros.
SELECT MAX(id)  FROM usuarios; 