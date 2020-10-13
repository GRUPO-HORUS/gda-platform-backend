/*
PostgreSQL Backup
Database: gda_dev/public
Backup Time: 2020-10-13 10:24:05
*/

DROP TABLE IF EXISTS "public"."gda_atributo_categoria_bien";
DROP TABLE IF EXISTS "public"."gda_bien";
DROP TABLE IF EXISTS "public"."gda_bien_asignaciones";
DROP TABLE IF EXISTS "public"."gda_bien_datos_contables";
DROP TABLE IF EXISTS "public"."gda_bien_fijo_datos";
DROP TABLE IF EXISTS "public"."gda_bien_tipo";
DROP TABLE IF EXISTS "public"."gda_bien_traza";
DROP TABLE IF EXISTS "public"."gda_cargo";
DROP TABLE IF EXISTS "public"."gda_categoria_bien";
DROP TABLE IF EXISTS "public"."gda_coeficiente_reevaluo";
DROP TABLE IF EXISTS "public"."gda_entidad";
DROP TABLE IF EXISTS "public"."gda_instrumento_bien";
DROP TABLE IF EXISTS "public"."gda_origen_movimiento";
DROP TABLE IF EXISTS "public"."gda_roles";
DROP TABLE IF EXISTS "public"."gda_solicitud";
DROP TABLE IF EXISTS "public"."gda_solicitud_aprobaciones_realizadas";
DROP TABLE IF EXISTS "public"."gda_solicitud_bien_por_categoria";
DROP TABLE IF EXISTS "public"."gda_solicitud_paso_ruta_participantes";
DROP TABLE IF EXISTS "public"."gda_solicitud_ruta_aprobacion";
DROP TABLE IF EXISTS "public"."gda_solictud_bien_espefico";
DROP TABLE IF EXISTS "public"."gda_tipo_instrumento";
DROP TABLE IF EXISTS "public"."gda_tipo_solicitud";
DROP TABLE IF EXISTS "public"."gda_tipo_unidad";
DROP TABLE IF EXISTS "public"."gda_unidad";
DROP TABLE IF EXISTS "public"."gda_usuario";
DROP TABLE IF EXISTS "public"."gda_usuario_puesto";
DROP TABLE IF EXISTS "public"."gda_usuario_roles";
DROP TABLE IF EXISTS "public"."gda_valores_seleccion_atributo_categoria_bien";
CREATE TABLE "gda_atributo_categoria_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "nombre" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "requerido" bool,
  "unico" bool,
  "tipo_dato" varchar(50) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_atributo_categoria_bien" OWNER TO "postgres";
CREATE TABLE "gda_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "rotulado" varchar(15) COLLATE "pg_catalog"."default",
  "fecha_incorporacion" timestamp(6) NOT NULL,
  "valor_incorporacion" float8 NOT NULL,
  "gda_bien_padre_id" char(36) COLLATE "pg_catalog"."default",
  "gda_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_unidad_ubicacion_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_responsable_id" char(36) COLLATE "pg_catalog"."default",
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "detalle" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_bien_tipoid" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "estado" varchar(100) COLLATE "pg_catalog"."default",
  "gda_instrumento_bienid" char(36) COLLATE "pg_catalog"."default",
  "estado_conservacion" varchar(30) COLLATE "pg_catalog"."default",
  "existencia_inventario" varchar(20) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_bien" OWNER TO "postgres";
CREATE TABLE "gda_bien_asignaciones" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "estado" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "tipo_asignacion" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_bien_asignaciones" OWNER TO "postgres";
CREATE TABLE "gda_bien_datos_contables" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "anno" int4 NOT NULL,
  "gda_bienid" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "valor_revaluo" float8,
  "valor_depreciacion" float8 NOT NULL,
  "valor_neto_fiscal" float8,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "gda_coeficiente_reevaluo_id" char(36) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "gda_bien_datos_contables" OWNER TO "postgres";
CREATE TABLE "gda_bien_fijo_datos" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_bien_fijo_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_atributo_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "valor" varchar(5000) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_bien_fijo_datos" OWNER TO "postgres";
CREATE TABLE "gda_bien_tipo" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "fecha_modificacion" timestamp(6),
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_bien_tipo" OWNER TO "postgres";
CREATE TABLE "gda_bien_traza" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_evento" timestamp(6) NOT NULL,
  "detalle" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "gda_bien_traza" OWNER TO "postgres";
