CREATE TABLE principio_ativo(
   id_principio_ativo serial NOT NULL,
   nome_principio_ativo varchar(100) NOT NULL UNIQUE,
   observacao_principio_ativo varchar(500),
  CONSTRAINT pk_principio_ativo PRIMARY KEY (id_principio_ativo));

CREATE TABLE remedio(
    id_remedio serial NOT NULL,
    nome_remedio varchar(200) NOT NULL UNIQUE,
    preco_remedio numeric(10,2),
CONSTRAINT pk_remedio PRIMARY KEY (id_remedio));