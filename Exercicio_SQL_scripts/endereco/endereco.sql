CREATE SEQUENCE IF NOT EXISTS endereco_end_codigo_endereco_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE endereco (
    codigo_endereco INTEGER       NOT NULL DEFAULT NEXTVAL('endereco_end_codigo_endereco_seq'),
    rua             VARCHAR(30)   NOT NULL,
    numero          VARCHAR(10),
    complemento     VARCHAR(30)   NOT NULL,
    cep             VARCHAR(10)   NOT NULL,
    codigo_bairro   INTEGER       NOT NULL,
	
    CONSTRAINT pk_end_codigo_endereco PRIMARY KEY (codigo_endereco),
    CONSTRAINT fk_end_codigo_bairro   FOREIGN KEY (codigo_bairro) REFERENCES bairro (codigo_bairro)	
);
