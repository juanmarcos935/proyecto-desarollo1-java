
--
-- TABLE: usuario_administrador
-- 
--  

CREATE TABLE usuario_administrador (
  usuario_codigo int NOT NULL 
);

-- 
ALTER TABLE usuario_administrador ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (usuario_codigo) REFERENCES usuario(usuario_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
