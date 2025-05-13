
CREATE TABLE Funcionarios (
                              doc_identificacion bigINT PRIMARY KEY,
                              nombres VARCHAR(100),
                              apellidos VARCHAR(100),
                              estado_civil VARCHAR(50),
                              sexo CHAR(1),
                              direccion VARCHAR(255),
                              telefono VARCHAR(20),
                              fecha_nacimiento DATE
);

CREATE TABLE Relaciones_familiares (
                                       identificacion_familiar bigINT PRIMARY KEY,
                                       doc_identificacion bigINT,
                                       rol VARCHAR(50), -- Campo para especificar el tipo de relación (hermano, madre, padre, etc.)
                                       nombres VARCHAR(100),
                                       apellidos VARCHAR(100),
                                       estado_civil VARCHAR(50),
                                       sexo CHAR(1),
                                       direccion VARCHAR(255),
                                       telefono VARCHAR(20),
                                       fecha_nacimiento DATE,
                                       FOREIGN KEY (doc_identificacion) REFERENCES Funcionarios(doc_identificacion)
                                           ON DELETE CASCADE
                                           ON UPDATE CASCADE
);

CREATE TABLE Informacion_academica (
                                       matricula_profesional bigINT PRIMARY KEY,
                                       doc_identificacion bigINT,
                                       universidad VARCHAR(100),
                                       titulo VARCHAR(100),
                                       nivel_estudios VARCHAR(50),
                                       FOREIGN KEY (doc_identificacion) REFERENCES Funcionarios(doc_identificacion)
                                           ON DELETE CASCADE
                                           ON UPDATE CASCADE
);


INSERT INTO Funcionarios (doc_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (1033375084, 'Ana María', 'López García', 'Soltera', 'F', 'Calle 123 #45-67, Bogotá', '3001234567', '1990-05-15'),
    (8293847582, 'Carlos Andrés', 'Pérez Díaz', 'Casado', 'M', 'Carrera 45 #67-89, Medellín', '3107654321', '1985-08-20'),
    (1342456789, 'Laura Catalina', 'Ramírez Torres', 'Divorciada', 'F', 'Av. Siempre Viva 742, Cali', '3209876543', '1992-12-01');

-- Insertar datos en Relaciones_familiares
INSERT INTO Relaciones_familiares (identificacion_familiar, doc_identificacion, rol, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
    (200001001, 1033375084, 'Madre', 'Marta', 'García Ruiz', 'Viuda', 'F', 'Calle 123 #45-67, Bogotá', '3101112233', '1965-02-10'),
    (200001002, 1033375084, 'Hermano', 'Carlos', 'López García', 'Soltero', 'M', 'Calle 124 #45-68, Bogotá', '3201112233','1992-03-12'),
    (200001003, 8293847582, 'Esposa', 'Diana', 'Sánchez Muñoz', 'Casada', 'F', 'Carrera 45 #67-89, Medellín', '3107654322', '1986-07-14');


-- Insertar datos en Informacion_academica
INSERT INTO Informacion_academica (matricula_profesional, doc_identificacion, universidad, titulo, nivel_estudios)
VALUES
    (301001001, 1033375084, 'Universidad Nacional', 'Ingeniera de Sistemas', 'Pregrado'),
    (301001002, 1033375084, 'Universidad de Antioquia', 'Administrador de Empresas', 'Maestría'),
    (301001003, 1342456789, 'Pontificia Universidad Javeriana', 'Psicóloga', 'Pregrado');


