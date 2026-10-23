# ReservaTIC - Módulo de Usuarios

Módulo de gestión de usuarios del proyecto ReservaTIC, desarrollado en Java con conexión a MySQL mediante JDBC.

## Funcionalidades (CRUD)

- Insertar usuario
- Consultar usuarios
- Buscar usuario por ID
- Actualizar usuario
- Eliminar usuario
- Iniciar sesión (la contraseña se guarda con hash SHA-256)

## Tecnologías

- Java 17 o superior
- MySQL 8
- JDBC (MySQL Connector/J 8.4.0)
- Maven

## Estructura del proyecto

- `conexion/ConexionBD.java`: conexión a la base de datos
- `modelos/Usuario.java`: clase modelo
- `dao/UsuarioDAO.java`: operaciones CRUD con JDBC
- `principal/Main.java`: menú de consola para probar el módulo
- `script_bd.sql`: script de la base de datos

## Cómo ejecutarlo

1. Ejecutar `script_bd.sql` en MySQL para crear la base de datos `reservatic_db`.
2. En `ConexionBD.java`, escribir la contraseña de tu MySQL en la constante `PASSWORD`.
3. Abrir el proyecto en VS Code (con Extension Pack for Java).
4. Ejecutar la clase `principal.Main`.

## Autor

Brandon Steven Robles Lozada
Evidencia GA7-220501096-AA2-EV01. Codificación de módulos del software.