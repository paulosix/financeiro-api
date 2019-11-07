CREATE SCHEMA financeiro
    AUTHORIZATION postgres;

CREATE SEQUENCE financeiro.categoria_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


CREATE TABLE financeiro.categoria
(
    id bigint NOT NULL DEFAULT nextval('financeiro.categoria_id_seq'::regclass),
    nome character(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT categoria_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE financeiro.categoria
    OWNER to postgres;

INSERT INTO financeiro.categoria (nome) VALUES ('Alimentação');
INSERT INTO financeiro.categoria (nome) VALUES ('Transporte');
INSERT INTO financeiro.categoria (nome) VALUES ('Viagem');
INSERT INTO financeiro.categoria (nome) VALUES ('Combustivel');
INSERT INTO financeiro.categoria (nome) VALUES ('Outros');