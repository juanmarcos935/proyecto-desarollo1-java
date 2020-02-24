
--
-- TABLE: usuario_gerente
-- 
--  

CREATE TABLE usuario_gerente (
  id_usuario int NOT NULL 
);

-- 


-- 
ALTER TABLE usuario_gerente ADD CONSTRAINT nueva_restricción_usuario_gerente PRIMARY KEY (id_usuario);

-- 
ALTER TABLE usuario_gerente ADD CONSTRAINT nueva_restricción_fclave_usuario_gerente_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;
