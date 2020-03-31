
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
  id_banco int NOT NULL ,
  banco_nombre varchar(60) NOT NULL
 
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
  cliente_direccion varchar(60) NOT NULL ,
  cliente_ciudad varchar(60) NOT NULL ,
  cliente_CC varchar(60) NOT NULL , 
  cliente_estado int NOT NULL 
);
CREATE SEQUENCE cliente_cliente_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_cliente_codigo_seq');
ALTER TABLE cliente ALTER COLUMN cliente_estado SET DEFAULT 1;

-- 
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_única_cliente PRIMARY KEY (id_cliente);
ALTER TABLE cliente ADD CONSTRAINT nueva_restricción_documento_unico_cliente UNIQUE (cliente_CC);

-- 


--
-- TABLE: cliente_planes
-- 
--  

CREATE TABLE cliente_planes(
  id_cliente int NOT NULL ,
  cliente_telefono varchar(60) NOT NULL,
  id_plan int NOT NULL );
ALTER TABLE cliente_pĺanes ADD CONSTRAINT nueva_restriccion_unica_cliente_planes UNIQUE (cliente_Telefono);

ALTER TABLE cliente_planes ADD CONSTRAINT nueva_restricción_fclave_cliente_planes_id_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE cliente_planes ADD CONSTRAINT nueva_restricción_fclave_cliente_planes_id_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;
 
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
-- TABLE: plan
--
--
CREATE TABLE plan (
  id_plan int NOT NULL ,
  plan_nombre varchar(60) NOT NULL ,
  plan_costo int NOT NULL ,
  plan_minutos int NOT NULL ,
  plan_datos float NOT NULL ,
  plan_mensajes int NOT NULL
);

CREATE SEQUENCE plan_plan_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE plan ALTER COLUMN id_plan SET DEFAULT nextval('plan_plan_codigo_seq');
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_única_plan PRIMARY KEY (id_plan);

--
-- TABLE: voz
--
--

CREATE TABLE voz (
  id_voz int NOT NULL ,
  voz_nombre varchar(60) NOT NULL ,
  voz_minutos int NOT NULL
);

CREATE SEQUENCE voz_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE voz ALTER COLUMN id_voz SET DEFAULT nextval('voz_codigo_seq');
ALTER TABLE voz ADD CONSTRAINT nueva_restricción_única_voz PRIMARY KEY (id_voz);

--
-- TABLE: planes_voz
--
--

CREATE TABLE planes_voz (
  id_voz int NOT NULL,
  id_plan int NOT NULL
);
ALTER TABLE planes_voz ADD CONSTRAINT nueva_restricción_fclave_voz_planes_voz FOREIGN KEY (id_voz) REFERENCES voz(id_voz) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE planes_voz ADD CONSTRAINT nueva_restricción_fclave_plan_planes_voz FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;

--
-- TABLE: aplicaciones
--
--

CREATE TABLE aplicaciones (
  id_aplicaciones int NOT NULL ,
  aplicaciones_nombre varchar(60) NOT NULL ,
  aplicaciones_megabytes int NOT NULL
);

CREATE SEQUENCE aplicaciones_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE aplicaciones ALTER COLUMN id_aplicaciones SET DEFAULT nextval('aplicaciones_codigo_seq');
ALTER TABLE aplicaciones ADD CONSTRAINT nueva_restricción_única_aplicaciones PRIMARY KEY (id_aplicaciones);

--
-- TABLE: planes_aplicaciones
--
--

CREATE TABLE planes_aplicaciones (
  id_aplicaciones int NOT NULL,
  id_plan int NOT NULL
);
ALTER TABLE planes_aplicaciones ADD CONSTRAINT nueva_restricción_fclave_aplicaciones_planes_plan FOREIGN KEY (id_aplicaciones) REFERENCES aplicaciones(id_aplicaciones) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE planes_aplicaciones ADD CONSTRAINT nueva_restricción_fclave_plan_planes_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;

--
-- TABLE: cliente_contrata_plan
-- 
--  

CREATE TABLE cliente_contrata_plan (
  id_contrato int NOT NULL ,
  id_cliente int NOT NULL ,
  id_plan int NOT NULL ,
  contrato_fecha_corte date NOT NULL ,
  contrato_costo int NOT NULL ,
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

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 1, 'admin', 'admin', 'juan', 'mejia', '0123456789', '4881551', 1);

