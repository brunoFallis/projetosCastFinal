CREATE SCHEMA prova
  AUTHORIZATION postgres;

CREATE TABLE prova.usuario
(
  id serial NOT NULL,
  nome character varying(100) NOT NULL,
  usuario character varying(50) NOT NULL,
  senha character varying(50) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT usuario_usuario_key UNIQUE (usuario)
);

insert into prova.usuario(nome, usuario, senha)
	values ('Administrador', 'admin', '123');
	
/*==============================================================================*/
/*==============================================================================*/
CREATE TABLE PROVA.AUTOR(

	ID		SERIAL		NOT NULL,
	NOME		VARCHAR(100)	NOT NULL,
	PSEUDONIMO	VARCHAR(100)	NOT NULL

);

ALTER TABLE PROVA.AUTOR
	ADD CONSTRAINT PK_AUTOR PRIMARY KEY (ID);
/*==============================================================================*/
/*==============================================================================*/
CREATE TABLE PROVA.CATEGORIA(

	ID 		SERIAL		 NOT NULL,
	DESCRICAO	VARCHAR(500)	 NOT NULL

);

ALTER TABLE PROVA.CATEGORIA
	ADD CONSTRAINT PK_CATEGORIA PRIMARY KEY (ID);
/*==============================================================================*/
/*==============================================================================*/
CREATE TABLE PROVA.LIVRO(

	ID		SERIAL		 NOT NULL,
	TITULO		VARCHAR(100)	 UNIQUE NOT NULL,
	PUBLICACAO	TIMESTAMP	 NOT NULL,
	ID_AUTOR	INTEGER		 NOT NULL,
	ID_CATEGORIA	INTEGER		 NOT NULL

);

ALTER TABLE PROVA.LIVRO
	ADD CONSTRAINT PK_LIVRO PRIMARY KEY (ID);

ALTER TABLE PROVA.LIVRO
	ADD CONSTRAINT FK_AUTORLIVRO FOREIGN KEY (ID_AUTOR) REFERENCES PROVA.AUTOR(ID);

ALTER TABLE PROVA.LIVRO
	ADD CONSTRAINT FK_CATEGORIALIVRO FOREIGN KEY (ID_CATEGORIA) REFERENCES PROVA.CATEGORIA(ID);
/*==============================================================================*/
/*==============================================================================*/

INSERT INTO PROVA.AUTOR (NOME, PSEUDONIMO) VALUES('Jailson', 'JM'), ('Maria', 'AP'), ('Matheus', 'CASAO'), ('Erick', 'Consolo');

INSERT INTO PROVA.CATEGORIA (DESCRICAO) VALUES('FICCAO'), ('SOBRENATURAL'), ('ROMANCE'), ('DRAMA'), ('TERROR'), ('AVENTURA');

INSERT INTO PROVA.LIVRO (TITULO, PUBLICACAO, ID_AUTOR, ID_CATEGORIA) VALUES ('O', '24/09/1996', 2, 3), ('A', '24/09/2018', 1, 4), ('B', '26/09/2002', 3, 1);


/*
DROP TABLE PROVA.CATEGORIA CASCADE;
DROP TABLE PROVA.AUTOR	CASCADE;
DROP TABLE PROVA.LIVRO	CASCADE; 
*/