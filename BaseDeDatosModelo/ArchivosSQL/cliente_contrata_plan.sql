
--
-- TABLE: cliente_contrata_plan
-- 
--  

CREATE TABLE cliente_contrata_plan (
  id_contrato int NOT NULL ,
  id_cliente int NOT NULL ,
  id_plan int NOT NULL ,
  contrato_fecha_corte date NOT NULL ,
  contrato_costo float NOT NULL ,
  contrato_mensajes_consumidos int NOT NULL  DEFAULT 0,
  contrato_datos_consumidos int NOT NULL  DEFAULT 0,
  contrato_min_consumidos int NOT NULL  DEFAULT 0
);
CREATE SEQUENCE cliente_contrata_plan_contrato_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE cliente_contrata_plan ALTER COLUMN id_contrato SET DEFAULT nextval('cliente_contrata_plan_contrato_codigo_seq');

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_única_cliente_contrata_plan PRIMARY KEY (id_contrato);

-- 


-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_contrata_plan_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_contrata_plan_clienten FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 

