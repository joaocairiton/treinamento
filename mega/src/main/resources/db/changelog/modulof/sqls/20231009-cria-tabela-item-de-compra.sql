CREATE SEQUENCE IF NOT EXISTS item_compra_icom_codigo_do_item_compra_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;


CREATE TABLE item_compra (
    codigo            INTEGER      NOT NULL DEFAULT NEXTVAL('item_compra_icom_codigo_do_item_compra_seq'),
    nome              VARCHAR(30)  NOT NULL,
    valor             DECIMAL(7,2) NOT NULL,
    codigo_da_compra  INTEGER      NOT NULL,
	
    CONSTRAINT pk_icom_codigo_item_compra PRIMARY KEY (codigo),
    CONSTRAINT fk_icom_codigo_da_compra    FOREIGN KEY (codigo_da_compra) REFERENCES compra (codigo)
);