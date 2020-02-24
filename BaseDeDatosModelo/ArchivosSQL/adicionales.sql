
--
-- TABLE: adicionales
-- 
--  

CREATE TABLE adicionales (
  plan_adicionales_id int(10) NOT NULL ,
  adicionales_minutos_whatsapp int(10) NOT NULL ,
  adicionales_chat_whatsapp int(10) NOT NULL ,
  adicionales_chat_facebook int(10) NOT NULL ,
  adicionales_complejo1 boolean(1) NOT NULL ,
  adicionales_complejo2 boolean(1) NOT NULL 
);
CREATE SEQUENCE adicionales_plan_adicionales_id_seq START 1 INCREMENT 1 ;
ALTER TABLE adicionales ALTER COLUMN plan_adicionales_id SET NOT 0;
ALTER TABLE adicionales ALTER COLUMN plan_adicionales_id SET DEFAULT nextval('adicionales_plan_adicionales_id_seq');

-- 
ALTER TABLE adicionales ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (plan_adicionales_id);

-- 
ALTER TABLE adicionales ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (plan_adicionales_id);
