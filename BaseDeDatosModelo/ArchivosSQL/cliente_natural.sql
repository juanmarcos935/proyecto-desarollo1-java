
--
-- TABLE: cliente_natural
-- 
--  

CREATE TABLE cliente_natural (
  cliente_codigo int NOT NULL ,
  cliente_lineas int(1) NOT NULL  DEFAULT 0,
  cliente_cedula int(20) NOT NULL 
);

-- 
ALTER TABLE cliente_natural ADD CONSTRAINT nueva_restricción_única UNIQUE (cliente_cedula);

-- 
ALTER TABLE cliente_natural ADD CONSTRAINT nueva_restricción_fclave FOREIGN KEY (cliente_codigo) REFERENCES cliente(cliente_codigo) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE cliente_natural ADD CONSTRAINT nueva_restricción_de_comprobación CHECK (cliente_lineas >3);
