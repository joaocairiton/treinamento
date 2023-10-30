CREATE SEQUENCE IF NOT EXISTS compra_com_codigo_da_compra_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE compra (
    codigo INTEGER      NOT NULL DEFAULT NEXTVAL('compra_com_codigo_da_compra_seq'),
    valor_total   DECIMAL(5,2) NOT NULL,
    codigo_da_pessoa INTEGER      NOT NULL,
	
    CONSTRAINT pk_com_codigo_da_compra PRIMARY KEY (codigo),
    CONSTRAINT fk_com_codigo_da_pessoa FOREIGN KEY (codigo_da_pessoa) REFERENCES pessoa (codigo)
);