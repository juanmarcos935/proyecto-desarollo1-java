
--
-- TABLE: gerente_registra_plan
-- 
--  

CREATE TABLE gerente_registra_plan (
  id_usuario int NOT NULL ,
  id_contrato int NOT NULL ,
  id_cliente int  NOT NULL ,
  contrato_fecha date NOT NULL 
);

-- 
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave_gerente_registra_usuario FOREIGN KEY (id_usuario) REFERENCES usuario_gerente(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave_gerente_registra_contrato FOREIGN KEY (id_contrato) REFERENCES cliente_contrata_plan(id_contrato) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave__gerente_registra_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;
