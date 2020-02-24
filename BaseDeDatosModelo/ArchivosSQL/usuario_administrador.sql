
--
-- TABLE: usuario_administrador
-- 
--  

CREATE TABLE usuario_administrador (
  id_usuario int NOT NULL 
);

-- 
ALTER TABLE usuario_administrador ADD CONSTRAINT nueva_restricción_fclave_admin_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;
