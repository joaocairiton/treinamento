create table profissao (
	codigo_profissao serial not null,
	nome_profissao varchar(30) not null,
	salario float not null,
	constraint pk_prof_codigo_profissao primary key (codigo_profissao)
);