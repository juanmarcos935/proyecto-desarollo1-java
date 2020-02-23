
--
-- TABLE: cliente
-- 
--  

CREATE TABLE cliente (
  cliente_tipo char NOT NULL ,
  cliente_nombre char NOT NULL ,
  cliente_telefono int(10) NOT NULL ,
  cliente_direccion char(20) NOT NULL ,
  cliente_ciudad char(20) NOT NULL ,
  cliente_cedula char NOT NULL ,
  cliente_codigo int(20) NOT NULL 
);
CREATE SEQUENCE cliente_cliente_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE cliente ALTER COLUMN cliente_codigo SET NOT 0;
ALTER TABLE cliente ALTER COLUMN cliente_codigo SET DEFAULT nextval('cliente_cliente_codigo_seq');

-- 
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (cliente_codigo);

-- 
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (cliente_cedula);


--
-- TABLE: cliente_contrata_plan
-- 
--  

CREATE TABLE cliente_contrata_plan (
  plan_contrato_codigo int NOT NULL ,
  cliente_codigo int NOT NULL ,
  plan_codigo int NOT NULL ,
  contrato_min_consumidos int NOT NULL  DEFAULT 0,
  contrato_datos_consumidos int NOT NULL  DEFAULT 0,
  contrato_mensajes_consumidos int NOT NULL  DEFAULT 0,
  contrato_costo float NOT NULL 
);
CREATE SEQUENCE cliente_contrata_plan_plan_contrato_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE cliente_contrata_plan ALTER COLUMN plan_contrato_codigo SET NOT 0;
ALTER TABLE cliente_contrata_plan ALTER COLUMN plan_contrato_codigo SET DEFAULT nextval('cliente_contrata_plan_plan_contrato_codigo_seq');

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (cliente_codigo);

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY () REFERENCES cliente() ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_1 FOREIGN KEY () REFERENCES plan() ON UPDATE NO ACTION ON DELETE NO ACTION;
