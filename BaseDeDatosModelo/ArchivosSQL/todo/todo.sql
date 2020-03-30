
--
-- TABLE: usuario
-- 
--  

CREATE TABLE usuario (
  id_usuario int NOT NULL ,
  usuario_tipo int NOT NULL,
  usuario_login varchar(60) NOT NULL,
  usuario_password varchar(60) NOT NULL,
  usuario_nombre varchar(60) NOT NULL ,
  usuario_Apellidos varchar(60) NOT NULL ,
  usuario_CC varchar(60) NOT NULL ,
  usuario_telefono varchar(60) NOT NULL ,
  usuario_estado int NOT NULL
);
CREATE SEQUENCE usuario_usuario_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_usuario_codigo_seq');

-- 
ALTER TABLE usuario ADD CONSTRAINT nueva_restricción_única_usuario PRIMARY KEY (id_usuario);
ALTER TABLE usuario ADD CONSTRAINT nueva_restricción_única_usuariologin UNIQUE (usuario_login);
ALTER TABLE usuario ADD CONSTRAINT nueva_restricción_única_usuarioCC UNIQUE (usuario_CC);


--
-- TABLE: banco
-- 
--  

CREATE TABLE banco (
  id_banco int NOT NULL
 
);

-- 
ALTER TABLE banco ADD CONSTRAINT nueva_restricción_única_banco PRIMARY KEY (id_banco);

-- 


--
-- TABLE: cliente
-- 
--  

CREATE TABLE cliente (
  id_cliente int NOT NULL ,
  cliente_tipo int NOT NULL , 	
  cliente_nombre varchar(60) NOT NULL ,
  cliente_apellidos varchar(60),
  cliente_telefono varchar(60) NOT NULL ,
  cliente_direccion varchar(60) NOT NULL ,
  cliente_ciudad varchar(60) NOT NULL ,
  cliente_estado int NOT NULL 
);
CREATE SEQUENCE cliente_cliente_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_cliente_codigo_seq');

-- 
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_única_cliente PRIMARY KEY (id_cliente);

-- 

--
-- TABLE: pago
-- 
--  

CREATE TABLE pago (
  id_pago int NOT NULL,
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
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave_pago_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave_pago_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE pago ADD CONSTRAINT nueva_restricción_fclave_pago_banco FOREIGN KEY (id_banco) REFERENCES banco(id_banco) ON UPDATE NO ACTION ON DELETE NO ACTION;


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


--
-- TABLE: adicionales
-- 
--  

CREATE TABLE adicionales (
  id_plan_adicionales int NOT NULL ,
  adicionales_minutos_whatsapp int NOT NULL ,
  adicionales_chat_whatsapp int NOT NULL ,
  adicionales_chat_facebook int NOT NULL ,
  adicionales_complejo1 boolean NOT NULL ,
  adicionales_complejo2 boolean NOT NULL 
);
CREATE SEQUENCE adicionales_plan_adicionales_id_seq START 1 INCREMENT 1 ;

ALTER TABLE adicionales ALTER COLUMN id_plan_adicionales SET DEFAULT nextval('adicionales_plan_adicionales_id_seq');

-- 
ALTER TABLE adicionales ADD CONSTRAINT nueva_restricción_única_adicionales PRIMARY KEY (id_plan_adicionales);


--
-- TABLE: plan
-- 
--  

CREATE TABLE plan (
  id_plan int NOT NULL ,
  plan_minutos int NOT NULL ,
  plan_datos int NOT NULL ,
  plan_mensajes int NOT NULL,
  plan_costo float NOT NULL ,
  id_plan_adicionales int NOT NULL 
);
CREATE SEQUENCE plan_plan_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE plan ALTER COLUMN id_plan SET DEFAULT nextval('plan_plan_codigo_seq');


-- 
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_única_plan PRIMARY KEY (id_plan);

-- 


-- 
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_fclave_plan_adicionales FOREIGN KEY (id_plan_adicionales) REFERENCES adicionales(id_plan_adicionales) ON UPDATE NO ACTION ON DELETE NO ACTION;


--
-- TABLE: cliente_contrata_plan
-- 
--  

CREATE TABLE cliente_contrata_plan (
  id_contrato int NOT NULL ,
  id_cliente int NOT NULL ,
  id_plan int NOT NULL ,
  contrato_fecha_corte date NOT NULL ,
  contrato_costo float NOT NULL ,
  contrato_mensajes_consumidos int NOT NULL  DEFAULT 0,
  contrato_datos_consumidos int NOT NULL  DEFAULT 0,
  contrato_min_consumidos int NOT NULL  DEFAULT 0
);
CREATE SEQUENCE cliente_contrata_plan_contrato_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE cliente_contrata_plan ALTER COLUMN id_contrato SET DEFAULT nextval('cliente_contrata_plan_contrato_codigo_seq');

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_única_cliente_contrata_plan PRIMARY KEY (id_contrato);

-- 


-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_contrata_plan_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_contrata_plan_clienten FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 


--
-- TABLE: consumo_adicionales
-- 
--  

CREATE TABLE consumo_adiconales (
  id_contrato int NOT NULL ,
  min_whatsapp_restantes int NOT NULL ,
  chat_whatsapp_restantes int NOT NULL ,
  chat_facebook_restantes int NOT NULL ,
  gigas_compartidas_restantes int NOT NULL  DEFAULT 0
);

-- 
ALTER TABLE consumo_adiconales ADD CONSTRAINT nueva_restricción_fclave_consumoa_cliente FOREIGN KEY (id_contrato) REFERENCES cliente_contrata_plan(id_contrato) ON UPDATE NO ACTION ON DELETE NO ACTION;


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
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave_gerente_registra_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave_gerente_registra_contrato FOREIGN KEY (id_contrato) REFERENCES cliente_contrata_plan(id_contrato) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE gerente_registra_plan ADD CONSTRAINT nueva_restricción_fclave__gerente_registra_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;


