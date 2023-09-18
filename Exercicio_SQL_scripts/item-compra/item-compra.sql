CREATE TABLE itemCompra (
    codigo_itemCompra  INTEGER      NOT NULL DEFAULT NEXTVAL('itemCompra_icom_codigo_itemCompra_seq'),
    nome               VARCHAR(30)  NOT NULL,
    valor_item         DECIMAL(7,2) NOT NULL,
    codigo_compra      INTEGER      NOT NULL,
	
    CONSTRAINT pk_icom_codigo_itemCompra PRIMARY KEY (codigo_itemCompra),
    CONSTRAINT fk_icom_codigo_compra     FOREIGN KEY (codigo_compra) REFERENCES compra (codigo_compra)
);
