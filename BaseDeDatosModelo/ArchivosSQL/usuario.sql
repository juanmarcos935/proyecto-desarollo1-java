
--
-- TABLE: usuario
-- 
--  

CREATE TABLE usuario (
  id_usuario int NOT NULL ,
  usuario_tipo int NOT NULL,
  usuario_login char(20) NOT NULL,
  usuario_password char(20) NOT NULL,
  usuario_nombre char(20) NOT NULL ,
  usuario_Apellidos char(20) NOT NULL ,
  usuario_CC int NOT NULL ,
  usuario_telefono int NOT NULL ,
  usuario_estado int NOT NULL
);
CREATE SEQUENCE usuario_usuario_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_usuario_codigo_seq');

-- 
ALTER TABLE usuario ADD CONSTRAINT nueva_restricción_única_usuario PRIMARY KEY (id_usuario);
ALTER TABLE usuario ADD CONSTRAINT nueva_restricción_única_usuariologin UNIQUE (usuario_login);
ALTER TABLE usuario ADD CONSTRAINT nueva_restricción_única_usuarioCC UNIQUE (usuario_CC);
