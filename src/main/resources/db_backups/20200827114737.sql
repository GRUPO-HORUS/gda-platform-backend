/*
PostgreSQL Backup
Database: gda_dev/public
Backup Time: 2020-08-27 11:47:41
*/

DROP TABLE IF EXISTS "public"."gda_atributo_categoria_bien";
DROP TABLE IF EXISTS "public"."gda_bien";
DROP TABLE IF EXISTS "public"."gda_bien_fijo_datos";
DROP TABLE IF EXISTS "public"."gda_bien_traza";
DROP TABLE IF EXISTS "public"."gda_cargo";
DROP TABLE IF EXISTS "public"."gda_catalogo_categoria_bien";
DROP TABLE IF EXISTS "public"."gda_categoria_bien";
DROP TABLE IF EXISTS "public"."gda_entidad";
DROP TABLE IF EXISTS "public"."gda_origen_movimiento";
DROP TABLE IF EXISTS "public"."gda_roles";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_bien";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_bien_por_categoria";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_paso_ruta";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_paso_ruta_participantes";
DROP TABLE IF EXISTS "public"."gda_solicitud_mov_ruta_aprobacion";
DROP TABLE IF EXISTS "public"."gda_solictud_mov_bien_espefico";
DROP TABLE IF EXISTS "public"."gda_tipo_unidad";
DROP TABLE IF EXISTS "public"."gda_unidad";
DROP TABLE IF EXISTS "public"."gda_usuario";
DROP TABLE IF EXISTS "public"."gda_usuario_puesto";
DROP TABLE IF EXISTS "public"."gda_usuario_roles";
DROP TABLE IF EXISTS "public"."gda_valores_catalogo_categoria_bien";
CREATE TABLE "gda_atributo_categoria_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_catalogos_categoria_id" char(36) COLLATE "pg_catalog"."default",
  "gda_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "requerido" bool NOT NULL,
  "unico" bool NOT NULL,
  "tipo_dato" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_atributo_categoria_bien" OWNER TO "postgres";
CREATE TABLE "gda_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "rotulado" varchar(15) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_incorporacion" timestamp(6) NOT NULL,
  "valor_incorporacion" float8 NOT NULL,
  "gda_bien_padre_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_unidad_ubicacion_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_usuario_responsable_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_bien" OWNER TO "postgres";
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
CREATE TABLE "gda_catalogo_categoria_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_creacion" timestamp(6) NOT NULL,
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_catalogo_categoria_bien" OWNER TO "postgres";
CREATE TABLE "gda_categoria_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "descripcion" varchar(60) COLLATE "pg_catalog"."default",
  "gda_categoria_bien_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_categoria_bien" OWNER TO "postgres";
