-- Remover NOT NULL de colunas não obrigatórias

DROP TABLE IF EXISTS consertos;

CREATE TABLE IF NOT EXISTS consertos (
    id INTEGER AUTO_INCREMENT,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    anos_de_experiencia INTEGER,
    marca  VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano    VARCHAR(255) NOT NULL,
    cor VARCHAR(255),
    ativo BOOLEAN DEFAULT TRUE,
    CONSTRAINT pk_consertos PRIMARY KEY (id)
);