
--
-- TABLE: plan
-- 
--  

CREATE TABLE plan (
  plan_codigo int(10) NOT NULL ,
  plan_minutos int(10) NOT NULL ,
  plan_datos int(20) NOT NULL ,
  plan_mensajes int(10) DEFAULT 100,
  plan_costo float(30) NOT NULL ,
  plan_adicionales_id int NOT NULL 
);
CREATE SEQUENCE plan_plan_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE plan ALTER COLUMN plan_codigo SET NOT 0;
ALTER TABLE plan ALTER COLUMN plan_codigo SET DEFAULT nextval('plan_plan_codigo_seq');
CREATE SEQUENCE plan_plan_costo_seq START 1 INCREMENT 1 ;
ALTER TABLE plan ALTER COLUMN plan_costo SET NOT 0;
ALTER TABLE plan ALTER COLUMN plan_costo SET DEFAULT nextval('plan_plan_costo_seq');

-- 
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (plan_codigo);

-- 
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (plan_codigo);

-- 
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (plan_adicionales_id) REFERENCES adicionales(plan_adicionales_id) ON UPDATE NO ACTION ON DELETE NO ACTION;
