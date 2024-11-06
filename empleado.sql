
CREATE TABLE Funcionarios (
                              doc_identificacion INT PRIMARY KEY,
                              nombres VARCHAR(100),
                              apellidos VARCHAR(100),
                              estado_civil VARCHAR(50),
                              sexo CHAR(1),
                              direccion VARCHAR(255),
                              telefono VARCHAR(20),
                              fecha_nacimiento DATE
);


CREATE TABLE Grupo_familiar (
                                id_familia INT PRIMARY KEY,
                                doc_identificacion INT,
                                identificacion_hermano INT,
                                identificacion_madre INT,
                                identificacion_padre INT,
                                identificacion_hijo INT,
                                identificacion_abuelo INT,
                                identificacion_tio INT,
                                identificacion_primo INT
);


CREATE TABLE hermano (
                         identificacion_hermano INT PRIMARY KEY,
                         id_familia INT,
                         nombres VARCHAR(100),
                         apellidos VARCHAR(100),
                         estado_civil VARCHAR(50),
                         sexo CHAR(1),
                         direccion VARCHAR(255),
                         telefono VARCHAR(20),
                         fecha_nacimiento DATE
);


CREATE TABLE madre (
                       identificacion_madre INT PRIMARY KEY,
                       id_familia INT,
                       nombres VARCHAR(100),
                       apellidos VARCHAR(100),
                       estado_civil VARCHAR(50),
                       sexo CHAR(1),
                       direccion VARCHAR(255),
                       telefono VARCHAR(20),
                       fecha_nacimiento DATE
);


CREATE TABLE padre (
                       identificacion_padre INT PRIMARY KEY,
                       id_familia INT,
                       nombres VARCHAR(100),
                       apellidos VARCHAR(100),
                       estado_civil VARCHAR(50),
                       sexo CHAR(1),
                       direccion VARCHAR(255),
                       telefono VARCHAR(20),
                       fecha_nacimiento DATE
);

-- Creación de la tabla hijo
CREATE TABLE hijo (
                      identificacion_hijo INT PRIMARY KEY,
                      id_familia INT,
                      nombres VARCHAR(100),
                      apellidos VARCHAR(100),
                      estado_civil VARCHAR(50),
                      sexo CHAR(1),
                      direccion VARCHAR(255),
                      telefono VARCHAR(20),
                      fecha_nacimiento DATE
);

-- Creación de la tabla abuelo
CREATE TABLE abuelo (
                        identificacion_abuelo INT PRIMARY KEY,
                        id_familia INT,
                        nombres VARCHAR(100),
                        apellidos VARCHAR(100),
                        estado_civil VARCHAR(50),
                        sexo CHAR(1),
                        direccion VARCHAR(255),
                        telefono VARCHAR(20),
                        fecha_nacimiento DATE
);

-- Creación de la tabla tio
CREATE TABLE tio (
                     identificacion_tio INT PRIMARY KEY,
                     id_familia INT,
                     nombres VARCHAR(100),
                     apellidos VARCHAR(100),
                     estado_civil VARCHAR(50),
                     sexo CHAR(1),
                     direccion VARCHAR(255),
                     telefono VARCHAR(20),
                     fecha_nacimiento DATE
);

-- Creación de la tabla primo
CREATE TABLE primo (
                       identificacion_primo INT PRIMARY KEY,
                       id_familia INT,
                       nombres VARCHAR(100),
                       apellidos VARCHAR(100),
                       estado_civil VARCHAR(50),
                       sexo CHAR(1),
                       direccion VARCHAR(255),
                       telefono VARCHAR(20),
                       fecha_nacimiento DATE
);

-- Creación de la tabla Informacion_academica
CREATE TABLE Informacion_academica (
                                       matricula_profesional INT PRIMARY KEY,
                                       doc_identificacion INT,
                                       universidad VARCHAR(100),
                                       titulo VARCHAR(100),
                                       nivel_estudios VARCHAR(50)
);

-- Agregar las llaves foráneas con ALTER TABLE
ALTER TABLE Grupo_familiar
    ADD FOREIGN KEY (doc_identificacion) REFERENCES Funcionarios(doc_identificacion),
    ADD FOREIGN KEY (identificacion_hermano) REFERENCES hermano(identificacion_hermano),
    ADD FOREIGN KEY (identificacion_madre) REFERENCES madre(identificacion_madre),
    ADD FOREIGN KEY (identificacion_padre) REFERENCES padre(identificacion_padre),
    ADD FOREIGN KEY (identificacion_hijo) REFERENCES hijo(identificacion_hijo),
    ADD FOREIGN KEY (identificacion_abuelo) REFERENCES abuelo(identificacion_abuelo),
    ADD FOREIGN KEY (identificacion_tio) REFERENCES tio(identificacion_tio),
    ADD FOREIGN KEY (identificacion_primo) REFERENCES primo(identificacion_primo);

