
-- Volcando estructura para tabla public.department
CREATE TABLE IF NOT EXISTS "department" (
	"id_department" INTEGER NOT NULL,
	"department_name" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	PRIMARY KEY ("id_department")
);

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla public.role
CREATE TABLE IF NOT EXISTS "role" (
	"id_role" SMALLINT NOT NULL DEFAULT '0',
	"role" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	PRIMARY KEY ("id_role")
);

-- Volcando estructura para tabla public.users
CREATE TABLE IF NOT EXISTS "users" (
	"id_user" SMALLINT NOT NULL DEFAULT '0',
	"name" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	"last_name" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	"mail" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
    "username" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
    "password" VARCHAR(60) NULL DEFAULT 'NULL::character varying',
    "createDate" DATE NULL DEFAULT now(),
	"enabled" BOOLEAN NULL DEFAULT 'false',
	"tokenExpired" BOOLEAN NULL DEFAULT 'false',

    /*"id_role" SMALLINT NOT NULL DEFAULT '0',*/
	PRIMARY KEY ("id_user")
	/*FOREIGN KEY (id_role)
        REFERENCES public.role (id_role)*/
);

-- La exportación de datos fue deseleccionada.

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla public.timesheet
CREATE TABLE IF NOT EXISTS "timesheet" (
	"id_time" INTEGER NOT NULL,
	"timesheet_date" DATE NULL DEFAULT NULL,
	"hMonday" INTEGER NULL DEFAULT NULL,
	"hTuesday" INTEGER NULL DEFAULT NULL,
	"hWednesday" INTEGER NULL DEFAULT NULL,
	"hThursday" INTEGER NULL DEFAULT NULL,
	"hFriday" INTEGER NULL DEFAULT NULL,
	"hSaturday" INTEGER NULL DEFAULT NULL,
	"hSunday" INTEGER NULL DEFAULT NULL,
	"pay" SMALLINT NULL DEFAULT '0',
	"id_user" SMALLINT NULL DEFAULT NULL,
	"approved" BOOLEAN NULL DEFAULT 'false',
	"payed" BOOLEAN NULL DEFAULT 'false',
	"id_department" INTEGER NULL DEFAULT NULL,
	PRIMARY KEY ("id_time"),
	FOREIGN KEY (id_department)
        REFERENCES public.department (id_department),
    FOREIGN KEY (id_user)
        REFERENCES public.users (id_user)
);

-- La exportación de datos fue deseleccionada.

