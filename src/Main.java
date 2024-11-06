import controller.EmpleadoController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception
    {

                EmpleadoController empleadoController = new EmpleadoController();
                Scanner scanner = new Scanner(System.in);
                int opcion;

                do {
                    System.out.println("=== Menú de Empleados ===");
                    System.out.println("1. Crear Empleado");
                    System.out.println("2. Listar Empleados");
                    System.out.println("3. Buscar Empleado por ID");
                    System.out.println("4. Actualizar Empleado");
                    System.out.println("5. Eliminar Empleado");
                    System.out.println("0. Salir");
                    System.out.print("Seleccione una opción: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1 -> empleadoController.createEmpleado();
                        case 2 -> empleadoController.getEmpleados();
                        case 3 -> empleadoController.getEmpleadoById();
                        case 4 -> empleadoController.updateEmpleado();
                        case 5 -> empleadoController.deleteEmpleado();
                        case 0 -> System.out.println("Saliendo del sistema...");
                        default -> System.out.println("Opción inválida. Intente nuevamente.");
                    }
                } while (opcion != 0);

                scanner.close();
            }
        }


