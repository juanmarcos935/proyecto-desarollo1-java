
--
-- TABLE: cliente
-- 
--  

CREATE TABLE cliente (
  cliente_nombre char NOT NULL ,
  cliente_telefono int(10) NOT NULL ,
  cliente_direccion char(20) NOT NULL ,
  cliente_ciudad char(20) NOT NULL ,
  cliente_codigo int(20) NOT NULL ,
  cliente_estado boolean NOT NULL 
);
CREATE SEQUENCE cliente_cliente_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE cliente ALTER COLUMN cliente_codigo SET NOT 0;
ALTER TABLE cliente ALTER COLUMN cliente_codigo SET DEFAULT nextval('cliente_cliente_codigo_seq');

-- 
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (cliente_codigo);

-- 
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_única_1 UNIQUE ();

-- 
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_única_2 UNIQUE (cliente_codigo);
