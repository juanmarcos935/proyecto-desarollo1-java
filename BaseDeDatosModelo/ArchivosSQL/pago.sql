
--
-- TABLE: pago
-- 
--  

CREATE TABLE pago (
  pago_codigo int NOT NULL ,
  usuario_codigo int,
  cliente_codigo int NOT NULL 
);
CREATE SEQUENCE pago_pago_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE pago ALTER COLUMN pago_codigo SET NOT 0;
ALTER TABLE pago ALTER COLUMN pago_codigo SET DEFAULT nextval('pago_pago_codigo_seq');

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_única PRIMARY KEY (pago_codigo);

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (pago_codigo);

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (usuario_codigo) REFERENCES usuario_operador(usuario_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave_1 FOREIGN KEY (pago_codigo) REFERENCES cliente(cliente_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave_2 FOREIGN KEY () REFERENCES banco_reporta_pago() ON UPDATE NO ACTION ON DELETE NO ACTION;
