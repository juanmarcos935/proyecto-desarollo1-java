
--
-- TABLE: usuario_registra_usuario
-- 
--  

CREATE TABLE usuario_registra_usuario (
  usuario_registrador_codigo int NOT NULL ,
  id_usuario int NOT NULL 
);
CREATE SEQUENCE usuario_registra_usuario_usuario_codigo_seq START 1 INCREMENT 1 ;


-- 
ALTER TABLE usuario_registra_usuario ADD CONSTRAINT nueva_restricción_fclave_registrar_usuario FOREIGN KEY (usuario_registrador_codigo) REFERENCES usuario(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE usuario_registra_usuario ADD CONSTRAINT nueva_restricción_fclave_registrar_usuario2 FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;
