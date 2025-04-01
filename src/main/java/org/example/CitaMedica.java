package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitaMedica {
    private static List<CitaMedica> citas = new ArrayList<>();
    private static int contadorId = 1;
    private String id;
    private String pacienteId;
    private String medicoId;
    private String fecha;
    private String hora;
    private static Scanner scanner = new Scanner(System.in);

    public CitaMedica(String pacienteId, String medicoId, String fecha, String hora) {
        this.id = String.valueOf(contadorId++);
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.fecha = fecha;
        this.hora = hora;
    }

    public static void agendarCita() {
        System.out.println("Ingrese el ID del paciente:");
        String pacienteId = scanner.nextLine();
        System.out.println("Ingrese el ID del médico:");
        String medicoId = scanner.nextLine();
        System.out.println("Ingrese la fecha de la cita (DD/MM/YYYY):");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese la hora de la cita (HH:MM):");
        String hora = scanner.nextLine();

        CitaMedica nuevaCita = new CitaMedica(pacienteId, medicoId, fecha, hora);
        citas.add(nuevaCita);
        System.out.println("Cita agendada exitosamente con ID: " + nuevaCita.getId());
    }

    public static void modificarCita() {
        System.out.println("Ingrese el ID de la cita a modificar:");
        String idBuscado = scanner.nextLine();
        for (CitaMedica cita : citas) {
            if (cita.getId().equals(idBuscado)) {
                System.out.println("Ingrese la nueva fecha de la cita (DD/MM/YYYY):");
                String nuevaFecha = scanner.nextLine();
                System.out.println("Ingrese la nueva hora de la cita (HH:MM):");
                String nuevaHora = scanner.nextLine();

                cita.setFecha(nuevaFecha);
                cita.setHora(nuevaHora);
                System.out.println("Cita actualizada.");
                return;
            }
        }
        System.out.println("Cita no encontrada con ID: " + idBuscado);
    }

    public static void cancelarCita() {
        System.out.println("Ingrese el ID de la cita a cancelar:");
        String idBuscado = scanner.nextLine();
        for (CitaMedica cita : citas) {
            if (cita.getId().equals(idBuscado)) {
                citas.remove(cita);
                System.out.println("Cita cancelada.");
                return;
            }
        }
        System.out.println("Cita no encontrada con ID: " + idBuscado);
    }

    public static void buscarCitaPorPaciente() {
        System.out.println("Ingrese el ID del paciente:");
        String pacienteId = scanner.nextLine();
        boolean found = false;
        for (CitaMedica cita : citas) {
            if (cita.getPacienteId().equals(pacienteId)) {
                System.out.println("Cita encontrada: " + cita);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron citas para el paciente con ID: " + pacienteId);
        }
    }

    public static void buscarCitaPorMedico() {
        System.out.println("Ingrese el ID del médico:");
        String medicoId = scanner.nextLine();
        boolean found = false;
        for (CitaMedica cita : citas) {
            if (cita.getMedicoId().equals(medicoId)) {
                System.out.println("Cita encontrada: " + cita);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron citas para el médico con ID: " + medicoId);
        }
    }

    public static void listarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
        } else {
            System.out.println("Lista de citas:");
            for (CitaMedica cita : citas) {
                System.out.println(cita);
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Paciente ID: " + pacienteId + ", Médico ID: " + medicoId +
                ", Fecha: " + fecha + ", Hora: " + hora;
    }

    public String getId() {
        return id;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public String getMedicoId() {
        return medicoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
