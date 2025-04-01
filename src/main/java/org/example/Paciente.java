package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paciente {
    private static List<Paciente> pacientes = new ArrayList<>();
    private static Scanner scanner=new Scanner(System.in);
    private static int contadorId = 1;
    private String id;
    private String nombre;
    private String contacto;

    public Paciente(String nombre, String contacto){
        this.id=String.valueOf(contadorId++);
        this.nombre=nombre;
        this.contacto=contacto;
    }

    public static void registrarPaciente() {
        System.out.println("Ingrese el nombre del paciente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el contacto del paciente");
        String contacto = scanner.nextLine();
        pacientes.add(new Paciente(nombre,contacto));
    }

    public static void buscarPaciente() {
        System.out.println("Ingrese el ID del paciente a buscar:");
        String idBuscado = scanner.nextLine();
        for(Paciente paciente:pacientes){
            if(paciente.getId().equals(idBuscado)){
                System.out.println("Paciente encontrado "+paciente);
                return;
            }
        }
        System.out.println("Paciente no encntrado con Id: "+idBuscado);
    }

    public static void modificarPaciente() {
        System.out.println("Ingrese el ID del paciente a modificar:");
        String idBuscado=scanner.nextLine();
        for (Paciente paciente:pacientes){
            if (paciente.getId().equals(idBuscado)){
                System.out.println("Ingrese el nuevo nombre del paciente");
                String nuevoNombre =scanner.nextLine();
                System.out.println("Ingrese el nuevo contacto del paciente: ");
                String nuevoContacto = scanner.nextLine();

                paciente.setNombre(nuevoNombre);
                paciente.setContacto(nuevoContacto);
                System.out.println("Informacion del paciente actualizada");
                return;
            }
        }
        System.out.println("Paciente no encontrado con id: "+idBuscado);
    }

    public static void listarPacientes() {
        if (pacientes.isEmpty()){
            System.out.println("No hay pacientes registrados. ");
        }else {
            System.out.println("Lista de pacientes");
            for (Paciente paciente:pacientes){
                System.out.println(paciente);
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}
