CREATE DATABASE IF NOT EXISTS cadastro_usuarios;
USE cadastro_usuarios;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(14) UNIQUE,
    senha VARCHAR(100) NOT NULL
);
