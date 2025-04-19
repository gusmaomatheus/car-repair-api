CREATE TABLE mecanicos (
   id INTEGER,
   nome VARCHAR(255) NOT NULL,
   anos_de_experiencia INT NOT NULL,
   CONSTRAINT chk_anos_experiencia CHECK (anos_de_experiencia >= 0),
   CONSTRAINT pk_mecanicos PRIMARY KEY (id)
);

CREATE TABLE veiculos (
    id INTEGER,
    marca  VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_veiculos PRIMARY KEY (id)
);