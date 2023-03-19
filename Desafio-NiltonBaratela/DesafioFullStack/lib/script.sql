 CREATE DATABASE Desafio;

CREATE TABLE desafio.empresa(
	cnpj VARCHAR(14) NOT NULL PRIMARY KEY,
	nomeFantasia VARCHAR(255) NOT NULL,
	cep VARCHAR(8) NOT NULL
);
CREATE TABLE desafio.fornecedor(
	cpf VARCHAR(14) NOT NULL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	rg VARCHAR(9),
	email VARCHAR(255) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	dataNasc date
);