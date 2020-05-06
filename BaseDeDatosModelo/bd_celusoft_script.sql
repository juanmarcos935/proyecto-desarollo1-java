
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
-- TABLE: plan
--
--
CREATE TABLE plan (
  id_plan int NOT NULL ,
  plan_nombre varchar(60) NOT NULL ,
  plan_costo int NOT NULL ,
  plan_minutos int NOT NULL ,
  plan_datos float NOT NULL ,
  plan_mensajes int NOT NULL , 
  plan_minutos_whatsapp int NOT NULL ,
  plan_chat_whatsapp int NOT NULL ,
  plan_facebook int NOT NULL , 
  plan_waze int NOT NULL , 
  plan_minutos_llamada_eeuu int NOT NULL ,
  plan_minutos_llamada_canada int NOT NULL ,
  plan_minutos_llamada_puertorico int NOT NULL ,
  plan_equipo_nuevo_asegurado int NOT NULL ,
  plan_datos_compartir_otros float NOT NULL
);

CREATE SEQUENCE plan_plan_codigo_seq START 1 INCREMENT 1 ;
ALTER TABLE plan ALTER COLUMN id_plan SET DEFAULT nextval('plan_plan_codigo_seq');
ALTER TABLE plan ADD CONSTRAINT nueva_restricción_única_plan PRIMARY KEY (id_plan);

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

ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restriccion_unica_telefono_cliente_planes UNIQUE (linea);

ALTER TABLE cliente_contrata_plan ALTER COLUMN id_contrato SET DEFAULT nextval('cliente_contrata_plan_contrato_codigo_seq');

ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_única_cliente_contrata_plan PRIMARY KEY (id_contrato);

ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_contrata_plan_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE cliente_contrata_plan ADD CONSTRAINT nueva_restricción_fclave_contrata_plan_clienten FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE factura (
  id_factura int NOT NULL ,
  id_contrato int NOT NULL ,
  cc_cliente varchar(60) NOT NULL ,
  nombre_cliente varchar(60) NOT NULL ,
  direccion_cliente varchar(60) NOT NULL ,
  ciudad_cliente varchar(60) NOT NULL ,
  nombre_plan varchar(60) NOT NULL ,
  linea varchar(60) NOT NULL ,
  consumo_minutos int NOT NULL ,
  consumo_datos float NOT NULL , 
  consumo_mensajes int NOT NULL ,
  consumo_minutos_whatsapp int NOT NULL ,
  consumo_chat_whatsapp int NOT NULL ,
  consumo_facebook int NOT NULL ,
  consumo_waze int NOT NULL ,
  consumo_llamada_eeuu int NOT NULL ,
  consumo_llamada_canada int NOT NULL ,
  consumo_llamada_puertorico int NOT NULL ,
  consumo_datos_compartir float NOT NULL ,
  cargo_basico int NOT NULL ,
  cargo_min_adicionales float NOT NULL ,
  cargo_renovaciones int NOT NULL ,
  ajuste_peso int NOT NULL ,
  total_pago int NOT NULL ,
  fecha_expedicion date NOT NULL ,
  fecha_vencimiento date NOT NULL ,
  fecha_pago date ,
  factura_pagada int NOT NULL
);

CREATE SEQUENCE factura_seq START 1 INCREMENT 1 ;
ALTER TABLE factura ALTER COLUMN id_factura SET DEFAULT nextval('factura_seq');
ALTER TABLE factura ALTER COLUMN fecha_pago SET DEFAULT NULL;
ALTER TABLE factura ALTER COLUMN factura_pagada SET DEFAULT 0;
ALTER TABLE factura ADD CONSTRAINT nueva_restricción_única_factura PRIMARY KEY (id_factura);
ALTER TABLE factura ADD CONSTRAINT nueva_restricción_fclave_factura FOREIGN KEY (id_contrato) REFERENCES cliente_contrata_plan(id_contrato) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- Inserts Tuplas de Prueba

-- Usuarios

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 1, 'admin', 'admin', 'juan', 'mejia', '0123456789', '4881551', 1);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 1, 'admin2', 'admin2', 'david', 'ospina', '7788332122', '3212121', 0);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 2, 'gerente', 'gerente', 'james', 'rodriguez', '9876543210', '3991516', 1);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 2, 'gerente2', 'gerente2', 'santiago', 'arias', '7788280192', '3455679', 0);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 3, 'operador', 'operador', 'juan', 'cuadrado', '1112223334', '3789001', 1);

INSERT INTO usuario (id_usuario, usuario_tipo, usuario_login, usuario_password, usuario_nombre, usuario_apellidos, usuario_cc, usuario_telefono, usuario_estado) VALUES (default, 3, 'operador2', 'operador2', 'juan', 'quintero', '9911990120', '3556189', 0);

-- Clientes

INSERT INTO cliente (id_cliente, cliente_tipo, cliente_nombre, cliente_apellidos, cliente_direccion, cliente_ciudad, cliente_cc, cliente_estado) VALUES (default, 1, 'cristian', 'pascumal', 'Calle 9D #26-34', 'El Placer', '1144982379', default);

-- Planes

INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes, plan_minutos_whatsapp, plan_chat_whatsapp, plan_facebook, plan_waze, plan_minutos_llamada_eeuu, plan_minutos_llamada_canada, plan_minutos_llamada_puertorico, plan_equipo_nuevo_asegurado, plan_datos_compartir_otros) VALUES (default, 'Plan 1', 30900, 250, 1, 100, 500, 250, 250, 0, 0, 0, 0, 0, 0);
INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes, plan_minutos_whatsapp, plan_chat_whatsapp, plan_facebook, plan_waze, plan_minutos_llamada_eeuu, plan_minutos_llamada_canada, plan_minutos_llamada_puertorico, plan_equipo_nuevo_asegurado, plan_datos_compartir_otros) VALUES (default, 'Plan 2', 39900, 150, 4.5, 100, 300, 250, 250, 0, 0, 0, 0, 0, 0);
INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes, plan_minutos_whatsapp, plan_chat_whatsapp, plan_facebook, plan_waze, plan_minutos_llamada_eeuu, plan_minutos_llamada_canada, plan_minutos_llamada_puertorico, plan_equipo_nuevo_asegurado, plan_datos_compartir_otros) VALUES (default, 'Plan 3', 49900, 300, 8.5, 100, 600, 500, 500, 0, 0, 0, 0, 0, 0);
INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes, plan_minutos_whatsapp, plan_chat_whatsapp, plan_facebook, plan_waze, plan_minutos_llamada_eeuu, plan_minutos_llamada_canada, plan_minutos_llamada_puertorico, plan_equipo_nuevo_asegurado, plan_datos_compartir_otros) VALUES (default, 'Plan 4', 65000, 1000, 20, 9999999, 9999999, 9999999, 9999999, 9999999, 0, 0, 0, 0, 0);
INSERT INTO plan (id_plan, plan_nombre, plan_costo, plan_minutos, plan_datos, plan_mensajes, plan_minutos_whatsapp, plan_chat_whatsapp, plan_facebook, plan_waze, plan_minutos_llamada_eeuu, plan_minutos_llamada_canada, plan_minutos_llamada_puertorico, plan_equipo_nuevo_asegurado, plan_datos_compartir_otros) VALUES (default, 'Plan 5', 100000, 9999999, 30, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999, 1, 3);

-- Cliente Contrata Plan

INSERT INTO cliente_contrata_plan (id_contrato, id_cliente, id_plan, linea, contrato_fecha, opcion_renovacion) VALUES (default, 1, 5, '3211234567', current_timestamp, 1);

