CREATE SEQUENCE IF NOT EXISTS bairro_brr_codigo_bairro_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE bairro (
    codigo_bairro    INTEGER         NOT NULL DEFAULT NEXTVAL('bairro_brr_codigo_bairro_seq'),
    nome             VARCHAR(50)     NOT NULL,
    valor_iptu       DECIMAL(7,2)    NOT null,
	
    CONSTRAINT pk_brr_codigo_bairro PRIMARY KEY (codigo_bairro)	
);

