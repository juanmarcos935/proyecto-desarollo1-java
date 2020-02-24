
--
-- TABLE: cliente_corporativo
-- 
--  

CREATE TABLE cliente_corporativo (
  cliente_codigo int NOT NULL ,
  cliente_NIT int(20) NOT NULL 
);

-- 
ALTER TABLE cliente_corporativo ADD CONSTRAINT nueva_restricción_única_1 UNIQUE (cliente_NIT);

-- 
ALTER TABLE cliente_corporativo ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (cliente_codigo) REFERENCES cliente(cliente_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;
