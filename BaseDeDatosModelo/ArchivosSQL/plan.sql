
--
-- TABLE: plan
-- 
--  

CREATE TABLE plan (
  id_plan int NOT NULL ,
  plan_minutos int NOT NULL ,
  plan_datos int NOT NULL ,
  plan_mensajes int NOT NULL,
  plan_costo float NOT NULL ,
  id_plan_adicionales int NOT NULL 
);
CREATE SEQUENCE plan_plan_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE plan ALTER COLUMN id_plan SET DEFAULT nextval('plan_plan_codigo_seq');


-- 
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_única_plan PRIMARY KEY (id_plan);

-- 


-- 
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_fclave_plan_adicionales FOREIGN KEY (id_plan_adicionales) REFERENCES adicionales(id_plan_adicionales) ON UPDATE NO ACTION ON DELETE NO ACTION;
