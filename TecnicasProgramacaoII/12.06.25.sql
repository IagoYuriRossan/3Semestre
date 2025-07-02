drop database Pallas
create database Pallas

use Pallas


CREATE TABLE Usuarios (
    Id INT PRIMARY KEY IDENTITY(1,1), -- Chave prim�ria auto-increment�vel
    Nome VARCHAR(255) NOT NULL,
    Username VARCHAR(50) NOT NULL UNIQUE, -- Unique para garantir usernames �nicos
    Senha VARCHAR(255) NOT NULL,
    Email VARCHAR(255),
    DataCriacao DATETIME DEFAULT GETDATE() -- Salva a data e hora de cria��o automaticamente
);

select * from Usuarios