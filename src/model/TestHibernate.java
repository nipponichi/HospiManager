/*package model;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestHibernate {

    public static void main(String[] args) {
        hibernateAccionesPaciente accionesPaciente = new hibernateAccionesPaciente();
        hibernateAccionesMedico accionesMedico = new hibernateAccionesMedico();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Opción 1 - Guardar Paciente");
            System.out.println("2. Opción 2 - Mostrar Paciente");
            System.out.println("3. Opción 3 - Actualizar Paciente");
            System.out.println("4. Opción 4 - Eliminar Paciente");
            System.out.println("5. Opción 5 - Guardar Medico");
            System.out.println("6. Opción 6 - Mostrar Medico");
            System.out.println("7. Opción 7 - Actualizar Medico");
            System.out.println("8. Opción 8 - Eliminar Medico");
            
            System.out.println("9. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        accionesPaciente.guardarPaciente();
                        break;
                    case 2:
                        accionesPaciente.mostrarPaciente();
                        break;
                    case 3:
                        accionesPaciente.actualizarPaciente();
                        break;
                    case 4:
                        accionesPaciente.eliminarPaciente();
                        break;
                    case 5:
                        accionesMedico.guardarMedico();
                        break;
                    case 6:
                        accionesMedico.mostrarMedico();
                        break;
                    case 7:
                        accionesMedico.actualizarMedico();
                        break;
                    case 8:
                        accionesMedico.eliminarMedico();
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 7");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scanner.next();
            }
        }

    }
}*/
