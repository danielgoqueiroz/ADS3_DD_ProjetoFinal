CREATE DATABASE `trabfinal`;

use trabfinal;

CREATE TABLE `artista` (
  `idArtista` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idArtista`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `genero` (
  `idgenero` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idgenero`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nickname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nivel` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `producao` (
  `idProducao` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `titulo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `sinopse` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `genero` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diretor` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `capa` blob,
  `duracao` int(11) DEFAULT NULL,
  `qtdTemporada` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProducao`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `producaoartista` (
  `idProducaoArtista` int(11) NOT NULL AUTO_INCREMENT,
  `idProducao` int(11) NOT NULL,
  `idArtista` int(11) NOT NULL,
  PRIMARY KEY (`idProducaoArtista`),
  KEY `idProducao` (`idProducao`),
  KEY `idArtista` (`idArtista`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `producoesassistidas` (
  `idProducoesAssistidas` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL DEFAULT '0',
  `idProducao` int(11) NOT NULL DEFAULT '0',
  `nota` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProducoesAssistidas`,`idUsuario`,`idProducao`),
  KEY `idProducao` (`idProducao`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

use trabfinal;

select * from usuario;

select * from producao;

insert into usuario (nome, nickname, email, seha, nivel) values ("daniel", "");

SELECT * from producao inner join producoesAssistidas on producoesAssistidas.idproducao = producao.idproducao 
	inner join usuario on usuario.idusuario = producoesAssistidas.idusuario where usuario.idusuario = 27 and producao.genero = "17";



SELECT * from producao inner join producoesAssistidas on producoesAssistidas.idproducao = producao.idproducao inner join usuario on usuario.idusuario = producoesAssistidas.idusuario where usuario.nome = "daniel";

SELECT T0.idProducao, T0.tipo, T0.titulo, T0.ano, T0.sinopse, T0.genero, T0.diretor, T0.capa, T0.duracao, T0.qtdTemporada, T1.nota FROM producao T0 inner join producoesAssistidas T1 on T1.idProducao = T0.idProducao where T1.idUsuario = "daniel";
