
--
-- TABLE: consumo_adiconales
-- 
--  

CREATE TABLE consumo_adiconales (
  cliente_codigo int(10) NOT NULL ,
  consumo_min_whatsapp int(10) NOT NULL ,
  consumo_chat_whatsapp int(10) NOT NULL ,
  consumo_chat_facebook int(10) NOT NULL ,
  gigas_compartidas int(10) NOT NULL  DEFAULT 0
);

-- 
ALTER TABLE consumo_adiconales ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (cliente_codigo) REFERENCES cliente_contrata_plan(cliente_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
