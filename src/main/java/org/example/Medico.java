package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Medico {
    private static List<Medico> medicos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    private int id;
    private String nombre;
    private String especialidad;
    private int experiencia;//en años
    private boolean disponibilidad;

    public Medico(int id,String nombre,String especialidad, int experiencia, boolean disponibilidad){
        this.id=id;
        this.nombre=nombre;
        this.especialidad=especialidad;
        this.experiencia=experiencia;
        this.disponibilidad=disponibilidad;
    }

    public static void agregarMedico() {
        int id=0;
        Scanner scanner = new Scanner(System.in);
        id++;
        System.out.println("Ingresa el nombre del medico");
        String nombre = scanner.nextLine();
        System.out.println("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.println("Experiencia");
        int experiencia =scanner.nextInt();
        boolean disponibilidad=true;
        medicos.add(new Medico(id,nombre,especialidad,experiencia,disponibilidad));
        System.out.println("Se agrego el medico");
    }

    public static void buscarMedico() {
        int opc=0;
        do {
            System.out.println("Buscar Medico");
            System.out.println("1. id");
            System.out.println("2. nombre");
            System.out.println("3. especialidad");
            System.out.println("4. experiencia");
            System.out.println("5. disponibilidad");
            System.out.println("6. volver");
            opc= sc.nextInt();
            sc.nextLine();

            switch (opc){
                case 1:
                    buscarId();
                    break;
                case 2:
                    buscarNombre();
                    break;
                case 3:
                    buscarEspecialidad();
                    break;
                case 4:
                    buscarExperiencia();
                    break;
                case 5:
                    buscarDisponibilidad();
                    break;
                case 6:
                    System.out.println("Volviendo al menu anterior...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while (opc!=6);
    }

    private static Medico buscarId() {
        System.out.println("Ingrese el id");
        int idBuscado= sc.nextInt();
        sc.nextLine();
        for(Medico medico:medicos){
            if (medico.id==idBuscado){
                System.out.println(medico.toString());
                return medico;
            }
        }
        System.out.println("Medico no encontrado con id: " +idBuscado);
        return null;
    }

    private static void buscarNombre() {
        System.out.println("Ingrese el nombre");
        String nombreBuscado= sc.nextLine();
        for(Medico medico:medicos){
            if (medico.nombre.equals(nombreBuscado)){
                System.out.println(medico.toString());
                return;
            }
        }
        System.out.println("Medico no encontrado con nombre: " +nombreBuscado);
    }

    private static void buscarEspecialidad() {
        System.out.println("Ingrese la especialidad");
        String especialidadBuscado= sc.nextLine();
        for(Medico medico:medicos){
            if (medico.especialidad.equals(especialidadBuscado)){
                System.out.println(medico.toString());
                return;
            }
        }
        System.out.println("Medico no encontrado en esa especialidad: " +especialidadBuscado);
    }

    private static void buscarExperiencia() {
        System.out.println("Ingrese la experiencia");
        int experienciaBuscado= sc.nextInt();
        for(Medico medico:medicos){
            if (medico.experiencia==experienciaBuscado){
                System.out.println(medico.toString());
                return;
            }
        }
        System.out.println("Medico no encontrado con nombre: " +experienciaBuscado);
    }

    private static void buscarDisponibilidad() {
        System.out.println("Ingrese la disponibilidad (disponible/no disponible):");
        String disponibilidadBuscada = sc.nextLine().trim().toLowerCase(); // Leer la entrada y normalizarla

        boolean disponibilidad = false; // Valor por defecto
        if (disponibilidadBuscada.equals("disponible")) {
            disponibilidad = true; // Si el usuario ingresó "disponible", se establece en true
        } else if (disponibilidadBuscada.equals("no disponible")) {
            disponibilidad = false; // Si el usuario ingresó "no disponible", se establece en false
        } else {
            System.out.println("Opción de disponibilidad no válida. Debe ser 'disponible' o 'no disponible'.");
            return; // Salir del método si la entrada no es válida
        }

        boolean encontrado = false; // Variable para verificar si se encontró algún médico
        for (Medico medico : medicos) {
            if (medico.disponibilidad == disponibilidad) {
                System.out.println(medico); // Imprimir el médico encontrado
                encontrado = true; // Marcar que se encontró al menos un médico
            }
        }

        // Mensaje si no se encontró ningún médico
        if (!encontrado) {
            System.out.println("No se encontraron médicos con disponibilidad: " + disponibilidadBuscada);
        }
    }

    public static void modificarInformacion() {
        int opc=0;
        do {
            System.out.println("Buscar Medico");
            Medico medico = buscarId();
            if(medico==null){
                return;
            }
            System.out.println("1. modificar nombre");
            System.out.println("2. modificar especialidad");
            System.out.println("3. modificar experiencia");
            System.out.println("4. modificar disponibilidad");
            System.out.println("5. volver");
            opc= sc.nextInt();
            sc.nextLine();

            switch (opc){
                case 1:
                    modificarNombre(medico);
                    break;
                case 2:
                    modificarEspecialidad(medico);
                    break;
                case 3:
                    modificarExperiencia(medico);
                    break;
                case 4:
                    modificarDisponibilidad(medico);
                    break;
                case 5:
                    System.out.println("Volviendo al menu anterior");
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        }while (opc!=5);
    }

    private static void modificarNombre(Medico medico) {
        System.out.println("Ingrese el nuevo nombre");
        String nuevoNombre = sc.nextLine();
        medico.nombre = nuevoNombre;
        System.out.println("Nombre actualizado: "+nuevoNombre);
    }

    private static void modificarEspecialidad(Medico medico) {
        System.out.println("Ingrese la nueva especialidad");
        String nuevaEspecialidad=sc.nextLine();
        medico.especialidad = nuevaEspecialidad;
        System.out.println("Especialidad actualizado: "+nuevaEspecialidad);
    }

    private static void modificarExperiencia(Medico medico) {
        System.out.println("Ingrese la nueva experiencia");
        String nuevaExperiencia = sc.nextLine();
        medico.nombre =nuevaExperiencia;
        System.out.println("Nombre actualizado: "+nuevaExperiencia);
    }

    private static void modificarDisponibilidad(Medico medico) {
        int opc=0;
        boolean nuevaDisponibilidad;
        do {
            System.out.println("Ingrese la disponibilidad");
            System.out.println("1. Libre");
            System.out.println("2. Ocupado");
            opc=sc.nextInt();
            sc.nextLine();

            switch (opc){
                case 1:
                    nuevaDisponibilidad = true;
                    System.out.println("Disponibilidad actualizada");
                    break;
                case 2:
                    nuevaDisponibilidad = false;
                    System.out.println("Disponibilidad actualizada");
                    break;
                case 3:
                    System.out.println("Volviendo al menu anterior...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        }while (opc!=3);

    }

    public static void listarMedico() {
        if(medicos.isEmpty()){
            System.out.println("No hay medicos registrados");
        }else {
            System.out.println("Lista de medicos:");
            for (Medico medico:medicos){
            System.out.println(medico);
            }
        }
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", experiencia=" + experiencia +
                ", disponibilidad=" + (disponibilidad ?"disponible ":"no disponible")+
                '}';
    }
}