CREATE TABLE "gda_entidad" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "nombre" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_entidad" OWNER TO "postgres";
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
  "gda_unidad_padre_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_tipo_unidad_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(255) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
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
  "gda_unidad_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
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
CREATE TABLE "gda_valores_catalogo_categoria_bien" (
  "id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "gda_catalogos_categoria_id" char(36) COLLATE "pg_catalog"."default" NOT NULL,
  "creado_por" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "fecha_creacion" timestamp(6) NOT NULL,
  "modificado_por" varchar(20) COLLATE "pg_catalog"."default",
  "fecha_modificacion" timestamp(6)
)
;
ALTER TABLE "gda_valores_catalogo_categoria_bien" OWNER TO "postgres";
BEGIN;
LOCK TABLE "public"."gda_atributo_categoria_bien" IN SHARE MODE;
DELETE FROM "public"."gda_atributo_categoria_bien";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien" IN SHARE MODE;
DELETE FROM "public"."gda_bien";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_fijo_datos" IN SHARE MODE;
DELETE FROM "public"."gda_bien_fijo_datos";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_bien_traza" IN SHARE MODE;
DELETE FROM "public"."gda_bien_traza";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_cargo" IN SHARE MODE;
DELETE FROM "public"."gda_cargo";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_catalogo_categoria_bien" IN SHARE MODE;
DELETE FROM "public"."gda_catalogo_categoria_bien";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_categoria_bien" IN SHARE MODE;
DELETE FROM "public"."gda_categoria_bien";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_entidad" IN SHARE MODE;
DELETE FROM "public"."gda_entidad";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_origen_movimiento" IN SHARE MODE;
DELETE FROM "public"."gda_origen_movimiento";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_roles" IN SHARE MODE;
DELETE FROM "public"."gda_roles";
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
LOCK TABLE "public"."gda_tipo_unidad" IN SHARE MODE;
DELETE FROM "public"."gda_tipo_unidad";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_unidad" IN SHARE MODE;
DELETE FROM "public"."gda_unidad";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_usuario" IN SHARE MODE;
DELETE FROM "public"."gda_usuario";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_usuario_puesto" IN SHARE MODE;
DELETE FROM "public"."gda_usuario_puesto";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_usuario_roles" IN SHARE MODE;
DELETE FROM "public"."gda_usuario_roles";
COMMIT;
BEGIN;
LOCK TABLE "public"."gda_valores_catalogo_categoria_bien" IN SHARE MODE;
DELETE FROM "public"."gda_valores_catalogo_categoria_bien";
COMMIT;
ALTER TABLE "gda_atributo_categoria_bien" ADD CONSTRAINT "gda_atributo_categoria_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien" ADD CONSTRAINT "gda_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien_fijo_datos" ADD CONSTRAINT "gda_bien_fijo_datos_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_bien_traza" ADD CONSTRAINT "gda_bien_traza_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_cargo" ADD CONSTRAINT "gda_cargo_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_catalogo_categoria_bien" ADD CONSTRAINT "gda_catalogo_categoria_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_categoria_bien" ADD CONSTRAINT "gda_categoria_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_entidad" ADD CONSTRAINT "gda_entidad_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_origen_movimiento" ADD CONSTRAINT "gda_origen_movimiento_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_roles" ADD CONSTRAINT "gda_roles_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_mov_bien" ADD CONSTRAINT "gda_solicitud_mov_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_mov_bien_por_categoria" ADD CONSTRAINT "gda_solicitud_mov_bien_por_categoria_pkey" PRIMARY KEY ("gda_solicitud_mov_bien_id");
ALTER TABLE "gda_solicitud_mov_paso_ruta" ADD CONSTRAINT "gda_solicitud_mov_paso_ruta_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_mov_paso_ruta_participantes" ADD CONSTRAINT "gda_solicitud_mov_paso_ruta_participantes_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solicitud_mov_ruta_aprobacion" ADD CONSTRAINT "gda_solicitud_mov_ruta_aprobacion_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_solictud_mov_bien_espefico" ADD CONSTRAINT "gda_solictud_mov_bien_espefico_pkey" PRIMARY KEY ("gda_solicitud_mov_bien_id");
ALTER TABLE "gda_tipo_unidad" ADD CONSTRAINT "gda_tipo_unidad_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_unidad" ADD CONSTRAINT "gda_unidad_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_usuario" ADD CONSTRAINT "gda_usuario_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_usuario_puesto" ADD CONSTRAINT "gda_usuario_puesto_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_usuario_roles" ADD CONSTRAINT "gda_usuario_roles_pkey" PRIMARY KEY ("gda_usuario_id", "gda_roles_id");
ALTER TABLE "gda_valores_catalogo_categoria_bien" ADD CONSTRAINT "gda_valores_catalogo_categoria_bien_pkey" PRIMARY KEY ("id");
ALTER TABLE "gda_atributo_categoria_bien" ADD CONSTRAINT "fkgda_atribu482" FOREIGN KEY ("gda_catalogos_categoria_id") REFERENCES "public"."gda_catalogo_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_atributo_categoria_bien" ADD CONSTRAINT "fkgda_atribu982172" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "gda_bien_rotulado_key" UNIQUE ("rotulado");
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien278337" FOREIGN KEY ("gda_bien_padre_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien63496" FOREIGN KEY ("gda_usuario_responsable_id") REFERENCES "public"."gda_usuario" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien889727" FOREIGN KEY ("gda_unidad_ubicacion_id") REFERENCES "public"."gda_unidad" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien" ADD CONSTRAINT "fkgda_bien938593" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_fijo_datos" ADD CONSTRAINT "fkgda_bien_f596906" FOREIGN KEY ("gda_bien_fijo_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_fijo_datos" ADD CONSTRAINT "fkgda_bien_f89114" FOREIGN KEY ("gda_atributo_categoria_bien_id") REFERENCES "public"."gda_atributo_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_bien_traza" ADD CONSTRAINT "fkgda_bien_t456425" FOREIGN KEY ("gda_bien_id") REFERENCES "public"."gda_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_categoria_bien" ADD CONSTRAINT "fkgda_catego118926" FOREIGN KEY ("gda_categoria_bien_id") REFERENCES "public"."gda_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "gda_entidad" ADD CONSTRAINT "gda_entidad_nombre_key" UNIQUE ("nombre");
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
ALTER TABLE "gda_valores_catalogo_categoria_bien" ADD CONSTRAINT "fkgda_valore786863" FOREIGN KEY ("gda_catalogos_categoria_id") REFERENCES "public"."gda_catalogo_categoria_bien" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
