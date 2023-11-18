-- CREAR TABLAS DE BASE DE DATOS GRUPO 3.

BEGIN;

CREATE EXTENSION postgis;

-- Creación de las tablas

CREATE TABLE IF NOT EXISTS public.user_address (
  	id_address_u SERIAL PRIMARY KEY,
  	address TEXT COLLATE pg_catalog."default",
  	latitude FLOAT,
  	longitude FLOAT,
	geom geometry(Point, 4326));

CREATE TABLE IF NOT EXISTS public.emergency_address (
  	id_address_e SERIAL PRIMARY KEY,  
  	address TEXT COLLATE pg_catalog."default",
  	longitude FLOAT,
  	latitude FLOAT,
	geom geometry(Point, 4326));

CREATE TABLE IF NOT EXISTS public.role(
    id_role SERIAL PRIMARY KEY,
    role_name TEXT COLLATE pg_catalog."default");

CREATE TABLE IF NOT EXISTS public.ranking(
    id_ranking SERIAL PRIMARY KEY,
    ranking_position INTEGER,
    id_user INTEGER,
    id_task INTEGER);

CREATE TABLE IF NOT EXISTS public.institution(
    id_institution SERIAL PRIMARY KEY,
    institution_name TEXT COLLATE pg_catalog."default",
    institution_description TEXT COLLATE pg_catalog."default");

CREATE TABLE IF NOT EXISTS public.profile(
    id_profile SERIAL PRIMARY KEY,
    photo varchar(200),
	rut TEXT COLLATE pg_catalog."default",
    first_name TEXT COLLATE pg_catalog."default",
    second_name TEXT COLLATE pg_catalog."default",
    first_lastname TEXT COLLATE pg_catalog."default",
    second_lastname TEXT COLLATE pg_catalog."default",
    description TEXT COLLATE pg_catalog."default",
    gender TEXT COLLATE pg_catalog."default",
    birthday DATE);

CREATE TABLE IF NOT EXISTS public.state(
    id_state SERIAL PRIMARY KEY,
    state_name TEXT COLLATE pg_catalog."default",
    state_description TEXT COLLATE pg_catalog."default");

CREATE TABLE IF NOT EXISTS public.task(
    id_task SERIAL PRIMARY KEY,
    task_name TEXT COLLATE pg_catalog."default",
    task_description TEXT COLLATE pg_catalog."default",
    volunteers_required INTEGER,
    id_state INTEGER);

CREATE TABLE IF NOT EXISTS public.emergency(
    id_emergency SERIAL PRIMARY KEY,
    emergency_name TEXT COLLATE pg_catalog."default",
    statement_date DATE,
	emergency_type INTEGER,
    id_state INTEGER,
	id_address_e INTEGER);

CREATE TABLE IF NOT EXISTS public.emergency_task(
    id_emergency_task SERIAL PRIMARY KEY,
    id_emergency INTEGER,
    id_task INTEGER);

CREATE TABLE IF NOT EXISTS public.emergency_institution(
    id_emergency_institution SERIAL PRIMARY KEY,
    id_emergency INTEGER,
    id_institution INTEGER);


CREATE TABLE IF NOT EXISTS public.task_request(
    id_task_request SERIAL PRIMARY KEY,
    id_task INTEGER,
    id_request INTEGER);

CREATE TABLE IF NOT EXISTS public.request(
    id_request SERIAL PRIMARY KEY,
    request_name TEXT COLLATE pg_catalog."default",
    request_description TEXT COLLATE pg_catalog."default");

CREATE TABLE IF NOT EXISTS public.ability(
    id_ability SERIAL PRIMARY KEY,
    ability_name TEXT COLLATE pg_catalog."default",
    ability_description TEXT COLLATE pg_catalog."default");

CREATE TABLE IF NOT EXISTS public.emergency_ability(
    id_emergency_ability SERIAL PRIMARY KEY,
    id_emergency INTEGER,
    id_ability INTEGER);

