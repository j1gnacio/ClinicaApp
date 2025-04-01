package org.example;

import java.util.Scanner;

public class CentroClinico {
    private String nombre;
    private String ubicacion;

    public CentroClinico(String nombre, String ubicacion){
        this.nombre=nombre;
        this.ubicacion=ubicacion;
    }

    public void verInformacion(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Ubicacion: "+ubicacion);
    }

    public void menuEditarInformacion(){
        Scanner scanner = new Scanner(System.in);
        int opc=0;
        String nuevoNombre;
        String nuevaUbicacion;

        do {
            System.out.println("¿Que desea editar?");
            System.out.println("1.Editar nombre");
            System.out.println("2. Editar ubicacion");
            System.out.println("3. Ambas");
            System.out.println("4. Volver");
            opc=scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre:");
                    nuevoNombre = scanner.nextLine();
                    editarNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese la nueva ubicacion:");
                    nuevaUbicacion = scanner.nextLine();
                    editarUbicacion(nuevaUbicacion);
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo nombre:");
                    nuevoNombre = scanner.nextLine();
                    System.out.println("Ingrese la nueva ubicacion:");
                    nuevaUbicacion = scanner.nextLine();
                    editarAmbas(nuevoNombre,nuevaUbicacion);
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while (opc!=4);
    }

    private void editarNombre(String nuevoNombre) {
        this.nombre=nuevoNombre;
    }

    private void editarUbicacion(String nuevaUbicacion) {
        this.ubicacion=nuevaUbicacion;
    }

    private void editarAmbas(String nuevoNombre, String nuevaUbicacion) {
        this.nombre=nuevoNombre;
        this.ubicacion=nuevaUbicacion;
    }
}
