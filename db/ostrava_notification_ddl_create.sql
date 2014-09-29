-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.7.0-alpha
-- PostgreSQL version: 9.3
-- Project Site: pgmodeler.com.br
-- Model Author: Ludek Cermak

SET check_function_bodies = false;
-- ddl-end --

-- object: public."T_DEVICE" | type: TABLE --
DROP TABLE public."T_DEVICE";
CREATE TABLE public."T_DEVICE"(
	"DEVICE_ID" serial NOT NULL,
	"DEVICE_TOKEN" text NOT NULL,
	"OS_TYPE" varchar(16) NOT NULL,
	"CREATE_TIME" timestamp,
	CONSTRAINT "PK_DEVICE" PRIMARY KEY ("DEVICE_ID")
);