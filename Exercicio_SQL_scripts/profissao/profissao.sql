CREATE SEQUENCE IF NOT EXISTS profissao_prof_codigo_profissao_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE profissao (
    codigo_profissao INTEGER      NOT NULL DEFAULT NEXTVAL('profissao_prof_codigo_profissao_seq'),
    nome             VARCHAR(30)  NOT NULL,
    salario          DECIMAL(5,2) NOT NULL,
	
    CONSTRAINT pk_prof_codigo_profissao PRIMARY KEY (codigo_profissao)
);

