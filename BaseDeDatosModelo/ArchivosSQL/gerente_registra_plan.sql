
--
-- TABLE: gerente_registra_plan
-- 
--  

CREATE TABLE gerente_registra_plan (
  usuario_codigo int NOT NULL ,
  contrato_codigo int NOT NULL ,
  cliente_codigo int NOT NULL ,
  contrato_fecha date(20) NOT NULL 
);

-- 
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (usuario_codigo) REFERENCES usuario_gerente(usuario_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave_1 FOREIGN KEY (contrato_codigo) REFERENCES cliente_contrata_plan(contrato_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave_2 FOREIGN KEY (cliente_codigo) REFERENCES cliente(cliente_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
