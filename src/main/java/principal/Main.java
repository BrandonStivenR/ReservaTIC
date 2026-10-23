package principal;

import dao.UsuarioDAO;
import modelos.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n=== RESERVATIC - Módulo de Usuarios ===");
            System.out.println("1. Insertar usuario");
            System.out.println("2. Consultar usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Iniciar sesión");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Escribe un número válido.");
                opcion = -1;
                continue;
            }

            try {
                switch (opcion) {
                    case 1:
                        Usuario nuevo = new Usuario();
                        System.out.print("Nombre completo: ");
                        nuevo.setNombreCompleto(scanner.nextLine());
                        System.out.print("Documento de identidad: ");
                        nuevo.setDocumentoIdentidad(scanner.nextLine());
                        System.out.print("Correo institucional: ");
                        nuevo.setCorreoInstitucional(scanner.nextLine());
                        System.out.print("Contraseña: ");
                        nuevo.setContrasena(scanner.nextLine());
                        System.out.print("Rol (Docente/Estudiante): ");
                        nuevo.setRol(scanner.nextLine());
                        System.out.println(usuarioDAO.insertarUsuario(nuevo)
                                ? "Usuario insertado." : "No se pudo insertar.");
                        break;
                    case 2:
                        usuarioDAO.listarUsuarios().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("ID: ");
                        Usuario encontrado = usuarioDAO.buscarPorId(Integer.parseInt(scanner.nextLine().trim()));
                        System.out.println(encontrado != null ? encontrado : "No existe.");
                        break;
                    case 4:
                        Usuario editado = new Usuario();
                        System.out.print("ID a actualizar: ");
                        editado.setIdUsuario(Integer.parseInt(scanner.nextLine().trim()));
                        System.out.print("Nuevo nombre completo: ");
                        editado.setNombreCompleto(scanner.nextLine());
                        System.out.print("Nuevo documento de identidad: ");
                        editado.setDocumentoIdentidad(scanner.nextLine());
                        System.out.print("Nuevo correo institucional: ");
                        editado.setCorreoInstitucional(scanner.nextLine());
                        System.out.print("Nuevo rol (Docente/Estudiante): ");
                        editado.setRol(scanner.nextLine());
                        System.out.println(usuarioDAO.actualizarUsuario(editado)
                                ? "Usuario actualizado." : "No se pudo actualizar.");
                        break;
                    case 5:
                        System.out.print("ID a eliminar: ");
                        System.out.println(usuarioDAO.eliminarUsuario(Integer.parseInt(scanner.nextLine().trim()))
                                ? "Usuario eliminado." : "No se pudo eliminar.");
                        break;
                    case 6:
                        System.out.print("Correo institucional: ");
                        String correo = scanner.nextLine();
                        System.out.print("Contraseña: ");
                        String clave = scanner.nextLine();
                        Usuario sesion = usuarioDAO.autenticar(correo, clave);
                        System.out.println(sesion != null
                                ? "Bienvenido, " + sesion.getNombreCompleto() : "Credenciales incorrectas.");
                        break;
                    case 0:
                        System.out.println("Hasta luego.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("El ID debe ser un número.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}