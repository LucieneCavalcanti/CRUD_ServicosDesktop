-- SQL Server
create database bdTeste05042025
use bdTeste05042025
create table tbServicos(
id int not null primary key identity,
descricao varchar(200) not null,
preco decimal (10,2) not null
)

select * from tbServicos


-- MySQL
create table tbServicos(
id int not null primary key auto_increment,
descricao varchar(200) not null,
preco decimal (10,2) not null
)
