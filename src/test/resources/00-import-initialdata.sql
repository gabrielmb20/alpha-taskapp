-- DEPARTMENTS
INSERT INTO public.department (id_department, department_name) VALUES (1, 'Department 1');
INSERT INTO public.department (id_department, department_name) VALUES (2, 'Department 2');
INSERT INTO public.department (id_department, department_name) VALUES (3, 'Department 3');
-- PRIVILEGES
INSERT INTO public.privilege (id_privilege, name) VALUES (1, 'READ_PRIVILEGE');
INSERT INTO public.privilege (id_privilege, name) VALUES (2, 'WRITE_PRIVILEGE');
-- ROLES
INSERT INTO public.role (id_role, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.role (id_role, name) VALUES (2, 'ROLE_USER');
-- ROLES PRIVILEGES
INSERT INTO public.role_privilege (id_role, id_privilege) VALUES (1, 2);
INSERT INTO public.role_privilege (id_role, id_privilege) VALUES (2, 1);
-- USERS
INSERT INTO public."users" ("id_user", "created", "email", "enabled", "firstname", "lastname", "username", "password", "expired") VALUES (1, '2020-08-30 18:23:52.000000', 'admin@localhost.com', true, 'Administrator', 'General', 'admin', '$2y$12$JykAilNl0SaEkIO8fm.7ge10BrrRKJ.3aS7Rus3EQbKvVAFKN1Feu', false);
INSERT INTO public."users" ("id_user", "created", "email", "enabled", "firstname", "lastname", "username", "password", "expired") VALUES (2, '2020-08-30 18:23:52.000000', 'user01@localhost.com', true, 'User', '01', 'user01', '$2y$12$JykAilNl0SaEkIO8fm.7ge10BrrRKJ.3aS7Rus3EQbKvVAFKN1Feu', false);
INSERT INTO public."users" ("id_user", "created", "email", "enabled", "firstname", "lastname", "username", "password", "expired") VALUES (3, '2020-08-30 18:23:52.000000', 'user02@localhost.com', true, 'User', '02', 'user02', '$2y$12$JykAilNl0SaEkIO8fm.7ge10BrrRKJ.3aS7Rus3EQbKvVAFKN1Feu', false);
-- USERS ROLES
INSERT INTO public.user_role (id_user, id_role) VALUES (1, 1);
INSERT INTO public.user_role (id_user, id_role) VALUES (2, 2);
INSERT INTO public.user_role (id_user, id_role) VALUES (3, 2);
-- TIMESHEETS
INSERT INTO public.timesheet(
    id_time, approved, "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", id_department, id_user, pay, payed, timesheet_date)
VALUES (1, false, 2, 3, 4, 5, 6, 7, 8, 1, 1, 0, false, '2020-08-30 18:23:52.000000');

INSERT INTO public.timesheet(
    id_time, approved, "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", id_department, id_user, pay, payed, timesheet_date)
VALUES (2, false, 2, 3, 4, 5, 6, 7, 8, 2, 2, 0, false, '2020-08-30 18:23:52.000000');

INSERT INTO public.timesheet(
    id_time, approved, "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", id_department, id_user, pay, payed, timesheet_date)
VALUES (3, false, 2, 3, 4, 5, 6, 7, 8, 1, 2, 0, false, '2020-08-30 18:23:52.000000');