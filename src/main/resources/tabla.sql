-- Crear tabla de Usuarios
CREATE TABLE Personas (
    Persona_ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255),
    Apellido VARCHAR(255),
    Email VARCHAR(255),
    Telefono VARCHAR(20),
    Fecha_Nacimiento DATE
);

-- Crear tabla de Credenciales
CREATE TABLE Usuarios (
    Usuario_ID INT AUTO_INCREMENT PRIMARY KEY,
    Persona_ID INT,
    Usuario VARCHAR(50),
    Password VARCHAR(100),
    FOREIGN KEY (Persona_ID) REFERENCES Personas (Persona_ID)
);