create database [Pallas]

use [Pallas]
select * from usuario
create table usuario(
ID int identity (1,1) primary key,
Nome varchar (50),
Email varchar (65),
senha varchar (80),
pontuação int,
horas datetime,
foto VARBINARY(MAX));

