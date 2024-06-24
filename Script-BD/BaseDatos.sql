CREATE DATABASE IF NOT EXISTS BaseDatos;

USE BaseDatos;

CREATE TABLE IF NOT EXISTS persona (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nombre VARCHAR(255),
    genero VARCHAR(10),
    edad INT,
    identificacion VARCHAR(20),
    direccion VARCHAR(255),
    telefono VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS cliente (
                                       cliente_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       persona_id BIGINT,
    contraseña VARCHAR(255),
    estado BOOLEAN,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
    );

CREATE TABLE IF NOT EXISTS cuenta (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      cliente_id BIGINT,
                                      numero_cuenta VARCHAR(20) UNIQUE,
    tipo_cuenta VARCHAR(20),
    saldo_inicial DOUBLE,
    estado BOOLEAN,
    FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id)
    );

CREATE TABLE IF NOT EXISTS movimiento (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          fecha DATETIME,
                                          tipo_movimiento VARCHAR(20),
    valor DOUBLE,
    saldo DOUBLE,
    cuenta_id BIGINT,
    FOREIGN KEY (cuenta_id) REFERENCES cuenta(id)
    );