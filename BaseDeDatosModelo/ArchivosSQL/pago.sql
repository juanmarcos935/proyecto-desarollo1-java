
--
-- TABLE: pago
-- 
--  

CREATE TABLE pago (
  id_pago int NOT NULL ,
  id_usuario int,
  id_banco int,
  id_cliente int NOT NULL 
);
CREATE SEQUENCE pago_pago_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE pago ALTER COLUMN id_pago SET DEFAULT nextval('pago_pago_codigo_seq');

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_única_pago PRIMARY KEY (id_pago);

-- 


-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave_pago_usuario FOREIGN KEY (id_usuario) REFERENCES usuario_operador(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave_pago_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave_pago_banco FOREIGN KEY (id_banco) REFERENCES banco(id_banco) ON UPDATE NO ACTION ON DELETE NO ACTION;
