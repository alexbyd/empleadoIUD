package controller;

import data.EmpleadoDao;
import model.Empleado;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmpleadoController {


        private EmpleadoDao empleadoDao = new EmpleadoDao();


        public void createEmpleado() {
            Scanner scanner = new Scanner(System.in);
            try {
                Empleado empleado = new Empleado();
                System.out.print("Ingrese el documento de identificación: ");
                empleado.setDoc_identificacion(scanner.nextInt());
                scanner.nextLine();

                System.out.print("Ingrese el nombre: ");
                empleado.setNombre(scanner.nextLine());

                System.out.print("Ingrese el apellido: ");
                empleado.setApellido(scanner.nextLine());

                System.out.print("Ingrese el teléfono: ");
                empleado.setTelefono(scanner.nextLine());

                System.out.print("Ingrese la dirección: ");
                empleado.setDireccion(scanner.nextLine());

                System.out.print("Ingrese la fecha de nacimiento (yyyy-mm-dd): ");
                empleado.setFecha_nacimiento(java.sql.Date.valueOf(scanner.nextLine()));

                System.out.print("Ingrese el estado civil: ");
                empleado.setEstado_civil(scanner.nextLine());

                empleadoDao.createEmpleado(empleado);
                System.out.println("Empleado creado exitosamente.");

            } catch (SQLException e) {
                System.err.println("Error al crear el empleado: " + e.getMessage());
            }
        }


        public void getEmpleados() {
            try {
                List<Empleado> empleados = empleadoDao.getEmpleados();
                if (empleados.isEmpty()) {
                    System.out.println("No hay empleados registrados.");
                } else {
                    System.out.println("Lista de empleados:");
                    for (Empleado empleado : empleados) {
                        System.out.println(empleado);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener la lista de empleados: " + e.getMessage());
            }
        }


        public void getEmpleadoById() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el documento de identificación del empleado: ");
            int docIdentificacion = scanner.nextInt();

            try {
                Empleado empleado = empleadoDao.getEmpleadoById(docIdentificacion);
                if (empleado != null) {
                    System.out.println("Empleado encontrado:");
                    System.out.println(empleado);
                } else {
                    System.out.println("Empleado no encontrado.");
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener el empleado: " + e.getMessage());
            }
        }


        public void updateEmpleado() {
            Scanner scanner = new Scanner(System.in);
            try {
                Empleado empleado = new Empleado();
                System.out.print("Ingrese el documento de identificación del empleado a actualizar: ");
                empleado.setDoc_identificacion(scanner.nextInt());
                scanner.nextLine();

                System.out.print("Ingrese el nuevo nombre: ");
                empleado.setNombre(scanner.nextLine());

                System.out.print("Ingrese el nuevo apellido: ");
                empleado.setApellido(scanner.nextLine());

                System.out.print("Ingrese el nuevo teléfono: ");
                empleado.setTelefono(scanner.nextLine());

                System.out.print("Ingrese la nueva dirección: ");
                empleado.setDireccion(scanner.nextLine());

                System.out.print("Ingrese la nueva fecha de nacimiento (yyyy-mm-dd): ");
                empleado.setFecha_nacimiento(java.sql.Date.valueOf(scanner.nextLine()));

                System.out.print("Ingrese el nuevo estado civil: ");
                empleado.setEstado_civil(scanner.nextLine());

                empleadoDao.updateEmpleado(empleado);
                System.out.println("Empleado actualizado exitosamente.");

            } catch (SQLException e) {
                System.err.println("Error al actualizar el empleado: " + e.getMessage());
            }
        }


        public void deleteEmpleado() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el documento de identificación del empleado a eliminar: ");
            int docIdentificacion = scanner.nextInt();

            try {
                empleadoDao.deleteEmpleado(docIdentificacion);
                System.out.println("Empleado eliminado exitosamente.");

            } catch (SQLException e) {
                System.err.println("Error al eliminar el empleado: " + e.getMessage());
            }
        }
}
