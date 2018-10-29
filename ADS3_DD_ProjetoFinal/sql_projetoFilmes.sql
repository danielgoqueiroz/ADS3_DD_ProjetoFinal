use danie648_db_ads3_dd_filme;

create table usuario
(
	idUsuario int not null auto_increment primary key,
	nome varchar(45),
	nickname varchar(45),
	email varchar(45),
	telefone varchar(45),
	senha varchar(45)
);

create table producao 
(
	idProducao int not null auto_increment primary key,
    titulo varchar(45),
	ano int,
	genero varchar(45),
	diretor varchar(45),
	sinopse varchar(200),
    capa blob,
	duracao int,
	qtdTemporada int	
);

create table artista 
(
	idArtista int not null auto_increment primary key,
    nome varchar(45),
	dataNascimento date
);

create table producaoArtista 
(
	idProducao int not null,
    idArtista  int not null,
    FOREIGN KEY (idProducao) REFERENCES producao(idProducao),
    FOREIGN KEY (idArtista) REFERENCES artista(idArtista)
);

create table genero 
(
	idGenero int not null auto_increment primary key,
	descricao varchar(45)
);


CREATE TABLE `producoesAssistidas` (
  `idProducoesAssistidas` int(11) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL DEFAULT '0',
  `idProducao` int(11) NOT NULL DEFAULT '0',
  `nota` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`,`idProducao`),
  KEY `idProducao` (`idProducao`)
);