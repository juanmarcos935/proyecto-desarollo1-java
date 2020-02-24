
--
-- TABLE: cliente
-- 
--  

CREATE TABLE cliente (
  id_cliente int NOT NULL ,
  cliente_corporativo boolean NOT NULL , 	
  cliente_nombre char(20) NOT NULL ,
  cliente_apellidos char(20),
  cliente_telefono int NOT NULL ,
  cliente_direccion char(20) NOT NULL ,
  cliente_ciudad char(20) NOT NULL ,
  cliente_estado boolean NOT NULL 
);
CREATE SEQUENCE cliente_cliente_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_cliente_codigo_seq');

-- 
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_única_cliente PRIMARY KEY (id_cliente);

-- 


-- 

