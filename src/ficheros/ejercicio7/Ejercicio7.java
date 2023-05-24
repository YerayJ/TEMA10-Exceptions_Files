package ficheros.ejercicio7;

import ficheros.MetodoLista;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio7 {

    public static final String DIR = "src\\ficheros\\ejercicio7\\Agenda.txt";

    public static void main(String[] args) {
        // Creación de escáner
        Scanner key = null;

        // Declara el bw para escribir por teclado
        BufferedWriter bw = null;

        // Creación de una lista para guardar los números
        HashMap<String, Long> agenda = MetodoLista.leerFichero();

        // Atributos para insertar datos en la agenda
        String nombre;
        long numero;

        // Atributo que contiene una opción
        int opc;

        try {
            // Creación de escáner para leer datos del usuario
            key = new Scanner(System.in);

            do {
                // Imprime el menú
                menu();
                // Pide opción al usuario
                System.out.println("Seleccione una opción: ");
                opc = key.nextInt();
                key.nextLine();

                switch (opc) {
                    case 1 -> {
                        // Con el parámetro true comprueba directamente si el archivo está creado y escribir debajo, si no lo crea
                        bw = new BufferedWriter(new FileWriter(DIR, true));
                        // Introduzca datos
                        System.out.println("Introduzca el nombre ");
                        nombre = key.nextLine();
                        System.out.println("Introduzca el número ");
                        numero = key.nextLong();
                        key.nextLine();

                        if (agenda.size() < 20) {
                            // Comprueba si la clave esta repetida
                            if (!agenda.containsKey(nombre)) {
                                // Inserta en la lista los datos
                                agenda.put(nombre, numero);
                                // Escribe en el archivo
                                bw.write(nombre + " " + numero);
                                bw.newLine();

                                bw.flush();
                            }
                        } else {
                            System.out.println("No se pueden insertar más contactos");
                        }

                    }
                    case 2 -> {
                        // Introduce el nombre a buscar
                        System.out.println("Introduzca el nombre");
                        nombre = key.nextLine();
                        // Muestra la clave
                        System.out.println(agenda.get(nombre));

                    }
                    case 3 -> {
                        for (Map.Entry<String, Long> contacto : agenda.entrySet()) {
                            System.out.println(contacto);
                        }
                    }
                    case 4 -> {
                        System.out.println("Está saliendo del programa...");
                    }
                }
            } while (opc != 4);

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se encuentra");
        } catch (IOException e) {
            System.out.println("Error, no se pudo crear el archivo.");

        } finally {
            // Finalmente comprueba que el bw no esté a null, que significa que se ha abierto en algún momento
            if (bw != null) {
                try {
                    // Se escribe el documento y se cierra todo
                    bw.close();

                } catch (IOException e) { // Captura la excepción
                    System.out.println("El archivo no se cerró correctamente");
                }
            }
            if (key != null) {
                key.close();
            }
        }

    }

    /**
     * Método que imprime el menú
     */
    static void menu() {
        System.out.println("\n----------AGENDA----------" +
                "\n1. Nuevo contacto." +
                "\n2. Buscar por nombre." +
                "\n3. Mostrar todos." +
                "\n4. Salir");
    }
}
