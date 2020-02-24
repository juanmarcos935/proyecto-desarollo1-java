
--
-- TABLE: cliente_natural
-- 
--  

CREATE TABLE cliente_natural (
  id_cliente int NOT NULL ,
  cliente_lineas int NOT NULL  DEFAULT 0,
  cliente_cedula int NOT NULL 
);

-- 
ALTER TABLE cliente_natural ADD CONSTRAINT nueva_restricción_única_clienteCC UNIQUE (cliente_cedula);

-- 
ALTER TABLE cliente_natural ADD CONSTRAINT nueva_restricción_fclave_natural_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE cliente_natural ADD CONSTRAINT nueva_restricción_de_comprobación_natural CHECK (cliente_lineas >3);
