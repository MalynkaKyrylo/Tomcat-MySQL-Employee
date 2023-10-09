
CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS employees
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  position VARCHAR(128) NOT NULL,
  phone VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO employees (name, position, phone) VALUES (?, ?, ?)


SELECT * FROM employees


SELECT * FROM employees WHERE id == ?


UPDATE employees SET name = ?, position = ?, phone = ? WHERE id = ?


DELETE FROM employees WHERE id = ?

