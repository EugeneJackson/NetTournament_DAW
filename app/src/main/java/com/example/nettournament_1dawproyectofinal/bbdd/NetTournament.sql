DROP DATABASE IF EXISTS torneos_db;
CREATE DATABASE torneos_db;
USE torneos_db;

CREATE TABLE jugadores (
    id_jugador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apodo VARCHAR(50),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE torneos (
    id_torneo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    estado VARCHAR(20) DEFAULT 'activo',
    fecha_inicio DATE
);

CREATE TABLE inscripciones (
    id_inscripcion INT AUTO_INCREMENT PRIMARY KEY,
    id_jugador INT NOT NULL,
    id_torneo INT NOT NULL,
    fecha_inscripcion DATE,
    FOREIGN KEY (id_jugador) REFERENCES jugadores(id_jugador),
    FOREIGN KEY (id_torneo) REFERENCES torneos(id_torneo)
);

CREATE TABLE partidos (
    id_partido INT AUTO_INCREMENT PRIMARY KEY,
    id_torneo INT NOT NULL,
    estado VARCHAR(20) DEFAULT 'pendiente',
    FOREIGN KEY (id_torneo) REFERENCES torneos(id_torneo)
);

CREATE TABLE partidos_jugadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_partido INT NOT NULL,
    id_jugador INT NOT NULL,
    FOREIGN KEY (id_partido) REFERENCES partidos(id_partido),
    FOREIGN KEY (id_jugador) REFERENCES jugadores(id_jugador)
);

CREATE TABLE resultados (
    id_resultado INT AUTO_INCREMENT PRIMARY KEY,
    id_partido INT NOT NULL,
    id_jugador INT NOT NULL,
    puntos INT NOT NULL,
    ganador BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_partido) REFERENCES partidos(id_partido),
    FOREIGN KEY (id_jugador) REFERENCES jugadores(id_jugador)
);

CREATE TABLE estadisticas (
    id_estadistica INT AUTO_INCREMENT PRIMARY KEY,
    id_jugador INT NOT NULL,
    id_torneo INT NOT NULL,
    partidos_jugados INT DEFAULT 0,
    victorias INT DEFAULT 0,
    derrotas INT DEFAULT 0,
    puntos_totales INT DEFAULT 0,
    FOREIGN KEY (id_jugador) REFERENCES jugadores(id_jugador),
    FOREIGN KEY (id_torneo) REFERENCES torneos(id_torneo)
);