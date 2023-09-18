create table bairro (
	codigo_bairro serial not null,
	nome VARCHAR(50) not null,
	valor_iptu Numeric(5,2) not null,
	constraint pk_brr_codigo_bairro primary key (codigo_bairro)	
);