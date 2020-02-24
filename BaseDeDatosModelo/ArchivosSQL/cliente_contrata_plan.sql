
--
-- TABLE: cliente_contrata_plan
-- 
--  

CREATE TABLE cliente_contrata_plan (
  contrato_codigo int(10) NOT NULL ,
  cliente_codigo int(10) NOT NULL ,
  plan_codigo int(10) NOT NULL ,
  contrato_fecha_corte date(20) NOT NULL ,
  contrato_costo float(10) NOT NULL ,
  contrato_mensajes_consumidos int(10) NOT NULL  DEFAULT 0,
  contrato_datos_consumidos int(20) NOT NULL  DEFAULT 0,
  contrato_min_consumidos int(10) NOT NULL  DEFAULT 0
);
CREATE SEQUENCE cliente_contrata_plan_contrato_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE cliente_contrata_plan ALTER COLUMN contrato_codigo SET NOT 0;
ALTER TABLE cliente_contrata_plan ALTER COLUMN contrato_codigo SET DEFAULT nextval('cliente_contrata_plan_contrato_codigo_seq');

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (contrato_codigo);

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (contrato_codigo);

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (plan_codigo) REFERENCES plan(plan_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_1 FOREIGN KEY (cliente_codigo) REFERENCES cliente_natural(cliente_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_2 FOREIGN KEY (cliente_codigo) REFERENCES cliente_corporativo(cliente_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
