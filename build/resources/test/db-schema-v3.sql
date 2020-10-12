-- DEPARTMENT
CREATE TABLE IF NOT EXISTS "department" (
	"id_department" INTEGER NOT NULL,
	"department_name" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	PRIMARY KEY ("id_department")
);

-- ROLE
CREATE TABLE IF NOT EXISTS "role" (
	"id_role" SERIAL PRIMARY KEY,
	"name" VARCHAR(30) NULL DEFAULT 'NULL::character varying'
);

-- PRIVILEGE
CREATE TABLE IF NOT EXISTS "privilege" (
   "id_privilege" SERIAL PRIMARY KEY,
   "name" VARCHAR(30) NULL DEFAULT 'NULL::character varying'
);

-- ROLE_PRIVILEGE
CREATE TABLE IF NOT EXISTS "role_privilege" (
    "id_role_privilege" SERIAL PRIMARY KEY,
    "id_role" SMALLINT NOT NULL DEFAULT '0',
    "id_privilege" SMALLINT NOT NULL DEFAULT '0'
);

-- USER_ROLE
CREATE TABLE IF NOT EXISTS "user_role" (
    "id_user_role" SERIAL PRIMARY KEY,
    "id_user" SMALLINT NOT NULL DEFAULT '0',
    "id_role" SMALLINT NOT NULL DEFAULT '0'
);

-- USERS
CREATE TABLE IF NOT EXISTS "users" (
	"id_user" SMALLINT NOT NULL DEFAULT '0',
	"firstname" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	"lastname" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
	"email" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
    "username" VARCHAR(30) NULL DEFAULT 'NULL::character varying',
    "password" VARCHAR(60) NULL DEFAULT 'NULL::character varying',
    "created" DATE NULL DEFAULT now(),
	"enabled" BOOLEAN NULL DEFAULT 'false',
	"expired" BOOLEAN NULL DEFAULT 'false',
	PRIMARY KEY ("id_user")
);


-- TIMESHEET
CREATE TABLE IF NOT EXISTS "timesheet" (
	"id_time" INTEGER NOT NULL,
	"timesheet_date" DATE NULL DEFAULT NULL,
	"monday" INTEGER NULL DEFAULT NULL,
	"tuesday" INTEGER NULL DEFAULT NULL,
	"wednesday" INTEGER NULL DEFAULT NULL,
	"thursday" INTEGER NULL DEFAULT NULL,
	"friday" INTEGER NULL DEFAULT NULL,
	"saturday" INTEGER NULL DEFAULT NULL,
	"sunday" INTEGER NULL DEFAULT NULL,
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

