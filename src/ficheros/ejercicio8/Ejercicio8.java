package ficheros.ejercicio8;

import java.io.*;
import java.util.Scanner;

public class Ejercicio8 {

    public static final String DIR = "src\\ficheros\\ejercicio8\\temperatura.txt";

    public static void main(String[] args) {
        // Creación de escáner
        Scanner key = null;

        // Declara el bw para escribir por teclado
        BufferedWriter bw = null;

        // Creación de escáner para leer documento
        Scanner leerFichero = null;

        // Creación de un array
        String datos[];

        // Atributo para guardar linea a linea
        String linea;

        // Atributos para insertar datos
        double tempMin;
        double tempMax;
        double tempMinTotal = Double.MAX_VALUE;
        double tempMaxTotal = Double.MIN_VALUE;
        String fecha;

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
                        // Pide los datos al usuario
                        System.out.println("Introduzca la fecha (aaaa-mm-dd):");
                        fecha = key.nextLine();

                        System.out.println("Introduzca la temperatura máxima:");
                        tempMax = key.nextDouble();
                        key.nextLine();
                        System.out.println("Introduzca la temperatura mínima:");
                        tempMin = key.nextDouble();
                        key.nextLine();

                        // Inserta los datos en el archivo
                        bw.write(fecha + "," + tempMax + "," + tempMin);
                        bw.newLine();

                        bw.flush();

                    }


                    case 2 -> {
                        // Inicializa el escáner para leer el fichero
                        leerFichero = new Scanner(new FileReader(DIR));

                        // Salta la primera linea
                        leerFichero.nextLine();

                        // Mientras haya algo en el documento se sigue leyendo
                        while (leerFichero.hasNext()) {
                            // Se guarda la línea entera
                            linea = leerFichero.nextLine();
                            // Se guardan separados los datos
                            datos = linea.split(",");

                            // Se muestra la fecha
                            System.out.println("Fecha: " + datos[0]);
                            // La temperatura máxima se guarda paseándola a double
                            tempMax = Double.parseDouble(datos[1]);
                            // La temperatura mínima se guarda paseándola a double
                            tempMin = Double.parseDouble(datos[2]);
                            // Muestra los datos
                            System.out.println("Temperatura máxima: " + tempMax);
                            System.out.println("Temperatura mínima: " + tempMin);
                            System.out.println("--------------------------------");

                            // Comprueba cuales son las temperaturas máximas y mínimas
                            if (tempMaxTotal < tempMax) {
                                tempMaxTotal = tempMax;
                            } if (tempMinTotal > tempMin) {
                                tempMinTotal = tempMin;
                            }

                        }
                        // Muestra los totales
                        System.out.println("Temperatura máxima total: " + tempMaxTotal);
                        System.out.println("Temperatura mínima total: " + tempMinTotal);
                        System.out.println();

                    }
                    case 3 -> {
                        System.out.println("Está saliendo del programa...");
                    }
                }
            } while (opc != 3);

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
        System.out.println("\n----------TIEMPO----------" +
                "\n1. Registra nueva temperatura." +
                "\n2. Mostrar historial de registros." +
                "\n3. Salir");
    }
}
