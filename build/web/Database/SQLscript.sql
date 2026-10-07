CREATE DATABASE empresa;

CREATE TABLE empleados (
  id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    departamento VARCHAR(255)
);

INSERT INTO empleados(nombre, departamento)
VALUES ('Enrique', 'Financiero');

INSERT INTO empleados(nombre, departamento)
VALUES ('Daniel', 'Recursos Humanos');

INSERT INTO empleados(nombre, departamento)
VALUES ('Juan', 'Logistica');

SELECT * FROM empleados;
 