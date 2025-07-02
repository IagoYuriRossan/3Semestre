DROP TABLE Pallas

create database [Pallas]

use [Pallas]
select * from usuarios

CREATE TABLE Usuarios (
    Id INT PRIMARY KEY IDENTITY(1,1), -- Chave prim�ria auto-increment�vel
    Nome VARCHAR(255) NOT NULL,
    Username VARCHAR(50) NOT NULL UNIQUE, -- Unique para garantir usernames �nicos
    Email VARCHAR(255),
	Senha VARCHAR(255) NOT NULL,
);

