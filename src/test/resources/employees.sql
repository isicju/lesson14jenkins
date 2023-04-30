/**
* You can copy, modify, distribute and perform the work, even for commercial purposes,
* all without asking permission.
*
* @Author: Andrei N. CIOBANU
*/
DROP SCHEMA

    IF EXISTS hr cascade;
CREATE SCHEMA hr ;

USE hr;

/* ***************************************************************
***************************CREATING TABLES************************
**************************************************************** */


CREATE TABLE employees (
                           employee_id INT (11) UNSIGNED NOT NULL,
                           first_name VARCHAR(20),
                           last_name VARCHAR(25) NOT NULL,
                           email VARCHAR(25) NOT NULL,
                           phone_number VARCHAR(20),
                           hire_date DATE NOT NULL,
                           job_id VARCHAR(10) NOT NULL,
                           salary DECIMAL(8, 2) NOT NULL,
                           commission_pct DECIMAL(2, 2),
                           manager_id INT (11) UNSIGNED,
                           department_id INT (11) UNSIGNED,
                           PRIMARY KEY (employee_id)
);


INSERT INTO employees
VALUES (
           101,
           'Neena',
           'Kochhar',
           'NKOCHHAR',
           '515.123.4568',
           '1997-06-23',
           'AD_VP',
           17000,
           NULL,
           100,
           90
       );

INSERT INTO employees
VALUES (
           10211111,
           'Lex',
           'De Haan',
           'LDEHAAN',
           '515.123.4569',
           '1997-06-23',
           'AD_VP',
           17000,
           NULL,
           100,
           90
       );

INSERT INTO employees
VALUES (
           103,
           'Alexander',
           'Hunold',
           'AHUNOLD',
           '590.423.4567',
           '1997-06-23',
           'IT_PROG',
           9000,
           NULL,
           102,
           60
       );

COMMIT;
