 create table compra (
	codigo_compra serial not null,
	valor_total float not null,
	codigo_pessoa integer not null,
	constraint pk_com_codigo_compra primary key (codigo_compra),
	constraint fk_com_codigo_pessoa foreign key (codigo_pessoa) references pessoa (codigo_pessoa)
);