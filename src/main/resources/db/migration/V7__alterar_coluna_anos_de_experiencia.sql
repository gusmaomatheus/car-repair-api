-- Remover constraint not null (campo não é obrigatório pelo modelo)
ALTER TABLE IF EXISTS consertos ALTER COLUMN anos_de_experiencia INTEGER;