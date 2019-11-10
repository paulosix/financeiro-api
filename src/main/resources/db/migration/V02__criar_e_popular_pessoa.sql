CREATE SEQUENCE financeiro.pessoa_codigo_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE financeiro.pessoa
(
    codigo bigint NOT NULL DEFAULT nextval('financeiro.pessoa_codigo_seq'::regclass),
    nome character(100) COLLATE pg_catalog."default" NOT NULL,
    ativo boolean NOT NULL,
    logradouro character(100) COLLATE pg_catalog."default",
    numero character(10) COLLATE pg_catalog."default",
    complemento character(50) COLLATE pg_catalog."default",
    bairro character(100) COLLATE pg_catalog."default",
    cep character(15) COLLATE pg_catalog."default",
    cidade character(50) COLLATE pg_catalog."default",
    estado character(50) COLLATE pg_catalog."default",
    CONSTRAINT pessoa_pkey PRIMARY KEY (codigo)
)

TABLESPACE pg_default;

ALTER TABLE financeiro.pessoa
    OWNER to postgres;

INSERT INTO financeiro.pessoa(
	nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
	VALUES ('Paulo Roberto', true, 'Senador Robert Kennedy', '610', '', 'Barra do ceara', '60332170', 'Fortaleza', 'CE');
INSERT INTO financeiro.pessoa(
	nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
	VALUES ('Paulo Henrique', true, 'Senador Robert Kennedy', '610', '', 'Barra do ceara', '60332170', 'Fortaleza', 'CE');
INSERT INTO financeiro.pessoa(
	nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
	VALUES ('Ana Paula', true, 'Senador Robert Kennedy', '610', '', 'Barra do ceara', '60332170', 'Fortaleza', 'CE');