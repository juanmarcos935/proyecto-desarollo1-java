
--
-- TABLE: usuario
-- 
--  

CREATE TABLE usuario (
  usuario_codigo int NOT NULL 
);
CREATE SEQUENCE usuario_usuario_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE usuario ALTER COLUMN usuario_codigo SET NOT 0;
ALTER TABLE usuario ALTER COLUMN usuario_codigo SET DEFAULT nextval('usuario_usuario_codigo_seq');

-- 
ALTER TABLE usuario ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (usuario_codigo);

-- 
ALTER TABLE usuario ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (usuario_codigo);
