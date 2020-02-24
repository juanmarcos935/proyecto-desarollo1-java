
--
-- TABLE: usuario_registra_usuario
-- 
--  

CREATE TABLE usuario_registra_usuario (
  usuario_registrador_codigo int NOT NULL ,
  usuario_codigo int NOT NULL 
);
CREATE SEQUENCE usuario_registra_usuario_usuario_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE usuario_registra_usuario ALTER COLUMN usuario_codigo SET NOT 0;
ALTER TABLE usuario_registra_usuario ALTER COLUMN usuario_codigo SET DEFAULT nextval('usuario_registra_usuario_usuario_codigo_seq');

-- 
ALTER TABLE usuario_registra_usuario ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (usuario_registrador_codigo) REFERENCES usuario_administrador(usuario_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
