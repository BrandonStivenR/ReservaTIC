CREATE DATABASE IF NOT EXISTS reservatic_db;
USE reservatic_db;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(150) NOT NULL,
  `documento_identidad` varchar(20) NOT NULL,
  `correo_institucional` varchar(100) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `rol` enum('Docente','Estudiante') NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `documento_identidad` (`documento_identidad`),
  UNIQUE KEY `correo_institucional` (`correo_institucional`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
