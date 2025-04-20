CREATE TABLE IF NOT EXISTS consertos (
    id INTEGER,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    anos_de_experiencia INTEGER NOT NULL,
    marca  VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_consertos PRIMARY KEY (id),
    CONSTRAINT chk_anos_experiencia CHECK (anos_de_experiencia >= 0),
);