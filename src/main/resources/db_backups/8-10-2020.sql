/*
PostgreSQL Backup
Database: gda_dev/public
Backup Time: 2020-10-08 13:19:28
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
DROP TABLE IF EXISTS "public"."gda_coeficiente_depreciacion";
DROP TABLE IF EXISTS "public"."gda_coeficiente_reevaluo";
DROP TABLE IF EXISTS "public"."gda_entidad";
DROP TABLE IF EXISTS "public"."gda_instrumento_bien";
DROP TABLE IF EXISTS "public"."gda_origen_movimiento";
DROP TABLE IF EXISTS "public"."gda_roles";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_bien";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_bien_por_categoria";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_paso_ruta";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_paso_ruta_participantes";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_ruta_aprobacion";
DROP TABLE IF EXISTS "public"."gda_solictud_mov_bien_espefico";
DROP TABLE IF EXISTS "public"."gda_tipo_instrumento";
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
  "gda_coeficiente_depreciacion_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
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
CREATE TABLE "gda_coeficiente_depreciacion" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "anno" int4 NOT NULL,
  "valor" float8 NOT NULL,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default",
  "fecha_modificacion" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_coeficiente_depreciacion" OWNER TO "postgres";
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
CREATE TABLE "gda_solicitud_mov_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_creador_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_destinatario_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "tipo_solicitud" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_mov_paso_ruta_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_origen_movimiento_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "fecha_modificacion" timestamp(6),
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_solicitud_mov_bien" OWNER TO "postgres";
CREATE TABLE "gda_solicitud_mov_bien_por_categoria" (
  "gda_solicitud_mov_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_mov_biengda_origen_movimientoid" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_solicitud_mov_bien_por_categoria" OWNER TO "postgres";
CREATE TABLE "gda_solicitud_mov_paso_ruta" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_mov_ruta_aprobacionid" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "orden" int4 NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_solicitud_mov_paso_ruta" OWNER TO "postgres";
CREATE TABLE "gda_solicitud_mov_paso_ruta_participantes" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_mov_paso_ruta_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_solicitud_mov_paso_ruta_participantes" OWNER TO "postgres";
CREATE TABLE "gda_solicitud_mov_ruta_aprobacion" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_mov_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_mov_biengda_origen_movimientoid" char(36) COLLATE "pg_catalog"."default",
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(255) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_solicitud_mov_ruta_aprobacion" OWNER TO "postgres";
CREATE TABLE "gda_solictud_mov_bien_espefico" (
  "gda_solicitud_mov_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_bien_fijoid" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_solicitud_mov_biengda_origen_movimientoid" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_solictud_mov_bien_espefico" OWNER TO "postgres";
CREATE TABLE "gda_tipo_instrumento" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6),
  "modificado_por" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "gda_tipo_instrumento" OWNER TO "postgres";
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
INSERT INTO "public"."gda_atributo_categoria_bien" ("id","gda_categoria_bien_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion","nombre","requerido","unico","tipo_dato") VALUES ('a2568975-b545-453b-aa4f-1ec895f39836', 'a1768969-b584-453b-aa4f-1ec895f39855', 'administrador', '2020-09-04 12:00:08', 'administrador', '2020-09-04 12:00:15', 'Velocidad', 't', 'f', 'CADENA'),('a2568975-b545-453b-aa4f-1ec895f39837', 'a1768969-b584-453b-aa4f-1ec895f39855', 'administrador', '2020-09-04 12:00:58', 'administrador', '2020-09-04 12:01:01', 'Tipo de CPU', 't', 'f', 'CADENA'),('a2568975-b545-453b-aa4f-1ec895f39838', 'a1768969-b584-453b-aa4f-1ec895f39855', 'administrador', '2020-09-04 12:01:30', 'administrador', '2020-09-04 12:01:33', 'Tipo de Memoria', 't', 'f', 'CADENA'),('a2568975-b545-453b-aa4f-1ec895f39839', 'a1768969-b584-453b-aa4f-1ec895f39856', 'administrador', '2020-10-07 21:54:48', NULL, NULL, 'Capacidad', 't', 'f', 'CADENA');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien" IN SHARE MODE;
DELETE FROM "public"."gda_bien";
INSERT INTO "public"."gda_bien" ("id","rotulado","fecha_incorporacion","valor_incorporacion","gda_bien_padre_id","gda_categoria_bien_id","gda_unidad_ubicacion_id","gda_usuario_responsable_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion","detalle","gda_bien_tipoid","estado","gda_instrumento_bienid","estado_conservacion","existencia_inventario") VALUES ('a2568975-b584-453b-aa4f-1ec895f39835', '0000-0001-002', '2020-09-03 17:24:45', 100000, NULL, 'a1768969-b584-453b-aa4f-1ec895f39855', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', NULL, 'administrador', '2020-09-03 17:26:04', 'administrador', '2020-09-03 17:26:14', 'Computadora Notebook Dell Inspiron 1300 INTEL PETIUM M735, PROCESADOR 1,70gh2, MEMORIA DE 1GB, TARJETA DE RED, VIDEO Y SONIDO INTEGRADO, DISCO DURO DE 60GB, LECTOR GRABADOR COMBO MANUAL TARJETA DE INSTRUCCION', 'a2568969-b584-453b-aa4f-1ec895f39835', 'PENDIENTE_ETIQUETADO', NULL, 'MUY_BUENO', 'NO_REGISTRADO'),('a2568975-b584-453b-aa4f-1ec895f39836', '0000-0001-003', '2020-09-04 11:55:47', 200000, NULL, 'a1768969-b584-453b-aa4f-1ec895f39855', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', NULL, 'administrador', '2020-09-04 11:56:09', 'administrador', '2020-09-04 11:56:17', 'computador dell', 'a2568969-b584-453b-aa4f-1ec895f39835', 'PENDIENTE_APROBACION', NULL, 'BUENO', 'FALTANTE'),('2b75d762-525e-44b2-9cd2-987c0e94cbfc', '0000-0001-00003', '2020-10-08 13:14:06.993', 7800000, NULL, 'a1768969-b584-453b-aa4f-1ec895f39856', '7fdfbc99-a168-4f31-b794-a7d7ac02bd00', NULL, 'admin2', '2020-10-08 13:14:16.395402', 'admin2', '2020-10-08 13:14:16.395402', 'Ipad pro 2020', 'a2568969-b584-453b-aa4f-1ec895f39835', 'PENDIENTE_ETIQUETADO', NULL, 'BUENO', 'NO_REGISTRADO');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_asignaciones" IN SHARE MODE;
DELETE FROM "public"."gda_bien_asignaciones";
INSERT INTO "public"."gda_bien_asignaciones" ("id","estado","tipo_asignacion","gda_usuario_id","gda_bien_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('z2068969-b584-453b-aa4f-1ec895f39836', 'ACTIVO', 'ASIGNADO', 'a1768969-b584-453b-aa4f-1ec895f39836', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:49:23', NULL, NULL),('z2068969-b584-453b-aa4f-1ec895f39837', 'ACTIVO', 'APROBADOR', 'a1768969-b584-453b-aa4f-1ec895f39837', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:50:11', NULL, NULL),('z2068969-b584-453b-aa4f-1ec895f39838', 'ACTIVO', 'CONTROL', 'a1768969-b584-453b-aa4f-1ec895f39838', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:51:07', NULL, NULL),('z2068969-b584-453b-aa4f-1ec895f39839', 'ACTIVO', 'REGISTRO', 'a1768969-b584-453b-aa4f-1ec895f39839', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:51:46', NULL, NULL),('z2068969-b584-453b-aa4f-1ec895f39835', 'ACTIVO', 'RESPONSABLE', 'a1768969-b584-453b-aa4f-1ec895f39835', 'a2568975-b584-453b-aa4f-1ec895f39835', 'administrador', '2020-09-30 13:47:58', NULL, NULL),('82f8ea8b-d2e3-48e5-b1a9-c7de7ff5190a', 'ACTIVO', 'RESPONSABLE', 'a1768969-b584-453b-aa4f-1ec895f39835', '2b75d762-525e-44b2-9cd2-987c0e94cbfc', 'admin2', '2020-10-08 13:14:23.385672', 'admin2', '2020-10-08 13:14:23.385672'),('5cfb6cc9-6543-4cdb-95c1-886f861a2191', 'ACTIVO', 'ASIGNADO', 'a1768969-b584-453b-aa4f-1ec895f39836', '2b75d762-525e-44b2-9cd2-987c0e94cbfc', 'admin2', '2020-10-08 13:14:43.765906', 'admin2', '2020-10-08 13:14:43.765906'),('69ed76b0-e119-4261-bbed-8c07ae82c9e2', 'ACTIVO', 'APROBADOR', 'a1768969-b584-453b-aa4f-1ec895f39837', '2b75d762-525e-44b2-9cd2-987c0e94cbfc', 'admin2', '2020-10-08 13:14:52.465744', 'admin2', '2020-10-08 13:14:52.465744'),('48dbe418-3ab4-4db0-a547-9a9d99143308', 'ACTIVO', 'CONTROL', 'a1768969-b584-453b-aa4f-1ec895f39838', '2b75d762-525e-44b2-9cd2-987c0e94cbfc', 'admin2', '2020-10-08 13:15:03.283196', 'admin2', '2020-10-08 13:15:03.283196'),('1a0f4114-f61e-4e83-963c-0d9ca03c33fc', 'ACTIVO', 'REGISTRO', 'a1768969-b584-453b-aa4f-1ec895f39839', '2b75d762-525e-44b2-9cd2-987c0e94cbfc', 'admin2', '2020-10-08 13:15:09.615981', 'admin2', '2020-10-08 13:15:09.615981');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_datos_contables" IN SHARE MODE;
DELETE FROM "public"."gda_bien_datos_contables";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_fijo_datos" IN SHARE MODE;
DELETE FROM "public"."gda_bien_fijo_datos";
INSERT INTO "public"."gda_bien_fijo_datos" ("id","gda_bien_fijo_id","gda_atributo_categoria_bien_id","valor","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('a2666666-b666-453b-aa4f-1ec895f39666', 'a2568975-b584-453b-aa4f-1ec895f39836', 'a2568975-b545-453b-aa4f-1ec895f39836', '2.3', 'administrador', '2020-09-04 12:05:23', 'administrador', '2020-09-04 12:05:29'),('a2666666-b666-453b-aa4f-1ec895f39667', 'a2568975-b584-453b-aa4f-1ec895f39836', 'a2568975-b545-453b-aa4f-1ec895f39837', 'PENTIUM', 'administrador', '2020-09-04 12:08:13', 'administrador', '2020-09-04 12:08:23'),('a2666666-b666-453b-aa4f-1ec895f39668', 'a2568975-b584-453b-aa4f-1ec895f39836', 'a2568975-b545-453b-aa4f-1ec895f39838', 'DDR3', 'administrador', '2020-09-04 12:08:58', 'administrador', '2020-09-04 12:09:04'),('a8c7bd7a-d407-41da-ae17-1456b8c1d0cb', '2b75d762-525e-44b2-9cd2-987c0e94cbfc', 'a2568975-b545-453b-aa4f-1ec895f39839', '128 GB', 'admin2', '2020-10-08 13:14:20.453583', 'admin2', '2020-10-08 13:14:20.453583');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_tipo" IN SHARE MODE;
DELETE FROM "public"."gda_bien_tipo";
INSERT INTO "public"."gda_bien_tipo" ("id","descripcion","creado_por","fecha_creacion","fecha_modificacion","modificado_por") VALUES ('a2568969-b584-453b-aa4f-1ec895f39835', 'DE CONSUMO', 'adminstrador', '2020-09-03 17:23:31', '2020-09-03 17:23:36', 'administrador');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_traza" IN SHARE MODE;
DELETE FROM "public"."gda_bien_traza";
INSERT INTO "public"."gda_bien_traza" ("id","gda_bien_id","fecha_evento","detalle") VALUES ('z4068975-b584-453b-aa4f-1ec895f39835', 'a2568975-b584-453b-aa4f-1ec895f39835', '2020-09-09 11:25:20', 'El bien bien con número de rotulado 0000-0001-002 fue creado'),('z4068975-b584-453b-aa4f-1ec895f39836', 'a2568975-b584-453b-aa4f-1ec895f39835', '2020-09-18 10:42:32', 'El bien ha sido etiquetado'),('68d3618a-b0d9-4741-bcca-1b4b8aa5e09f', '2b75d762-525e-44b2-9cd2-987c0e94cbfc', '2020-10-08 13:15:12.555', 'El bien con rótulo 0000-0001-00003 fue creado');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_cargo" IN SHARE MODE;
DELETE FROM "public"."gda_cargo";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_categoria_bien" IN SHARE MODE;
DELETE FROM "public"."gda_categoria_bien";
INSERT INTO "public"."gda_categoria_bien" ("id","descripcion","gda_categoria_bien_id","creado_por","fecha_creacion","modificado_por","fecha_modificacion","codigo") VALUES ('a1768969-b584-453b-aa4f-1ec895f39887', 'EQUIPOS DE COMPUTACION', NULL, 'administrador', '2020-09-03 13:45:38', NULL, NULL, '26105'),('a1768969-b584-453b-aa4f-1ec895f39899', 'MAQUINAS NUMERERICAS ODIGITALES PARA INFORMATICA ', 'a1768969-b584-453b-aa4f-1ec895f39887', 'administrador', '2020-09-03 13:48:56', NULL, NULL, '001'),('a1768969-b584-453b-aa4f-1ec895f39855', 'UNIDAD CENTRAL DE PROCESAMIENTO (CPU)', 'a1768969-b584-453b-aa4f-1ec895f39899', 'administrador', '2020-09-03 13:49:42', NULL, NULL, '002'),('a1768969-b584-453b-aa4f-1ec895f39856', 'TABLET', 'a1768969-b584-453b-aa4f-1ec895f39899', 'administrador', '2020-10-07 17:02:58', NULL, NULL, '003');
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_coeficiente_depreciacion" IN SHARE MODE;
DELETE FROM "public"."gda_coeficiente_depreciacion";
INSERT INTO "public"."gda_coeficiente_depreciacion" ("id","anno","valor","creado_por","fecha_creacion","modificado_por","fecha_modificacion") VALUES ('e416bf71-bd7e-45e5-91e7-0e5131532942', 2020, 1, 'admin2', '2020-09-10 16:33:20.23', 'admin2', '2020-09-10 16:33:20.23-04');
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
LOCK TABLE "public"."gda_solicitud_mov_bien" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_mov_bien";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud_mov_bien_por_categoria" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_mov_bien_por_categoria";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud_mov_paso_ruta" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_mov_paso_ruta";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud_mov_paso_ruta_participantes" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_mov_paso_ruta_participantes";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solicitud_mov_ruta_aprobacion" IN SHARE MODE;
DELETE FROM "public"."gda_solicitud_mov_ruta_aprobacion";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_solictud_mov_bien_espefico" IN SHARE MODE;
DELETE FROM "public"."gda_solictud_mov_bien_espefico";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_tipo_instrumento" IN SHARE MODE;
DELETE FROM "public"."gda_tipo_instrumento";
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
ALTER TABLE "gda_coeficiente_depreciacion" ADD CONSTRAINT "gda_coeficiente_depreciacion_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_coeficiente_reevaluo" ADD CONSTRAINT "gda_coeficiente_reevaluo_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_entidad" ADD CONSTRAINT "gda_entidad_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_instrumento_bien" ADD CONSTRAINT "gda_instrumento_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_origen_movimiento" ADD CONSTRAINT "gda_origen_movimiento_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_roles" ADD CONSTRAINT "gda_roles_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_mov_bien" ADD CONSTRAINT "gda_solicitud_mov_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_mov_bien_por_categoria" ADD CONSTRAINT "gda_solicitud_mov_bien_por_categoria_pkey" PRIMARY KEY ("gda_solicitud_mov_bien_id");
ALTER TABLE "gda_solicitud_mov_paso_ruta" ADD CONSTRAINT "gda_solicitud_mov_paso_ruta_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_mov_paso_ruta_participantes" ADD CONSTRAINT "gda_solicitud_mov_paso_ruta_participantes_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_mov_ruta_aprobacion" ADD CONSTRAINT "gda_solicitud_mov_ruta_aprobacion_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solictud_mov_bien_espefico" ADD CONSTRAINT "gda_solictud_mov_bien_espefico_pkey" PRIMARY KEY ("gda_solicitud_mov_bien_id");
ALTER TABLE "gda_tipo_instrumento" ADD CONSTRAINT "gda_tipo_instrumento_pkey" PRIMARY KEY ("id");
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
ALTER TABLE "gda_bien_datos_contables" ADD CONSTRAINT "fkgda_bien_d347781" FOREIGN KEY ("gda_coeficiente_depreciacion_id") REFERENCES "public"."gda_coeficiente_depreciacion" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_datos_contables" ADD CONSTRAINT "fkgda_bien_d365693" FOREIGN KEY ("gda_coeficiente_reevaluo_id") REFERENCES "public"."gda_coeficiente_reevaluo" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_fijo_datos" ADD CONSTRAINT "fkgda_bien_f596906" FOREIGN KEY ("gda_bien_fijo_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_fijo_datos" ADD CONSTRAINT "fkgda_bien_f89114" FOREIGN KEY ("gda_atributo_categoria_bien_id") REFERENCES "public"."gda_atributo_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_traza" ADD CONSTRAINT "fkgda_bien_t456425" FOREIGN KEY ("gda_bien_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_categoria_bien" ADD CONSTRAINT "fkgda_catego118926" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_coeficiente_depreciacion" ADD CONSTRAINT "gda_coeficiente_depreciacion_anno_key" UNIQUE ("anno");
ALTER TABLE "gda_coeficiente_reevaluo" ADD CONSTRAINT "gda_coeficiente_reevaluo_anno_key" UNIQUE ("anno");
ALTER TABLE "gda_entidad" ADD CONSTRAINT "gda_entidad_nombre_key" UNIQUE ("nombre");
ALTER TABLE "gda_instrumento_bien" ADD CONSTRAINT "fkgda_instru220130" FOREIGN KEY ("gda_tipo_instrumentoid") REFERENCES "public"."gda_tipo_instrumento" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_roles" ADD CONSTRAINT "gda_roles_nombre_key" UNIQUE ("nombre");
ALTER TABLE "gda_solicitud_mov_bien" ADD CONSTRAINT "fkgda_solici154204" FOREIGN KEY ("gda_usuario_creador_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_bien" ADD CONSTRAINT "fkgda_solici231394" FOREIGN KEY ("gda_solicitud_mov_paso_ruta_id") REFERENCES "public"."gda_solicitud_mov_paso_ruta" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_bien" ADD CONSTRAINT "fkgda_solici700295" FOREIGN KEY ("gda_usuario_destinatario_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_bien" ADD CONSTRAINT "fkgda_solici992959" FOREIGN KEY ("gda_origen_movimiento_id") REFERENCES "public"."gda_origen_movimiento" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_bien_por_categoria" ADD CONSTRAINT "fkgda_solici225886" FOREIGN KEY ("gda_solicitud_mov_bien_id") REFERENCES "public"."gda_solicitud_mov_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_bien_por_categoria" ADD CONSTRAINT "fkgda_solici591532" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_paso_ruta" ADD CONSTRAINT "fkgda_solici145171" FOREIGN KEY ("gda_solicitud_mov_ruta_aprobacionid") REFERENCES "public"."gda_solicitud_mov_ruta_aprobacion" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_paso_ruta_participantes" ADD CONSTRAINT "fkgda_solici179529" FOREIGN KEY ("gda_solicitud_mov_paso_ruta_id") REFERENCES "public"."gda_solicitud_mov_paso_ruta" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_paso_ruta_participantes" ADD CONSTRAINT "fkgda_solici48387" FOREIGN KEY ("gda_usuario_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solicitud_mov_ruta_aprobacion" ADD CONSTRAINT "fkgda_solici82529" FOREIGN KEY ("gda_solicitud_mov_bien_id") REFERENCES "public"."gda_solicitud_mov_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solictud_mov_bien_espefico" ADD CONSTRAINT "fkgda_solict148244" FOREIGN KEY ("gda_bien_fijoid") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_solictud_mov_bien_espefico" ADD CONSTRAINT "fkgda_solict553227" FOREIGN KEY ("gda_solicitud_mov_bien_id") REFERENCES "public"."gda_solicitud_mov_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
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
