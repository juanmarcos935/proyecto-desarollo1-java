
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

INSERT INTO cliente (id_cliente, cliente_tipo, cliente_nombre, cliente_apellidos, cliente_direccion, cliente_ciudad, cliente_cc, cliente_estado) VALUES (default, 1, 'cristian', 'pascumal', 'Calle 9D #26-34', 'El Placer', '1144982379', default);

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

INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes) VALUES (default, 'Plan 1', 30900, 250, 1, 100);
INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes) VALUES (default, 'Plan 2', 39900, 150, 4.5, 100);
INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes) VALUES (default, 'Plan 3', 49900, 300, 8.5, 100);
INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes) VALUES (default, 'Plan 4', 65000, 1000, 20, 9999999);
INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes) VALUES (default, 'Plan 5', 100000, 9999999, 30, 9999999);

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

INSERT INTO voz (id_voz, voz_nombre, voz_minutos) VALUES (default, 'EEUU', 9999999);
INSERT INTO voz (id_voz, voz_nombre, voz_minutos) VALUES (default, 'Canada', 9999999);
INSERT INTO voz (id_voz, voz_nombre, voz_minutos) VALUES (default, 'Puerto Rico', 9999999);

--
-- TABLE: planes_voz
--
--

CREATE TABLE planes_voz (
  id_planes_voz int NOT NULL,
  id_voz int NOT NULL,
  id_plan int NOT NULL
);
CREATE SEQUENCE voz_codigo_plan_voz START 1 INCREMENT 1;
ALTER TABLE planes_voz ALTER COLUMN id_planes_voz SET DEFAULT nextval('voz_codigo_plan_voz');
ALTER TABLE planes_voz ADD CONSTRAINT nueva_restricción_fclave_voz_planes_voz FOREIGN KEY (id_voz) REFERENCES voz(id_voz) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE planes_voz ADD CONSTRAINT nueva_restricción_fclave_plan_planes_voz FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE planes_voz ADD CONSTRAINT nueva_restricción_única_plan_voz PRIMARY KEY (id_planes_voz);

INSERT INTO planes_voz (id_planes_voz, id_voz, id_plan) VALUES (default, 1, 5);
INSERT INTO planes_voz (id_planes_voz, id_voz, id_plan) VALUES (default, 1, 5);
INSERT INTO planes_voz (id_planes_voz, id_voz, id_plan) VALUES (default, 1, 5);

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

INSERT INTO aplicaciones (id_aplicaciones, aplicaciones_nombre, aplicaciones_megabytes) VALUES (default, 'Whatsapp', 250);
INSERT INTO aplicaciones (id_aplicaciones, aplicaciones_nombre, aplicaciones_megabytes) VALUES (default, 'Facebook', 250);
INSERT INTO aplicaciones (id_aplicaciones, aplicaciones_nombre, aplicaciones_megabytes) VALUES (default, 'Whatsapp', 500);
INSERT INTO aplicaciones (id_aplicaciones, aplicaciones_nombre, aplicaciones_megabytes) VALUES (default, 'Facebook', 500);
INSERT INTO aplicaciones (id_aplicaciones, aplicaciones_nombre, aplicaciones_megabytes) VALUES (default, 'Whatsapp', 9999999);
INSERT INTO aplicaciones (id_aplicaciones, aplicaciones_nombre, aplicaciones_megabytes) VALUES (default, 'Facebook', 9999999);
INSERT INTO aplicaciones (id_aplicaciones, aplicaciones_nombre, aplicaciones_megabytes) VALUES (default, 'Waze', 9999999);

--
-- TABLE: planes_aplicaciones
--
--

CREATE TABLE planes_aplicaciones (
  id_planes_aplicacion int NOT NULL,
  id_aplicaciones int NOT NULL,
  id_plan int NOT NULL
);
CREATE SEQUENCE codigo_plan_app START 1 INCREMENT 1 ;
ALTER TABLE planes_aplicaciones ALTER COLUMN id_planes_aplicacion SET DEFAULT nextval('codigo_plan_app');
ALTER TABLE planes_aplicaciones ADD CONSTRAINT nueva_restricción_fclave_aplicaciones_planes_plan FOREIGN KEY (id_aplicaciones) REFERENCES aplicaciones(id_aplicaciones) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE planes_aplicaciones ADD CONSTRAINT nueva_restricción_fclave_plan_planes_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE planes_aplicaciones ADD CONSTRAINT nueva_restricción_única_plan_aplicacion PRIMARY KEY (id_planes_aplicacion);

--
-- TABLE: cliente_contrata_plan
-- 
--  

CREATE TABLE cliente_contrata_plan (
  id_contrato int NOT NULL ,
  id_cliente int NOT NULL ,
  id_plan int NOT NULL ,
  linea varchar(60) NOT NULL,
  contrato_fecha timestamp NOT NULL ,
  opcion_renovacion int NOT NULL
);
CREATE SEQUENCE cliente_contrata_plan_contrato_codigo_seq START 1 INCREMENT 1 ;

ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restriccion_unica_telefono_cliente_planes UNIQUE (cliente_telefono);

ALTER TABLE cliente_contrata_plan ALTER COLUMN id_contrato SET DEFAULT nextval('cliente_contrata_plan_contrato_codigo_seq');

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_única_cliente_contrata_plan PRIMARY KEY (id_contrato);

-- 


-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_contrata_plan_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_contrata_plan_clienten FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- Inserts Tuplas de Prueba

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 1, 'admin', 'admin', 'juan', 'mejia', '0123456789', '4881551', 1);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 1, 'admin2', 'admin2', 'david', 'ospina', '7788332122', '3212121', 0);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 2, 'gerente', 'gerente', 'james', 'rodriguez', '9876543210', '3991516', 1);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 2, 'gerente2', 'gerente2', 'santiago', 'arias', '7788280192', '3455679', 0);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 3, 'operador', 'operador', 'juan', 'cuadrado', '1112223334', '3789001', 1);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 3, 'operador2', 'operador2', 'juan', 'quintero', '9911990120', '3556189', 0);

