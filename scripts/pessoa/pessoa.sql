create table pessoa (
	codigo_pessoa serial not null,
	nome_pessoa varchar(60) not null,
	data_nascimento date not null,
	genero varchar(2) not null,
	pne varchar(3) not null,
	altura integer not null,
	peso integer not null,
	cpf varchar(14) not null,
	tipo_pessoa varchar(10) not null, 	
	codigo_endereco integer not null,
	codigo_profissao integer not null,
	
	constraint pk_pes_codigo_pessoa primary key (codigo_pessoa),
	constraint un_pes_cpf unique (cpf),
	constraint fk_pes_codigo_endereco foreign key (codigo_endereco) references endereco (codigo_endereco),
	constraint fk_pes_codigo_profissao foreign key (codigo_profissao) references profissao (codigo_profissao)
);