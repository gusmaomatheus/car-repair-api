ALTER TABLE IF EXISTS consertos ADD COLUMN ativo BOOLEAN DEFAULT true;

-- Meu banco está em memória, então não seria necessário. Mas é bom para ter ciência de que em um cenário real isso é ESSENCIAL!
UPDATE consertos SET ativo = true;