CREATE TABLE IF NOT EXISTS public.user(
    id_user SERIAL PRIMARY KEY,
    username TEXT COLLATE pg_catalog."default",
    password TEXT COLLATE pg_catalog."default",
    id_profile INTEGER,
    id_role INTEGER,
    id_institution INTEGER,
	id_address_u INTEGER);

CREATE TABLE IF NOT EXISTS public.user_ability(
    id_user_ability SERIAL PRIMARY KEY,
    id_user INTEGER,
    id_ability INTEGER);

CREATE TABLE IF NOT EXISTS public.user_request(
    id_user_request SERIAL PRIMARY KEY,
    id_user INTEGER,
    id_request INTEGER);
	
-- Creación de las relaciones

ALTER TABLE IF EXISTS public.task
    ADD CONSTRAINT "idStateFK" FOREIGN KEY (id_state)
    REFERENCES public.state (id_state) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.emergency
    ADD CONSTRAINT "idStateFK" FOREIGN KEY (id_state)
    REFERENCES public.state (id_state) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
	
ALTER TABLE IF EXISTS public.emergency
    ADD CONSTRAINT "idAddressEFK" FOREIGN KEY (id_address_e)
    REFERENCES public.emergency_address (id_address_e) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.emergency_task
    ADD CONSTRAINT "idEmergencyFK" FOREIGN KEY (id_emergency)
    REFERENCES public.emergency (id_emergency) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.emergency_task
    ADD CONSTRAINT "idTaskFK" FOREIGN KEY (id_task)
    REFERENCES public.task (id_task) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.emergency_institution
    ADD CONSTRAINT "idEmergencyFK" FOREIGN KEY (id_emergency)
    REFERENCES public.emergency (id_emergency) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.emergency_institution
    ADD CONSTRAINT "idInstitutionFK" FOREIGN KEY (id_institution)
    REFERENCES public.institution (id_institution) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.task_request
    ADD CONSTRAINT "idTaskFK" FOREIGN KEY (id_task)
    REFERENCES public.task (id_task) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.task_request
    ADD CONSTRAINT "idRequestFK" FOREIGN KEY (id_request)
    REFERENCES public.request (id_request) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.emergency_ability
    ADD CONSTRAINT "idEmergencyFK" FOREIGN KEY (id_emergency)
    REFERENCES public.emergency (id_emergency) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.emergency_ability
    ADD CONSTRAINT "idAbilityFK" FOREIGN KEY (id_ability)
    REFERENCES public.ability (id_ability) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.user
    ADD CONSTRAINT "idProfileFK" FOREIGN KEY (id_profile)
    REFERENCES public.profile (id_profile) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.user
    ADD CONSTRAINT "idRoleFK" FOREIGN KEY (id_role)
    REFERENCES public.role (id_role) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.user
    ADD CONSTRAINT "idInstitutionFK" FOREIGN KEY (id_institution)
    REFERENCES public.institution (id_institution) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
	
ALTER TABLE IF EXISTS public.user
    ADD CONSTRAINT "idAddressVFK" FOREIGN KEY (id_address_u)
    REFERENCES public.user_address (id_address_u) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.user_ability
    ADD CONSTRAINT "idUserFK" FOREIGN KEY (id_user)
    REFERENCES public.user (id_user) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.user_ability
    ADD CONSTRAINT "idAbilityFK" FOREIGN KEY (id_ability)
    REFERENCES public.ability (id_ability) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.user_request
    ADD CONSTRAINT "idUserFK" FOREIGN KEY (id_user)
    REFERENCES public.user (id_user) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.user_request
    ADD CONSTRAINT "idRequestFK" FOREIGN KEY (id_request)
    REFERENCES public.request (id_request) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.ranking
    ADD CONSTRAINT "idUserFK" FOREIGN KEY (id_user)
    REFERENCES public.user (id_user) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.ranking
    ADD CONSTRAINT "idTaskFK" FOREIGN KEY (id_task)
    REFERENCES public.task (id_task) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
	
-- Creación de roles
INSERT INTO public.role (role_name) VALUES ('ADMIN');
INSERT INTO public.role (role_name) VALUES ('COORDINADOR');
INSERT INTO public.role (role_name) VALUES ('USER');

COMMIT;
