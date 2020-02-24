
--
-- TABLE: banco_reporta_pago
-- 
--  

CREATE TABLE banco_reporta_pago (
  id_registro int NOT NULL ,
  id_banco int NOT NULL ,
  id_cliente int NOT NULL
 
);


-- 
ALTER TABLE banco_reporta_pago ADD CONSTRAINT nueva_restricción_única_banco_reporta_pago PRIMARY KEY (id_registro);

-- 


-- 
ALTER TABLE banco_reporta_pago ADD CONSTRAINT nueva_restricción_fclave_banco_reporta_banco FOREIGN KEY (id_banco) REFERENCES banco(id_banco) ON UPDATE NO ACTION ON DELETE NO ACTION;
