-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         PostgreSQL 12.4, compiled by Visual C++ build 1914, 64-bit
-- SO del servidor:              
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla public.department
CREATE TABLE IF NOT EXISTS "department" (
	"id" INTEGER NOT NULL,
	"deparment_name" character varying(200) NULL DEFAULT NULL,
	PRIMARY KEY ("id")
);

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla public.time_task
CREATE TABLE IF NOT EXISTS "time_task" (
	"ID" INTEGER NOT NULL,
	"Timesheet" DATE NULL DEFAULT NULL,
	"monday" INTEGER NULL DEFAULT NULL,
	"tuesday" INTEGER NULL DEFAULT NULL,
	"wednesday" INTEGER NULL DEFAULT NULL,
	"thursday" INTEGER NULL DEFAULT NULL,
	"friday" INTEGER NULL DEFAULT NULL,
	"saturday" INTEGER NULL DEFAULT NULL,
	"sunday" INTEGER NULL DEFAULT NULL,
	"pay" SMALLINT NULL DEFAULT '0',
	"user_id" INTEGER NULL DEFAULT NULL,
	PRIMARY KEY ("ID")
);

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla public.user
CREATE TABLE IF NOT EXISTS "user" (
	"ID" SMALLINT NOT NULL DEFAULT '0',
	"name" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	"last_name" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	"mail" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	"password" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	PRIMARY KEY ("ID")
);

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