CREATE TABLE "gda_cargo" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_cargo" OWNER TO "postgres";
CREATE TABLE "gda_categoria_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(60) COLLATE "pg_catalog"."default",
  "gda_categoria_bien_id" char(36) COLLATE "pg_catalog"."default",
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "codigo" varchar(100) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "gda_categoria_bien" OWNER TO "postgres";
CREATE TABLE "gda_coeficiente_reevaluo" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "anno" int4 NOT NULL,
  "valor" float8 NOT NULL,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default",
  "fecha_modificacion" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_coeficiente_reevaluo" OWNER TO "postgres";
CREATE TABLE "gda_entidad" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "nombre" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "codigo" varchar(10) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_entidad" OWNER TO "postgres";
CREATE TABLE "gda_instrumento_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha" timestamp(6) NOT NULL,
  "gda_tipo_instrumentoid" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_instrumento_bien" OWNER TO "postgres";
CREATE TABLE "gda_origen_movimiento" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(40) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_origen_movimiento" OWNER TO "postgres";
CREATE TABLE "gda_roles" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "nombre" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_roles" OWNER TO "postgres";
CREATE TABLE "gda_solicitud" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "detalle" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_creador_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_unidad_remitente_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_unidad_receptora_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_origen_movimiento_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_tipo_solicitud_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_paso_aprobacion_actual" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "estado_aprobacion_solicitud" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "fecha_modificacion" timestamp(6),
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_solicitud" OWNER TO "postgres";
CREATE TABLE "gda_solicitud_aprobaciones_realizadas" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_paso_ruta_participantes_id" char(36) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "gda_solicitud_aprobaciones_realizadas" OWNER TO "postgres";
CREATE TABLE "gda_solicitud_bien_por_categoria" (
  "gda_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_biengda_origen_movimientoid" char(36) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "gda_solicitud_bien_por_categoria" OWNER TO "postgres";
CREATE TABLE "gda_solicitud_paso_ruta_participantes" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "gda_solicitud_ruta_aprobacion_id" char(36) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "gda_solicitud_paso_ruta_participantes" OWNER TO "postgres";
CREATE TABLE "gda_solicitud_ruta_aprobacion" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_tipo_solicitud_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "orden" int4 NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(255) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_solicitud_ruta_aprobacion" OWNER TO "postgres";
CREATE TABLE "gda_solictud_bien_espefico" (
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_bien_fijo_id" char(36) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "gda_solictud_bien_espefico" OWNER TO "postgres";
CREATE TABLE "gda_tipo_instrumento" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6),
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_tipo_instrumento" OWNER TO "postgres";
CREATE TABLE "gda_tipo_solicitud" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "tipo_solicitud" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_modificacion" timestamp(6) NOT NULL
)
;
ALTER TABLE "gda_tipo_solicitud" OWNER TO "postgres";
CREATE TABLE "gda_tipo_unidad" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_tipo_unidad" OWNER TO "postgres";
CREATE TABLE "gda_unidad" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_entidad_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_unidad_padre_id" char(36) COLLATE "pg_catalog"."default",
  "gda_tipo_unidad_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(255) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6),
  "nombre" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "codigo" varchar(10) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_unidad" OWNER TO "postgres";
