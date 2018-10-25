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

create table producao (
	idProducao int not null auto_increment primary key,
    titulo varchar(45),
	ano int,
	genero varchar(45),
	diretor varchar(45),
	sinopse varchar(200)
	duracao int,
	qtdTemporada int
	
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

create table genero (
	idgenero int not null auto_increment primary key,
	descricao varchar(45)
);

create table artistaFuncao (
	idartistafuncao int not null auto_increment primary key,
    descricao varchar(45)
);

drop table artistaFuncao;
show tables;

select * from filme;

use danie648_db_ads3_dd_filme;

select * from filme limit 1;
alter table filme add column imagem blob after duracao;
insert into filme (titulo, ano, genero, diretor, atores) values ("Filme2", 2015, "teste genero", "Luiz", "Pedro");
show tables;

use danie648_db_ads3_dd_filme;

create table filmesassistidos (
	idusuario int,
	idfilme int,
	foreign key (idusuario) references usuario (idusuario),
	foreign key (idfilme) references filme (idfilme),
	primary key (idusuario, idfilme)
	
);

alter table filmesassistidos add column nota int;

show tables;

select * from filmesassistidos;

insert into filmesassistidos (idusuario, idfilme,nota) values (1,1,4);

drop table filmesassitidos;

SELECT idfilme, titulo,	ano, Genero, Diretor, atores, sinopse, Nota ,Duracao FROM filme where idfilme not in (select idfilme from filmesassistidos where idusuario = 1);

select idfilme from filme;

 #notfilmeassistidos where idusuario = " + usuario.getIdUsuario() + " limit 1



