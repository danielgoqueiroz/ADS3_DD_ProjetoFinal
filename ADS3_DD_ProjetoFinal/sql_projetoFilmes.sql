create database DBreviewFilmes;

drop database DBreviewFilmes;
use DBreviewFilmes;

create table usuario(
	idusuario int not null auto_increment primary key,
	nome varchar(45),
	nickname varchar(45),
	email varchar(45),
	telefone varchar(45),
	senha varchar(45)
);



create table filme (
	idfilme int not null auto_increment primary key,
    titulo varchar(45),
	ano int,
	Genero varchar(45),
	Diretor varchar(45),
	atores varchar(45),
	sinopse varchar(45),
	Nota varchar(45),
	Duracao int
	
);

create table assistidos (
    idusuario int,
    idfilme int,
    primary key(idfilme, idusuario)
);

create table artista (
	idartista int not null auto_increment primary key,
    idartistafuncao int,
    nome varchar(45),
	dt_nascimento date,
    foreign key (idartistafuncao) references artistaFuncao (idartistafuncao)
);

create table serie (
	idserie int not null auto_increment primary key,
    titulo varchar(45),
	ano int,
	Genero varchar(45),
	Diretor varchar(45),
	atores varchar(45),
	sinopse varchar(45),
	Nota varchar(45),
	temporada int,
	captulo int
);


create table artistaFuncao (
	idartistafuncao int not null auto_increment primary key,
    descricao varchar(45)
);

drop table artistaFuncao;
show tables;

select * from artistaFuncao;

