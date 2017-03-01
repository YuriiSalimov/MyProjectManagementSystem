DROP DATABASE IF EXISTS projectManagementDB;
CREATE DATABASE IF NOT EXISTS projectManagementDB
  DEFAULT CHARACTER SET utf8;
USE projectManagementDB;

-- companies
CREATE TABLE IF NOT EXISTS companies (
  id   INT         NOT NULL AUTO_INCREMENT,
  name VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB;

-- customers
CREATE TABLE IF NOT EXISTS customers (
  id   INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB;

-- projects
CREATE TABLE IF NOT EXISTS projects (
  id          INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(30) NOT NULL,
  company_id  INT         NOT NULL,
  customer_id INT         NOT NULL,
  FOREIGN KEY (company_id) REFERENCES companies (id),
  FOREIGN KEY (customer_id) REFERENCES customers (id)
)
  ENGINE = InnoDB;

-- developers
CREATE TABLE IF NOT EXISTS developers (
  id         INT         NOT NULL AUTO_INCREMENT,
  name       VARCHAR(30) NOT NULL,
  company_id INT         NOT NULL,
  project_id INT         NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (company_id) REFERENCES companies (id),
  FOREIGN KEY (project_id) REFERENCES projects (id)
)
  ENGINE = InnoDB;

-- skills
CREATE TABLE IF NOT EXISTS skills (
  id    INT         NOT NULL AUTO_INCREMENT,
  name VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB;

-- developers_skills
CREATE TABLE IF NOT EXISTS developers_skills (
  developer_id INT NOT NULL,
  skill_id     INT NOT NULL,
  PRIMARY KEY (developer_id, skill_id),
  FOREIGN KEY (developer_id) REFERENCES developers (id),
  FOREIGN KEY (skill_id) REFERENCES skills (id)
)
  ENGINE = InnoDB;

USE projectManagementDB;

-- insert data into table customers
INSERT INTO customers VALUES (1, 'Regeneron Pharmaceuticals Inc');
INSERT INTO customers VALUES (2, 'Abbott Laboratories');
INSERT INTO customers VALUES (3, 'Biogen');
INSERT INTO customers VALUES (4, 'Eli Lilly & Co');
INSERT INTO customers VALUES (5, 'Bayer');
INSERT INTO customers VALUES (6, 'Roche');

-- insert data into table companies
INSERT INTO companies VALUES (1, 'LuxSoft');
INSERT INTO companies VALUES (2, 'InfoPulse');
INSERT INTO companies VALUES (3, 'EPAM');
INSERT INTO companies VALUES (4, 'GlobalLogic');
INSERT INTO companies VALUES (5, 'Ciklum');
INSERT INTO companies VALUES (6, 'PlayTech');

-- insert data into table skills
INSERT INTO skills VALUES (1, 'Java');
INSERT INTO skills VALUES (2, 'SQL');
INSERT INTO skills VALUES (3, 'Python');
INSERT INTO skills VALUES (4, 'C++');
INSERT INTO skills VALUES (5, 'C#');
INSERT INTO skills VALUES (6, 'JavaScript');
INSERT INTO skills VALUES (7, 'Tomcat');
INSERT INTO skills VALUES (8, 'Jira');
INSERT INTO skills VALUES (9, 'Trello');
INSERT INTO skills VALUES (10, 'Scrum');

-- insert data into table projects
INSERT INTO projects VALUES (1, 'Search people app', 1, 1);
INSERT INTO projects VALUES (2, 'Android game app', 2, 2);
INSERT INTO projects VALUES (3, 'Stealth gadget', 3, 3);
INSERT INTO projects VALUES (4, 'Portable teleport station', 4, 4);
INSERT INTO projects VALUES (5, 'Collector of cosmic energy', 5, 5);
INSERT INTO projects VALUES (6, 'Search for life extension', 6, 6);

-- insert data into table developers
INSERT INTO developers VALUES (1, 'Alexey', 1, 1);
INSERT INTO developers VALUES (2, 'Andrey', 2, 2);
INSERT INTO developers VALUES (3, 'Anton', 3, 3);
INSERT INTO developers VALUES (4, 'Vadym', 4, 4);
INSERT INTO developers VALUES (5, 'Katya', 5, 5);
INSERT INTO developers VALUES (6, 'Slava', 6, 6);
INSERT INTO developers VALUES (7, 'Pavel', 1, 1);
INSERT INTO developers VALUES (8, 'Yuriy', 2, 2);
INSERT INTO developers VALUES (9, 'Misha', 3, 3);
INSERT INTO developers VALUES (10, 'Lena', 4, 4);

-- insert data into table developers_skills
INSERT INTO developers_skills VALUES (1, 1);
INSERT INTO developers_skills VALUES (1, 2);
INSERT INTO developers_skills VALUES (2, 1);
INSERT INTO developers_skills VALUES (2, 4);
INSERT INTO developers_skills VALUES (2, 7);
INSERT INTO developers_skills VALUES (3, 1);
INSERT INTO developers_skills VALUES (3, 3);
INSERT INTO developers_skills VALUES (3, 10);
INSERT INTO developers_skills VALUES (4, 2);
INSERT INTO developers_skills VALUES (4, 4);
INSERT INTO developers_skills VALUES (5, 8);
INSERT INTO developers_skills VALUES (5, 6);
INSERT INTO developers_skills VALUES (6, 3);
INSERT INTO developers_skills VALUES (6, 9);
INSERT INTO developers_skills VALUES (7, 1);
INSERT INTO developers_skills VALUES (7, 3);
INSERT INTO developers_skills VALUES (7, 7);
INSERT INTO developers_skills VALUES (8, 1);
INSERT INTO developers_skills VALUES (8, 2);
INSERT INTO developers_skills VALUES (8, 3);
INSERT INTO developers_skills VALUES (8, 4);
INSERT INTO developers_skills VALUES (9, 2);
INSERT INTO developers_skills VALUES (9, 10);
INSERT INTO developers_skills VALUES (10, 3);
INSERT INTO developers_skills VALUES (10, 7);
INSERT INTO developers_skills VALUES (10, 1);

USE projectManagementDB;

-- add field salary to developers tab
ALTER TABLE developers
  ADD salary INT NOT NULL
  AFTER name;

-- update data into field salary of developers tab
UPDATE developers
SET salary = 3780
WHERE id = 1;
UPDATE developers
SET salary = 4100
WHERE id = 2;
UPDATE developers
SET salary = 5050
WHERE id = 3;
UPDATE developers
SET salary = 3700
WHERE id = 4;
UPDATE developers
SET salary = 4400
WHERE id = 5;
UPDATE developers
SET salary = 4600
WHERE id = 6;
UPDATE developers
SET salary = 6230
WHERE id = 7;
UPDATE developers
SET salary = 4820
WHERE id = 8;
UPDATE developers
SET salary = 4060
WHERE id = 9;
UPDATE developers
SET salary = 4000
WHERE id = 10;

USE projectManagementDB;

-- add field cost to projects tab
ALTER TABLE projects
  ADD cost INT NOT NULL
  AFTER name;

/**
- update all fields cost in tab projects
- if appeared some errors about safe mode use:
- SET SQL_SAFE_UPDATES = 0;
- after working fine
 */
UPDATE projects p
SET p.cost = (SELECT sum(d.salary)
              FROM developers d
              WHERE d.project_id = p.id);
