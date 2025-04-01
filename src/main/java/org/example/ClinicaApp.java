package org.example;

import java.util.Scanner;

public class ClinicaApp {
    private static CentroClinico centroClinico;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        centroClinico = new CentroClinico("Clinica Salud","Av. Siempre Viva 123");
        int op;
        do {
            System.out.println("\tMenu Clinica");
            System.out.println("1. Gestion del centro clinico");
            System.out.println("2. Gestion Medicos");
            System.out.println("3. Gestion pacientes");
            System.out.println("4. Gestion de citas Medicas");
            System.out.println("5. Salir");
            op=scanner.nextInt();
            switch (op){
                case 1:
                    gestionCentro();
                    break;
                case 2:
                    gestionMedicos();
                    break;
                case 3:
                    gestionPacientes();
                    break;
                case 4:
                    gestionCitas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("opcion invalida");
            }
        }while (op!=5);

    }

    private static void gestionCentro() {
        int opc;
        do {
            System.out.println("Gestion del Centro");
            System.out.println("1. Ver informacion del centro");
            System.out.println("2. Editar Informacion del centro");
            System.out.println("3. Volver");
            opc=scanner.nextInt();
            scanner.nextLine();

            switch (opc){
                case 1:
                    centroClinico.verInformacion();
                    break;
                case 2:
                    centroClinico.menuEditarInformacion();
                    break;
                case 3:
                    System.out.println("Volviendo al menu anterior...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }while (opc!=3);
    }

    private static void gestionMedicos() {
        int opc;
        do {
            System.out.println("Gestion de Medicos");
            System.out.println("1. Agregar nuevo medico");
            System.out.println("2. Buscar medico medico");
            System.out.println("3. Modificar informacion del medico");
            System.out.println("4. Listar todos los medicos");
            System.out.println("5. Volver");
            opc=scanner.nextInt();
            switch (opc){
                case 1:
                    Medico.agregarMedico();
                    break;
                case 2:
                    Medico.buscarMedico();
                    break;
                case 3:
                    Medico.modificarInformacion();
                case 4:
                    Medico.listarMedico();
                case 5:
                    System.out.println("Volviendo al menu anterior...");
                    break;
                default:
                    System.out.println("opcion invalida");
            }
        }while (opc!=5);

    }

    private static void gestionPacientes() {
        int opc;
        do {
            System.out.println("Gestion de Pacientes");
            System.out.println("1. Resgistrar nuevo paciente");
            System.out.println("2. Buscar paciente");
            System.out.println("3. Modificar informacion de un paciente");
            System.out.println("4. Listar todos los pacientes");
            System.out.println("5. Volver");
            opc=scanner.nextInt();

            switch (opc){
                case 1:
                    Paciente.registrarPaciente();
                    break;
                case 2:
                    Paciente.buscarPaciente();
                    break;
                case 3:
                    Paciente.modificarPaciente();
                    break;
                case 4:
                    Paciente.listarPacientes();
                    break;
                case 5:
                    System.out.println("Volviendo al menu anteriror...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while (opc!=5);
    }

    private static void gestionCitas() {
        int opc = 0;
        do {
            System.out.println("Gestión de citas médicas");
            System.out.println("1. Agendar nueva cita");
            System.out.println("2. Modificar una cita");
            System.out.println("3. Cancelar una cita");
            System.out.println("4. Buscar cita por paciente");
            System.out.println("5. Buscar cita por médico");
            System.out.println("6. Listar todas las citas");
            System.out.println("7. Volver");
            opc = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opc) {
                case 1:
                    CitaMedica.agendarCita();
                    break;
                case 2:
                    CitaMedica.modificarCita();
                    break;
                case 3:
                    CitaMedica.cancelarCita();
                    break;
                case 4:
                    CitaMedica.buscarCitaPorPaciente();
                    break;
                case 5:
                    CitaMedica.buscarCitaPorMedico();
                    break;
                case 6:
                    CitaMedica.listarCitas();
                    break;
                case 7:
                    System.out.println("Volviendo al menú anterior...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opc != 7);
    }
}
