--/* ---------------------------------------------------- */
--/*  Generated by Enterprise Architect Version 15.2 		*/
--/*  Created On : 17-дек-2024 10:14:13 				*/
--/*  DBMS       : PostgreSQL 						*/
--/* ---------------------------------------------------- */
--
--/* Drop Sequences for Autonumber Columns */
--
--
--
--/* Drop Tables */
--
----DROP TABLE IF EXISTS t2t CASCADE;--
--
--/* Create Tables */
--
--CREATE TABLE t2t
--(
--	id serial NOT NULL,
--	message varchar(256) NOT NULL
--)
--;
--
--/* Create Primary Keys, Indexes, Uniques, Checks */
--
--ALTER TABLE t2t ADD CONSTRAINT "PK_t2t"
--	PRIMARY KEY (id)
--;
--
--/* Create Table Comments, Sequences for Autonumber Columns */
--
--
