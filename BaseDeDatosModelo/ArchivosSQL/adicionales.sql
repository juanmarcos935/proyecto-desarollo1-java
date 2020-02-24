
--
-- TABLE: adicionales
-- 
--  

CREATE TABLE adicionales (
  id_plan_adicionales int NOT NULL ,
  adicionales_minutos_whatsapp int NOT NULL ,
  adicionales_chat_whatsapp int NOT NULL ,
  adicionales_chat_facebook int NOT NULL ,
  adicionales_complejo1 boolean NOT NULL ,
  adicionales_complejo2 boolean NOT NULL 
);
CREATE SEQUENCE adicionales_plan_adicionales_id_seq START 1 INCREMENT 1 ;

ALTER TABLE adicionales ALTER COLUMN id_plan_adicionales SET DEFAULT nextval('adicionales_plan_adicionales_id_seq');

-- 
ALTER TABLE adicionales ADD CONSTRAINT nueva_restricción_única_adicionales PRIMARY KEY (id_plan_adicionales);

-- 

