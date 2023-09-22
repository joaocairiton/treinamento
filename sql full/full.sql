CREATE SEQUENCE IF NOT EXISTS bairro_brr_codigo_do_bairro_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE bairro (
    codigo         INTEGER         NOT NULL DEFAULT NEXTVAL('bairro_brr_codigo_do_bairro_seq'),
    nome           VARCHAR(50)     NOT NULL,
    valor_do_iptu  DECIMAL(7,2)    NOT null,
	
    CONSTRAINT pk_brr_codigo_do_bairro PRIMARY KEY (codigo)	
);
INSERT INTO bairro (nome, valor_do_iptu)
VALUES ('village atalaia', 11123.63),
       ('itatiaia', 23600.59 ),
       ('Santa Genoveva', 3115.20 ),
       ('Jardim pompeia', 100.10 ),
       ('Jardim Guanabara', 250.58 ),
       ('São judas tadeu', 150.85 ),
       ('Goiania 2', 268.47 ),
       ('Jardim Floresta', 850.65 ),
       ('centro', 478.14 ),
       ('setor oeste', 784.58 ),
       ('setor sul', 458.15 ),
       ('setor universitario', 362.25 ),
       ('novo mundo', 581.52 ),
       ('crimeia oeste', 695.48 ),
       ('cimeia leste', 915.25 );



CREATE SEQUENCE IF NOT EXISTS endereco_end_codigo_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE endereco (
    codigo          INTEGER       NOT NULL DEFAULT NEXTVAL('endereco_end_codigo_seq'),
    rua             VARCHAR(30)   NOT NULL,
    numero          VARCHAR(10),
    complemento     VARCHAR(30)   NOT NULL,
    cep             VARCHAR(10)   NOT NULL,
    codigo_do_bairro   INTEGER       NOT NULL,
	
    CONSTRAINT pk_end_codigo_do_endereco PRIMARY KEY (codigo),
    CONSTRAINT fk_end_codigo_do_bairro   FOREIGN KEY (codigo_do_bairro) REFERENCES bairro (codigo)	
);

INSERT INTO endereco (rua, numero, complemento, cep, codigo_do_bairro) 
VALUES ('rua va 1', '001', 'casa', '74692150', 1 ),
       ('Viela A', '025', 'casa', '74450410', 2),
       ('Estrada A', 's/n', 'apartamento', '74711100', 3),
       ('Praça A', '584', 'casa', '74363170', 4),
       ('Praça A', '251', 'casa', '74870010', 5),
       ('Avenida A', '145', 'apartamento', '74805020', 6),
       ('Praça A', '201', 'casa', '74805050' , 7),
       ('Praça A', '204', 'casa', '74685800', 8),
       ('Travessa A', '021', 'apartamento', '74780380', 9),
       ('Rua A', '145', 'casa', '74475010', 10),
       ('Avenida A', '569', 'casa', '74853010', 11),
       ('Rua A', 's/n', 'casa', '74710245', 12),
       ('Rua A', '632', 'casa', '74580500', 13),
       ('Avenida A', '058', 'apartamento', '74723010', 14),
       ('Praça A', '362', 'casa', '74415040', 15);
	   
	   select * from endereco
	   
	   
CREATE SEQUENCE IF NOT EXISTS profissao_prof_codigo_da_profissao_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807 
START 1
CACHE 1;

CREATE TABLE profissao (
    codigo INTEGER      NOT NULL DEFAULT NEXTVAL('profissao_prof_codigo_da_profissao_seq'),
    nome             VARCHAR(30)  NOT NULL,
    salario          DECIMAL(5,2) NOT NULL,
	
    CONSTRAINT pk_prof_codigo_da_profissao PRIMARY KEY (codigo)
);

INSERT INTO profissao (nome, salario)
VALUES ('trainee dev', 111.00),
       ('gerente', 118.00),
       ('tecnico', 115.00),
       ('diretor', 119.00),
       ('supervisor', 115.00),
       ('promotor', 112.00),
       ('entregador', 112.00),
       ('estagiario', 111.00);
	   
	   
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
	
	
INSERT INTO pessoa (nome, data_de_nascimento, genero, portador_de_necessidade_especiais, altura, peso, cpf, tipo_de_pessoa, codigo_do_endereco, codigo_da_profissao)
			VALUES ('joao', '1983-01-18', 'M', 'nao', 1.83, 75, '196.133.730-47', 'juridica',1 , 1),
				   ('bastiao', '1958-05-18', 'M', 'nao', 1.85, 70, '964.156.020-47', 'fisica',2 , 2),
				   ('godofredo', '1999-05-01', 'M', 'sim', 1.62, 50, '522.913.320-15', 'especial',3 , 5),
				   ('bastiao', '1958-05-18', 'M', 'nao', 1.83, 75, '085.228.760-70', 'fisica',4 , 8),
				   ('fulano', '2000-12-18', 'M', 'nao', 1.50, 65, '982.039.500-35', 'juridica',5 , 7),
				   ('beltrano', '1995-08-18', 'M', 'nao', 1.89, 75, '739.557.970-40', 'fisica',2 , 2);
				   
				   
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

INSERT INTO compra (valor_total, codigo_da_pessoa)
VALUES (25, 1),
       (15, 3),
       (62, 5),
       (250, 4),
       (362, 5),
       (85, 3),
       (150, 2),
       (48, 6)


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

INSERT INTO item_compra (nome, valor, codigo_da_compra)
VALUES ('arroz', 25, 1),
       ('feijao', 15, 2),
       ('azeite', 31, 3),
       ('arroz', 25, 1),
       ('oleo', 250, 4),
       ('pneu', 362, 5)
