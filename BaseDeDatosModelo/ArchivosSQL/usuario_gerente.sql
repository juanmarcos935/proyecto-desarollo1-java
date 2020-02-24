
--
-- TABLE: usuario_gerente
-- 
--  

CREATE TABLE usuario_gerente (
  usuario_codigo int(10) NOT NULL 
);

-- 
ALTER TABLE usuario_gerente ADD CONSTRAINT nueva_restricción_única UNIQUE (usuario_codigo);

-- 
ALTER TABLE usuario_gerente ADD CONSTRAINT nueva_restricción_única_1 PRIMARY KEY (usuario_codigo);

-- 
ALTER TABLE usuario_gerente ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (usuario_codigo) REFERENCES usuario(usuario_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
