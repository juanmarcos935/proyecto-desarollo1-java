
--
-- TABLE: banco
-- 
--  

CREATE TABLE banco (
  banco_codigo int NOT NULL 
);

-- 
ALTER TABLE banco ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (banco_codigo);

-- 
ALTER TABLE banco ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (banco_codigo);
