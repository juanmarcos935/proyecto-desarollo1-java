
--
-- TABLE: consumo_adicionales
-- 
--  

CREATE TABLE consumo_adiconales (
  id_contrato int NOT NULL ,
  min_whatsapp_restantes int NOT NULL ,
  chat_whatsapp_restantes int NOT NULL ,
  chat_facebook_restantes int NOT NULL ,
  gigas_compartidas_restantes int NOT NULL  DEFAULT 0
);

-- 
ALTER TABLE consumo_adiconales ADD CONSTRAINT nueva_restricción_fclave_consumoa_cliente FOREIGN KEY (id_contrato) REFERENCES cliente_contrata_plan(id_contrato) ON UPDATE NO ACTION ON DELETE NO ACTION;
