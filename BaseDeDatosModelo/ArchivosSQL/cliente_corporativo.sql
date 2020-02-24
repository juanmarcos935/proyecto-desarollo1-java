
--
-- TABLE: cliente_corporativo
-- 
--  

CREATE TABLE cliente_corporativo (
  id_cliente int NOT NULL ,
  cliente_NIT int NOT NULL 
);

-- 
ALTER TABLE cliente_corporativo ADD CONSTRAINT nueva_restricción_única_clientenit UNIQUE (cliente_NIT);

-- 
ALTER TABLE cliente_corporativo ADD CONSTRAINT nueva_restricción_fclave_corporativo_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;
