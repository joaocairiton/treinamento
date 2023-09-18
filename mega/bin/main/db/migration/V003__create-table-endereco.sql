create table endereco (
	codigo_endereco serial not null,
	rua varchar (30) not null,
	numero varchar(10) not null,
	complemento varchar(30) not null,
	cep varchar(10) not null,
	codigo_bairro integer not null,
	constraint pk_end_codigo_endereco primary key (codigo_endereco),
	constraint fk_end_codigo_bairro foreign key (codigo_bairro) references bairro (codigo_bairro)	
);	