ALTER TABLE hermano
    ADD FOREIGN KEY (id_familia) REFERENCES Grupo_familiar(id_familia);

ALTER TABLE madre
    ADD FOREIGN KEY (id_familia) REFERENCES Grupo_familiar(id_familia);

ALTER TABLE padre
    ADD FOREIGN KEY (id_familia) REFERENCES Grupo_familiar(id_familia);

ALTER TABLE hijo
    ADD FOREIGN KEY (id_familia) REFERENCES Grupo_familiar(id_familia);

ALTER TABLE abuelo
    ADD FOREIGN KEY (id_familia) REFERENCES Grupo_familiar(id_familia);

ALTER TABLE tio
    ADD FOREIGN KEY (id_familia) REFERENCES Grupo_familiar(id_familia);

ALTER TABLE primo
    ADD FOREIGN KEY (id_familia) REFERENCES Grupo_familiar(id_familia);

ALTER TABLE Informacion_academica
    ADD FOREIGN KEY (doc_identificacion) REFERENCES Funcionarios(doc_identificacion);

INSERT INTO Funcionarios (doc_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (1001, 'Juan', 'Pérez', 'Soltero', 'M', 'Calle 123', '1234567890', '1980-01-01'),
    (1002, 'María', 'González', 'Casada', 'F', 'Avenida 456', '0987654321', '1985-02-02');


INSERT INTO Grupo_familiar (id_familia, doc_identificacion, identificacion_hermano, identificacion_madre, identificacion_padre,
                            identificacion_hijo, identificacion_abuelo, identificacion_tio, identificacion_primo)
VALUES
    (1, 1001, 2001, 3001, 4001, 5001, 6001, 7001, 8001),
    (2, 1002, 2002, 3002, 4002, 5002, 6002, 7002, 8002);


INSERT INTO hermano (identificacion_hermano, id_familia, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (2001, 1, 'Carlos', 'Pérez', 'Soltero', 'M', 'Calle 789', '1111111111', '1990-03-03'),
    (2002, 2, 'Ana', 'González', 'Soltera', 'F', 'Avenida 101', '2222222222', '1992-04-04');

-- Insertar datos en la tabla madre
INSERT INTO madre (identificacion_madre, id_familia, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (3001, 1, 'Laura', 'López', 'Casada', 'F', 'Calle 234', '3333333333', '1960-05-05'),
    (3002, 2, 'Lucía', 'Martínez', 'Casada', 'F', 'Avenida 202', '4444444444', '1962-06-06');


INSERT INTO padre (identificacion_padre, id_familia, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (4001, 1, 'Miguel', 'Pérez', 'Casado', 'M', 'Calle 567', '5555555555', '1955-07-07'),
    (4002, 2, 'Jorge', 'González', 'Casado', 'M', 'Avenida 303', '6666666666', '1957-08-08');


INSERT INTO hijo (identificacion_hijo, id_familia, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (5001, 1, 'Pedro', 'Pérez', 'Soltero', 'M', 'Calle 890', '7777777777', '2010-09-09'),
    (5002, 2, 'Lucía', 'González', 'Soltera', 'F', 'Avenida 404', '8888888888', '2012-10-10');


INSERT INTO abuelo (identificacion_abuelo, id_familia, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (6001, 1, 'Francisco', 'Pérez', 'Viudo', 'M', 'Calle 111', '9999999999', '1930-11-11'),
    (6002, 2, 'Antonio', 'González', 'Viudo', 'M', 'Avenida 505', '1010101010', '1932-12-12');


INSERT INTO tio (identificacion_tio, id_familia, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (7001, 1, 'Luis', 'Pérez', 'Casado', 'M', 'Calle 222', '1212121212', '1965-01-13'),
    (7002, 2, 'Roberto', 'González', 'Casado', 'M', 'Avenida 606', '1313131313', '1967-02-14');


INSERT INTO primo (identificacion_primo, id_familia, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (8001, 1, 'Daniel', 'Pérez', 'Soltero', 'M', 'Calle 333', '1414141414', '1995-03-15'),
    (8002, 2, 'Cristina', 'González', 'Soltera', 'F', 'Avenida 707', '1515151515', '1997-04-16');


INSERT INTO Informacion_academica (matricula_profesional, doc_identificacion, universidad, titulo, nivel_estudios)
VALUES
    (9001, 1001, 'Universidad Nacional', 'Ingeniería', 'Pregrado'),
    (9002, 1002, 'Universidad Estatal', 'Derecho', 'Posgrado');
