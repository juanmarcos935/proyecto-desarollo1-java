
--
-- TABLE: usuario_operador
-- 
--  

CREATE TABLE usuario_operador (
  usuario_codigo int NOT NULL 
);

-- 
ALTER TABLE usuario_operador ADD CONSTRAINT nueva_restricción_única UNIQUE (usuario_codigo);

-- 
ALTER TABLE usuario_operador ADD CONSTRAINT nueva_restricción_única_1 PRIMARY KEY (usuario_codigo);

-- 
ALTER TABLE usuario_operador ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (usuario_codigo) REFERENCES usuario(usuario_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
