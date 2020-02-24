
--
-- TABLE: usuario_operador
-- 
--  

CREATE TABLE usuario_operador (
  id_usuario int NOT NULL 
);

-- 


-- 
ALTER TABLE usuario_operador ADD CONSTRAINT nueva_restricción_única_usu_ope PRIMARY KEY (id_usuario);

-- 
ALTER TABLE usuario_operador ADD CONSTRAINT nueva_restricción_fclave_opera_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;
