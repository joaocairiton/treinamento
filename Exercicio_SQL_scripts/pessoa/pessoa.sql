CREATE SEQUENCE IF NOT EXISTS pessoa_pes_codigo_pessoa_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE pessoa (
	codigo_pessoa     INTEGER     NOT NULL DEFAULT NEXTVAL('pessoa_pes_codigo_pessoa_seq'),
	nome              VARCHAR(60) NOT NULL,
	data_nascimento   DATE        NOT NULL,
	genero            VARCHAR(2)  NOT NULL,
	pne               VARCHAR(3)  NOT NULL,
	altura            INTEGER     NOT NULL,
	peso              INTEGER     NOT NULL,
	cpf               VARCHAR(14) NOT NULL,
	tipo_pessoa       VARCHAR(10) NOT NULL, 	
	codigo_endereco   INTEGER     NOT NULL,
	codigo_profissao  INTEGER     NOT NULL,
	
	CONSTRAINT pk_pes_codigo_pessoa    PRIMARY KEY (codigo_pessoa),
	CONSTRAINT un_pes_cpf              UNIQUE (cpf),
	CONSTRAINT fk_pes_codigo_endereco  FOREIGN KEY (codigo_endereco)  REFERENCES endereco (codigo_endereco),
	CONSTRAINT fk_pes_codigo_profissao FOREIGN key (codigo_profissao) REFERENCES profissao (codigo_profissao)
);
