CREATE SEQUENCE IF NOT EXISTS endereco_end_codigo_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE endereco (
    codigo          INTEGER       NOT NULL DEFAULT NEXTVAL('endereco_end_codigo_seq'),
    rua             VARCHAR(30)   NOT NULL,
    numero          VARCHAR(10),
    complemento     VARCHAR(30)   NOT NULL,
    cep             VARCHAR(10)   NOT NULL,
    codigo_do_bairro   INTEGER       NOT NULL,
	
    CONSTRAINT pk_end_codigo_do_endereco PRIMARY KEY (codigo),
    CONSTRAINT fk_end_codigo_do_bairro   FOREIGN KEY (codigo_do_bairro) REFERENCES bairro (codigo)	
);