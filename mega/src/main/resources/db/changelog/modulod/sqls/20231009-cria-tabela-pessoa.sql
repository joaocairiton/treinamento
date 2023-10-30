CREATE SEQUENCE IF NOT EXISTS pessoa_pes_codigo_da_pessoa_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE pessoa (
	codigo                            INTEGER     NOT NULL DEFAULT NEXTVAL('pessoa_pes_codigo_da_pessoa_seq'),
	nome                              VARCHAR(60) NOT NULL,
	data_de_nascimento                DATE        NOT NULL,
	genero                            VARCHAR(2)  NOT NULL,
	portador_de_necessidade_especiais VARCHAR(3)  NOT NULL,
	altura                            INTEGER     NOT NULL,
	peso                              INTEGER     NOT NULL,
	cpf                               VARCHAR(15) NOT NULL,
	tipo_de_pessoa                    VARCHAR(10) NOT NULL, 	
	codigo_do_endereco                INTEGER     NOT NULL,
	codigo_da_profissao               INTEGER     NOT NULL,
	
	CONSTRAINT pk_pessoa_codigo_da_pessoa    PRIMARY KEY (codigo),
	CONSTRAINT un_pessoa_cpf              UNIQUE (cpf),
	CONSTRAINT fk_pessoa_codigo_do_endereco  FOREIGN KEY (codigo_do_endereco)  REFERENCES endereco (codigo),
	CONSTRAINT fk_pessoa_codigo_da_profissao FOREIGN key (codigo_da_profissao) REFERENCES profissao (codigo)
);