CREATE TABLE "gda_usuario" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "nombreusuario" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "nombre" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "apellidos" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "cedula" varchar(18) COLLATE "pg_catalog"."default" NOT NULL,
  "telefono" varchar(30) COLLATE "pg_catalog"."default",
  "celular" varchar(30) COLLATE "pg_catalog"."default",
  "credencial" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
  "enabled" bool NOT NULL,
  "gda_unidad_id" char(36) COLLATE "pg_catalog"."default",
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_usuario" OWNER TO "postgres";
CREATE TABLE "gda_usuario_puesto" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_cargo_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_unidad_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_usuario_puesto" OWNER TO "postgres";
CREATE TABLE "gda_usuario_roles" (
  "gda_usuario_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_roles_id" char(36) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "gda_usuario_roles" OWNER TO "postgres";
CREATE TABLE "gda_valores_seleccion_atributo_categoria_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "nombre" int4 NOT NULL,
  "gda_atributo_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_valores_seleccion_atributo_categoria_bien" OWNER TO "postgres";
BEGIN;
LOCK TABLE "public"."gda_atributo_categoria_bien" IN SHARE MODE;
DELETE FROM "public"."gda_atributo_categoria_bien";
INSERT INTO "public"."gda_atributo_categoria_bien" ("id","gda_categoria_bien_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion","nombre","requerido","unico","tipo_dato") VALUES ('a2568975-b545-453b-aa4f-1ec895f39836', 'a1768969-b584-453b-aa4f-1ec895f39855', 'administrador', '2020-09-04 12:00:08', 'administrador', '2020-09-04 12:00:15', 'Velocidad', 't', 'f', 'CADENA'),('a2568975-b545-453b-aa4f-1ec895f39837', 'a1768969-b584-453b-aa4f-1ec895f39855', 'administrador', '2020-09-04 12:00:58', 'administrador', '2020-09-04 12:01:01', 'Tipo de CPU', 't', 'f', 'CADENA'),('a2568975-b545-453b-aa4f-1ec895f39838', 'a1768969-b584-453b-aa4f-1ec895f39855', 'administrador', '2020-09-04 12:01:30', 'administrador', '2020-09-04 12:01:33', 'Tipo de Memoria', 't', 'f', 'CADENA');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien" IN SHARE MODE;
DELETE FROM "public"."gda_bien";
INSERT INTO "public"."gda_bien" ("id","rotulado","fecha_incorporacion","valor_incorporacion","gda_bien_padre_id","gda_categoria_bien_id","gda_unidad_ubicacion_id","gda_usuario_responsable_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion","detalle","gda_bien_tipoid","estado","gda_instrumento_bienid","estado_conservacion","existencia_inventario") VALUES ('a2568975-b584-453b-aa4f-1ec895f39835', '0000-0001-002', '2020-09-03 17:24:45', 100000, NULL, 'a1768969-b584-453b-aa4f-1ec895f39855', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', NULL, 'administrador', '2020-09-03 17:26:04', 'administrador', '2020-09-03 17:26:14', 'Computadora Notebook Dell Inspiron 1300 INTEL PETIUM M735, PROCESADOR 1,70gh2, MEMORIA DE 1GB, TARJETA DE RED, VIDEO Y SONIDO INTEGRADO, DISCO DURO DE 60GB, LECTOR GRABADOR COMBO MANUAL TARJETA DE INSTRUCCION', 'a2568969-b584-453b-aa4f-1ec895f39835', 'PENDIENTE_ETIQUETADO', NULL, 'MUY_BUENO', 'NO_REGISTRADO'),('a2568975-b584-453b-aa4f-1ec895f39836', '0000-0001-003', '2020-09-04 11:55:47', 200000, NULL, 'a1768969-b584-453b-aa4f-1ec895f39855', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', NULL, 'administrador', '2020-09-04 11:56:09', 'administrador', '2020-09-04 11:56:17', 'computador dell', 'a2568969-b584-453b-aa4f-1ec895f39835', 'PENDIENTE_APROBACION', NULL, 'BUENO', 'FALTANTE');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_asignaciones" IN SHARE MODE;
DELETE FROM "public"."gda_bien_asignaciones";
INSERT INTO "public"."gda_bien_asignaciones" ("id","estado","tipo_asignacion","gda_usuario_id","gda_bien_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('z2068969-b584-453b-aa4f-1ec895f39836', 'ACTIVO', 'ASIGNADO', 'a1768969-b584-453b-aa4f-1ec895f39836', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:49:23', NULL, NULL),('z2068969-b584-453b-aa4f-1ec895f39837', 'ACTIVO', 'APROBADOR', 'a1768969-b584-453b-aa4f-1ec895f39837', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:50:11', NULL, NULL),('z2068969-b584-453b-aa4f-1ec895f39838', 'ACTIVO', 'CONTROL', 'a1768969-b584-453b-aa4f-1ec895f39838', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:51:07', NULL, NULL),('z2068969-b584-453b-aa4f-1ec895f39839', 'ACTIVO', 'REGISTRO', 'a1768969-b584-453b-aa4f-1ec895f39839', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:51:46', NULL, NULL),('z2068969-b584-453b-aa4f-1ec895f39835', 'ACTIVO', 'RESPONSABLE', 'a1768969-b584-453b-aa4f-1ec895f39835', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:47:58', NULL, NULL);
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_datos_contables" IN SHARE MODE;
DELETE FROM "public"."gda_bien_datos_contables";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_fijo_datos" IN SHARE MODE;
DELETE FROM "public"."gda_bien_fijo_datos";
INSERT INTO "public"."gda_bien_fijo_datos" ("id","gda_bien_fijo_id","gda_atributo_categoria_bien_id","valor","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('a2666666-b666-453b-aa4f-1ec895f39666', 'a2568975-b584-453b-aa4f-1ec895f39836', 'a2568975-b545-453b-aa4f-1ec895f39836', '2.3', 'administrador', '2020-09-04 12:05:23', 'administrador', '2020-09-04 12:05:29'),('a2666666-b666-453b-aa4f-1ec895f39667', 'a2568975-b584-453b-aa4f-1ec895f39836', 'a2568975-b545-453b-aa4f-1ec895f39837', 'PENTIUM', 'administrador', '2020-09-04 12:08:13', 'administrador', '2020-09-04 12:08:23'),('a2666666-b666-453b-aa4f-1ec895f39668', 'a2568975-b584-453b-aa4f-1ec895f39836', 'a2568975-b545-453b-aa4f-1ec895f39838', 'DDR3', 'administrador', '2020-09-04 12:08:58', 'administrador', '2020-09-04 12:09:04');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_tipo" IN SHARE MODE;
DELETE FROM "public"."gda_bien_tipo";
INSERT INTO "public"."gda_bien_tipo" ("id","descripcion","creado_por","fecha_creacion","fecha_modificacion","modificado_por") VALUES ('a2568969-b584-453b-aa4f-1ec895f39835', 'DE CONSUMO', 'adminstrador', '2020-09-03 17:23:31', '2020-09-03 17:23:36', 'administrador');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_traza" IN SHARE MODE;
DELETE FROM "public"."gda_bien_traza";
INSERT INTO "public"."gda_bien_traza" ("id","gda_bien_id","fecha_evento","detalle") VALUES ('z4068975-b584-453b-aa4f-1ec895f39835', 'a2568975-b584-453b-aa4f-1ec895f39835', '2020-09-09 11:25:20', 'El bien bien con número de rotulado 0000-0001-002 fue creado'),('z4068975-b584-453b-aa4f-1ec895f39836', 'a2568975-b584-453b-aa4f-1ec895f39835', '2020-09-18 10:42:32', 'El bien ha sido etiquetado');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_cargo" IN SHARE MODE;
DELETE FROM "public"."gda_cargo";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_categoria_bien" IN SHARE MODE;
DELETE FROM "public"."gda_categoria_bien";
INSERT INTO "public"."gda_categoria_bien" ("id","descripcion","gda_categoria_bien_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion","codigo") VALUES ('a1768969-b584-453b-aa4f-1ec895f39887', 'EQUIPOS DE COMPUTACION', NULL, 'administrador', '2020-09-03 13:45:38', NULL, NULL, '26105'),('a1768969-b584-453b-aa4f-1ec895f39899', 'MAQUINAS NUMERERICAS ODIGITALES PARA INFORMATICA ', 'a1768969-b584-453b-aa4f-1ec895f39887', 'administrador', '2020-09-03 13:48:56', NULL, NULL, '001'),('a1768969-b584-453b-aa4f-1ec895f39855', 'UNIDAD CENTRAL DE PROCESAMIENTO (CPU)', 'a1768969-b584-453b-aa4f-1ec895f39899', 'administrador', '2020-09-03 13:49:42', NULL, NULL, '002');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_coeficiente_reevaluo" IN SHARE MODE;
DELETE FROM "public"."gda_coeficiente_reevaluo";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_entidad" IN SHARE MODE;
DELETE FROM "public"."gda_entidad";
INSERT INTO "public"."gda_entidad" ("id","nombre","creado_por","fecha_creacion","modificado_por","fecha_modificacion","codigo") VALUES ('6fb36d51-5f66-4d3d-8fdd-abb290517a51', 'Senave', 'admin2', '2020-08-31 14:40:21.344', 'admin2', '2020-08-31 14:40:21.344', '18');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_instrumento_bien" IN SHARE MODE;
DELETE FROM "public"."gda_instrumento_bien";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_origen_movimiento" IN SHARE MODE;
DELETE FROM "public"."gda_origen_movimiento";
INSERT INTO "public"."gda_origen_movimiento" ("id","descripcion","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('7fdfbc99-a168-4f31-b794-a7d7ac02b4rt', 'ALTA', 'admin2', '2020-09-21 14:15:49', 'admin2', '2020-09-21 14:15:59'),('7fdfbc99-a168-4f31-b794-a7d7ac02b5cc', 'BAJA', 'admin2', '2020-09-21 14:16:41', 'admin2', '2020-09-21 14:16:47'),('7fdfbc99-a168-4f31-b794-a7d7ac02b8ll', 'DONACIONES', 'admin2', '2020-09-21 14:17:43', 'admin2', '2020-09-21 14:17:50'),('7fdfbc99-a168-4f31-b794-a7d7ac02b6ff', 'COMPRA', 'admin2', '2020-09-21 14:17:11', 'admin2', '2020-09-21 14:17:16'),('7fdfbc99-a168-4f31-b794-a7d7ac02b3re', 'TRASPASOS', 'admin2', '2020-09-21 14:18:29', 'admin2', '2020-09-21 14:18:36'),('7fdfbc99-a168-4f31-b794-a7d7ac02b5cv', 'REPARACION MAYOR', 'admin2', '2020-09-21 14:20:16', 'admin2', '2020-09-21 14:20:23');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_roles" IN SHARE MODE;
DELETE FROM "public"."gda_roles";
INSERT INTO "public"."gda_roles" ("id","nombre","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('a1768969-b584-453b-aa4f-1ec895f39822', 'ADMINISTRADOR', 'administrador', '2020-08-28 12:55:00', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39823', 'JEFE DE DEPARTAMENTO', 'administrador', '2020-09-02 13:05:40', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39824', 'BIEN_RESPONSABLE', 'administrador', '2020-09-28 12:44:40', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39825', 'BIEN_ASIGNADO', 'administrador', '2020-09-28 12:45:11', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39826', 'BIEN_APROBADOR', 'administrador', '2020-09-28 12:45:35', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39827', 'BIEN_CONTROL', 'administrador', '2020-09-28 12:45:57', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39828', 'BIEN_REGISTRO', 'administrador', '2020-09-28 12:47:46', NULL, NULL);
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud_aprobaciones_realizadas" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_aprobaciones_realizadas";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud_bien_por_categoria" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_bien_por_categoria";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud_paso_ruta_participantes" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_paso_ruta_participantes";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud_ruta_aprobacion" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_ruta_aprobacion";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solictud_bien_espefico" IN SHARE MODE;
DELETE FROM "public"."gda_solictud_bien_espefico";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_tipo_instrumento" IN SHARE MODE;
DELETE FROM "public"."gda_tipo_instrumento";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_tipo_solicitud" IN SHARE MODE;
DELETE FROM "public"."gda_tipo_solicitud";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_tipo_unidad" IN SHARE MODE;
DELETE FROM "public"."gda_tipo_unidad";
INSERT INTO "public"."gda_tipo_unidad" ("id","descripcion","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('f4ac2776-43fb-4fc9-b79e-9970c49d5175', 'DIRECCION', 'admin2', '2020-08-31 15:57:02.922', 'admin2', '2020-08-31 15:57:02.922');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_unidad" IN SHARE MODE;
DELETE FROM "public"."gda_unidad";
INSERT INTO "public"."gda_unidad" ("id","gda_entidad_id","gda_unidad_padre_id","gda_tipo_unidad_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion","nombre","codigo") VALUES ('7fdfbc99-a168-4f31-b794-a7d7ac02bd00', '6fb36d51-5f66-4d3d-8fdd-abb290517a51', NULL, 'f4ac2776-43fb-4fc9-b79e-9970c49d5175', 'admin2', '2020-09-01 16:47:41.038', 'admin2', '2020-09-01 16:47:41.038', 'PRESIDENCIA', '01'),('7fdfbc99-a168-4f31-b794-a7d7ac02bd02', '6fb36d51-5f66-4d3d-8fdd-abb290517a51', NULL, 'f4ac2776-43fb-4fc9-b79e-9970c49d5175', 'admin2', '2020-09-18 12:05:04', 'admin2', '2020-09-18 12:05:09', 'SECRETARIA DE PLANIFICACION', '03'),('7fdfbc99-a168-4f31-b794-a7d7ac02bd01', '6fb36d51-5f66-4d3d-8fdd-abb290517a51', NULL, 'f4ac2776-43fb-4fc9-b79e-9970c49d5175', 'admin2', '2020-09-18 12:21:35', 'admin2', '2020-09-18 12:21:44', 'SECRETARIA DE RELACIONES EXTERNAS', '02'),('7fdfbc99-a168-4f31-b794-a7d7ac02bd03', '6fb36d51-5f66-4d3d-8fdd-abb290517a51', NULL, 'f4ac2776-43fb-4fc9-b79e-9970c49d5175', 'admin2', '2020-09-18 12:05:04', 'admin2', '2020-09-18 12:05:09', 'DIRECCION GENERAL DE ADMINISTRACION Y FINANZAS', '04'),('7fdfbc99-a168-4f31-b794-a7d7ac02bd04', '6fb36d51-5f66-4d3d-8fdd-abb290517a51', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', 'f4ac2776-43fb-4fc9-b79e-9970c49d5175', 'admin2', '2020-09-18 15:53:16', 'admin2', '2020-09-18 15:53:21', 'DESPACHO', '01');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_usuario" IN SHARE MODE;
DELETE FROM "public"."gda_usuario";
INSERT INTO "public"."gda_usuario" ("id","email","nombreusuario","nombre","apellidos","cedula","telefono","celular","credencial","enabled","gda_unidad_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('a1768969-b584-453b-aa4f-1ec895f39835', 'admin2@gda.com.py', 'admin2', 'Alejandro', 'Lafourcade', '99999999', '2199887765', '0995678903', '$2a$10$NlInPgu96Yo8dG2dC2FDBeRCX5WfY.1txMKwrwGeB3vkAjOSUUtxa', 't', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', 'anonymousUser', '2020-08-28 15:26:08.996', 'anonymousUser', '2020-08-28 15:26:08.996'),('a1768969-b584-453b-aa4f-1ec895f39834', 'admin@email.com', 'administrador', 'admin', 'admin', '00000000000', '00000000000', '000000000', '$2a$10$UJXLfBj7q8ZuO/Mi82v6xOTRjDJWLnPTiIBMqg0pH5ANm.Kmdzetm', 't', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', 'administrador', '2020-08-28 13:47:59', 'administrador', '2020-09-09 12:05:08'),('a1768969-b584-453b-aa4f-1ec895f39836', 'dalvarez@gda.com.py', 'dalvarez', 'Diego', 'Alvarez', '888888888', '23423424', '342423434', '$2a$10$UJXLfBj7q8ZuO/Mi82v6xOTRjDJWLnPTiIBMqg0pH5ANm.Kmdzetm', 't', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', 'administrador', '2020-09-28 12:53:45', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39837', 'mauricio@gda.com.py', 'msollinde', 'Mauricio', 'Solalinde', '888888888', '345435435', '345435435', '$2a$10$NlInPgu96Yo8dG2dC2FDBeRCX5WfY.1txMKwrwGeB3vkAjOSUUtxa', 't', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', 'administrador', '2020-09-28 12:58:11', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39838', 'tito@gda.com.py', 'tito', 'Tito', 'Ocampo', '8888888', '45345345', '345345345', '$2a$10$NlInPgu96Yo8dG2dC2FDBeRCX5WfY.1txMKwrwGeB3vkAjOSUUtxa', 't', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', 'administrador', '2020-09-28 13:00:38', NULL, NULL),('a1768969-b584-453b-aa4f-1ec895f39839', 'rgarcia@gda.com.py', 'rgarcia', 'Roberto', 'Garcia', '8777777', '234555', '553qqq3', '$2a$10$NlInPgu96Yo8dG2dC2FDBeRCX5WfY.1txMKwrwGeB3vkAjOSUUtxa', 't', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', 'administrador', '2020-09-30 13:45:18', NULL, NULL);
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_usuario_puesto" IN SHARE MODE;
DELETE FROM "public"."gda_usuario_puesto";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_usuario_roles" IN SHARE MODE;
DELETE FROM "public"."gda_usuario_roles";
INSERT INTO "public"."gda_usuario_roles" ("gda_usuario_id","gda_roles_id") VALUES ('a1768969-b584-453b-aa4f-1ec895f39834', 'a1768969-b584-453b-aa4f-1ec895f39822'),('a1768969-b584-453b-aa4f-1ec895f39835', 'a1768969-b584-453b-aa4f-1ec895f39822'),('a1768969-b584-453b-aa4f-1ec895f39835', 'a1768969-b584-453b-aa4f-1ec895f39824'),('a1768969-b584-453b-aa4f-1ec895f39836', 'a1768969-b584-453b-aa4f-1ec895f39825'),('a1768969-b584-453b-aa4f-1ec895f39837', 'a1768969-b584-453b-aa4f-1ec895f39826'),('a1768969-b584-453b-aa4f-1ec895f39838', 'a1768969-b584-453b-aa4f-1ec895f39827'),('a1768969-b584-453b-aa4f-1ec895f39839', 'a1768969-b584-453b-aa4f-1ec895f39828');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_valores_seleccion_atributo_categoria_bien" IN SHARE MODE;
DELETE FROM "public"."gda_valores_seleccion_atributo_categoria_bien";
COMMIT;
ALTER TABLE "gda_atributo_categoria_bien" ADD CONSTRAINT "gda_atributo_categoria_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien" ADD CONSTRAINT "gda_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien_asignaciones" ADD CONSTRAINT "gda_bien_asignaciones_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien_datos_contables" ADD CONSTRAINT "gda_bien_datos_contables_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien_fijo_datos" ADD CONSTRAINT "gda_bien_fijo_datos_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien_tipo" ADD CONSTRAINT "gda_bien_tipo_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien_traza" ADD CONSTRAINT "gda_bien_traza_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_cargo" ADD CONSTRAINT "gda_cargo_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_categoria_bien" ADD CONSTRAINT "gda_categoria_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_coeficiente_reevaluo" ADD CONSTRAINT "gda_coeficiente_reevaluo_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_entidad" ADD CONSTRAINT "gda_entidad_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_instrumento_bien" ADD CONSTRAINT "gda_instrumento_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_origen_movimiento" ADD CONSTRAINT "gda_origen_movimiento_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_roles" ADD CONSTRAINT "gda_roles_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud" ADD CONSTRAINT "gda_solicitud_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_aprobaciones_realizadas" ADD CONSTRAINT "gda_solicitud_aprobaciones_realizadas_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_bien_por_categoria" ADD CONSTRAINT "gda_solicitud_bien_por_categoria_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_paso_ruta_participantes" ADD CONSTRAINT "gda_solicitud_paso_ruta_participantes_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_ruta_aprobacion" ADD CONSTRAINT "gda_solicitud_ruta_aprobacion_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solictud_bien_espefico" ADD CONSTRAINT "gda_solictud_bien_espefico_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_tipo_instrumento" ADD CONSTRAINT "gda_tipo_instrumento_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_tipo_solicitud" ADD CONSTRAINT "gda_tipo_solicitud_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_tipo_unidad" ADD CONSTRAINT "gda_tipo_unidad_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_unidad" ADD CONSTRAINT "gda_unidad_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_usuario" ADD CONSTRAINT "gda_usuario_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_usuario_puesto" ADD CONSTRAINT "gda_usuario_puesto_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_usuario_roles" ADD CONSTRAINT "gda_usuario_roles_pkey" PRIMARY KEY ("gda_usuario_id", "gda_roles_id");
ALTER TABLE "gda_valores_seleccion_atributo_categoria_bien" ADD CONSTRAINT "gda_valores_seleccion_atributo_categoria_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_atributo_categoria_bien" ADD CONSTRAINT "fkgda_atribu982172" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "gda_bien_rotulado_key" UNIQUE ("rotulado");
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien278337" FOREIGN KEY ("gda_bien_padre_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien31092" FOREIGN KEY ("gda_instrumento_bienid") REFERENCES "public"."gda_instrumento_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien544473" FOREIGN KEY ("gda_bien_tipoid") REFERENCES "public"."gda_bien_tipo" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien63496" FOREIGN KEY ("gda_usuario_responsable_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien889727" FOREIGN KEY ("gda_unidad_ubicacion_id") REFERENCES "public"."gda_unidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien938593" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_asignaciones" ADD CONSTRAINT "fkgda_bien_a421555" FOREIGN KEY ("gda_usuario_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_asignaciones" ADD CONSTRAINT "fkgda_bien_a977186" FOREIGN KEY ("gda_bien_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_datos_contables" ADD CONSTRAINT "fkgda_bien_d161907" FOREIGN KEY ("gda_bienid") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_datos_contables" ADD CONSTRAINT "fkgda_bien_d365693" FOREIGN KEY ("gda_coeficiente_reevaluo_id") REFERENCES "public"."gda_coeficiente_reevaluo" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_fijo_datos" ADD CONSTRAINT "fkgda_bien_f596906" FOREIGN KEY ("gda_bien_fijo_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_fijo_datos" ADD CONSTRAINT "fkgda_bien_f89114" FOREIGN KEY ("gda_atributo_categoria_bien_id") REFERENCES "public"."gda_atributo_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_traza" ADD CONSTRAINT "fkgda_bien_t456425" FOREIGN KEY ("gda_bien_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_categoria_bien" ADD CONSTRAINT "fkgda_catego118926" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_coeficiente_reevaluo" ADD CONSTRAINT "gda_coeficiente_reevaluo_anno_key" UNIQUE ("anno");
ALTER TABLE "gda_entidad" ADD CONSTRAINT "gda_entidad_nombre_key" UNIQUE ("nombre");
ALTER TABLE "gda_instrumento_bien" ADD CONSTRAINT "fkgda_instru220130" FOREIGN KEY ("gda_tipo_instrumentoid") REFERENCES "public"."gda_tipo_instrumento" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_roles" ADD CONSTRAINT "gda_roles_nombre_key" UNIQUE ("nombre");
ALTER TABLE "gda_solicitud" ADD CONSTRAINT "fkgda_solici138428" FOREIGN KEY ("gda_usuario_creador_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud" ADD CONSTRAINT "fkgda_solici21500" FOREIGN KEY ("gda_unidad_receptora_id") REFERENCES "public"."gda_unidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud" ADD CONSTRAINT "fkgda_solici596011" FOREIGN KEY ("gda_solicitud_paso_aprobacion_actual") REFERENCES "public"."gda_solicitud_ruta_aprobacion" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud" ADD CONSTRAINT "fkgda_solici80421" FOREIGN KEY ("gda_unidad_remitente_id") REFERENCES "public"."gda_unidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud" ADD CONSTRAINT "fkgda_solici976823" FOREIGN KEY ("gda_tipo_solicitud_id") REFERENCES "public"."gda_tipo_solicitud" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud" ADD CONSTRAINT "fkgda_solici977183" FOREIGN KEY ("gda_origen_movimiento_id") REFERENCES "public"."gda_origen_movimiento" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_aprobaciones_realizadas" ADD CONSTRAINT "fkgda_solici203317" FOREIGN KEY ("gda_solicitud_bien_id") REFERENCES "public"."gda_solicitud" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_aprobaciones_realizadas" ADD CONSTRAINT "fkgda_solici412614" FOREIGN KEY ("gda_solicitud_paso_ruta_participantes_id") REFERENCES "public"."gda_solicitud_paso_ruta_participantes" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_bien_por_categoria" ADD CONSTRAINT "fkgda_solici286666" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_bien_por_categoria" ADD CONSTRAINT "fkgda_solici72975" FOREIGN KEY ("gda_solicitud_bien_id") REFERENCES "public"."gda_solicitud" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_paso_ruta_participantes" ADD CONSTRAINT "fkgda_solici670931" FOREIGN KEY ("gda_usuario_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_paso_ruta_participantes" ADD CONSTRAINT "fkgda_solici973961" FOREIGN KEY ("gda_solicitud_ruta_aprobacion_id") REFERENCES "public"."gda_solicitud_ruta_aprobacion" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_ruta_aprobacion" ADD CONSTRAINT "fkgda_solici486620" FOREIGN KEY ("gda_tipo_solicitud_id") REFERENCES "public"."gda_tipo_solicitud" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solictud_bien_espefico" ADD CONSTRAINT "fkgda_solict519152" FOREIGN KEY ("gda_solicitud_id") REFERENCES "public"."gda_solicitud" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solictud_bien_espefico" ADD CONSTRAINT "fkgda_solict652421" FOREIGN KEY ("gda_bien_fijo_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_unidad" ADD CONSTRAINT "fkgda_unidad210973" FOREIGN KEY ("gda_entidad_id") REFERENCES "public"."gda_entidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_unidad" ADD CONSTRAINT "fkgda_unidad55188" FOREIGN KEY ("gda_unidad_padre_id") REFERENCES "public"."gda_unidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_unidad" ADD CONSTRAINT "fkgda_unidad80770" FOREIGN KEY ("gda_tipo_unidad_id") REFERENCES "public"."gda_tipo_unidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_usuario" ADD CONSTRAINT "gda_usuario_email_key" UNIQUE ("email");
ALTER TABLE "gda_usuario" ADD CONSTRAINT "gda_usuario_nombreusuario_key" UNIQUE ("nombreusuario");
ALTER TABLE "gda_usuario" ADD CONSTRAINT "gda_usuario_celular_key" UNIQUE ("celular");
ALTER TABLE "gda_usuario" ADD CONSTRAINT "fkgda_usuari848407" FOREIGN KEY ("gda_unidad_id") REFERENCES "public"."gda_unidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_usuario_puesto" ADD CONSTRAINT "fkgda_usuari359124" FOREIGN KEY ("gda_unidad_id") REFERENCES "public"."gda_unidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_usuario_puesto" ADD CONSTRAINT "fkgda_usuari469157" FOREIGN KEY ("gda_usuario_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_usuario_puesto" ADD CONSTRAINT "fkgda_usuari551444" FOREIGN KEY ("gda_cargo_id") REFERENCES "public"."gda_cargo" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_usuario_roles" ADD CONSTRAINT "fkgda_usuari72488" FOREIGN KEY ("gda_roles_id") REFERENCES "public"."gda_roles" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_usuario_roles" ADD CONSTRAINT "fkgda_usuari78745" FOREIGN KEY ("gda_usuario_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_valores_seleccion_atributo_categoria_bien" ADD CONSTRAINT "fkgda_valore638643" FOREIGN KEY ("gda_atributo_categoria_bien_id") REFERENCES "public"."gda_atributo_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
