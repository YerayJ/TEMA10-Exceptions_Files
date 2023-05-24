package ficheros.ejercicio4;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        // Declara el bw para escribir por teclado
        BufferedWriter bw = null;
        // Declara a null el escáner
        Scanner key = null;

        // Atributo boolean para seguir ejecutando
        boolean termina = false;

        // Atributo para guardar el texto
        String linea;

        try {
            // Lo inicializa para escribir datos por teclado
            key = new Scanner(System.in).useLocale(Locale.US);
            // Lo inicializa para escribir en ese fichero
            bw = new BufferedWriter(new FileWriter("src\\ficheros\\ejercicio4\\archivo.txt"));

            // Mientras la variable sea false sigue el bucle
            while (!termina) {
                // Introduce una línea de texto
                System.out.println("Introduzca texto: ");
                linea = key.nextLine();
                // Mientras no sea fin termina será false
                if (linea.equalsIgnoreCase("fin")) {
                    termina = true;
                }
                // Si siguen sin terminar se escribe la línea en el documento
                if (!termina) {
                    bw.write(linea);
                    bw.newLine();
                }
            } // Captura las excepciones
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se encuentra");
        } catch (IOException e) {
            System.out.println("Error, no se pudo crear el archivo.");

        } finally {
            // Finalmente comprueba que el bw no esté a null, que significa que se ha abierto en algún momento
            if (bw != null) {
                try {
                    // Se escribe el documento y se cierra todo
                    bw.flush();
                    bw.close();
                    key.close();

                } catch (IOException e) { // Captura la excepción
                    System.out.println("El archivo no se cerró correctamente");
                }
            }
        }
    }
}
