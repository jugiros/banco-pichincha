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
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nombre VARCHAR(255),
    genero VARCHAR(10),
    edad INT,
    identificacion VARCHAR(20),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    clienteId VARCHAR(20) UNIQUE,
    contraseña VARCHAR(255),
    estado BOOLEAN
    );

CREATE TABLE IF NOT EXISTS cuenta (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      numeroCuenta VARCHAR(20) UNIQUE,
    tipoCuenta VARCHAR(20),
    saldoInicial DOUBLE,
    estado BOOLEAN
    );

CREATE TABLE IF NOT EXISTS movimiento (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          fecha DATETIME,
                                          tipoMovimiento VARCHAR(20),
    valor DOUBLE,
    saldo DOUBLE,
    cuentaId BIGINT,
    FOREIGN KEY (cuentaId) REFERENCES cuenta(id)
    );