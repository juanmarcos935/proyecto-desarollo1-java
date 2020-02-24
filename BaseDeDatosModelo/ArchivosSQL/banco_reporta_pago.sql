
--
-- TABLE: banco_reporta_pago
-- 
--  

CREATE TABLE banco_reporta_pago (
  pago_banco_codigo int NOT NULL ,
  banco_codigo int NOT NULL 
);
CREATE SEQUENCE banco_reporta_pago_pago_banco_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE banco_reporta_pago ALTER COLUMN pago_banco_codigo SET NOT 0;
ALTER TABLE banco_reporta_pago ALTER COLUMN pago_banco_codigo SET DEFAULT nextval('banco_reporta_pago_pago_banco_codigo_seq');

-- 
ALTER TABLE banco_reporta_pago ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (pago_banco_codigo);

-- 
ALTER TABLE banco_reporta_pago ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (pago_banco_codigo);

-- 
ALTER TABLE banco_reporta_pago ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (banco_codigo) REFERENCES banco(banco_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
