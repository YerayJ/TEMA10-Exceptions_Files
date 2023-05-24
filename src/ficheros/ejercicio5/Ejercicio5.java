package ficheros.ejercicio5;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        // Atributos para guardar los datos
        int edad;
        String nombre;

        // Creación de escáner
        Scanner key = null;

        // Declara el bw para escribir por teclado
        BufferedWriter bw = null;

        try {
            // Lo inicializa para escribir datos por teclado
            key = new Scanner(System.in).useLocale(Locale.US);
            // Con el parámetro true comprueba directamente si el archivo está creado y escribir debajo, si no lo crea
            bw = new BufferedWriter(new FileWriter("src\\ficheros\\ejercicio5\\archivo.txt", true));

            // Introduce una línea de texto
            System.out.println("Introduzca su nombre: ");
            nombre = key.next();
            System.out.println("Introduzca su edad: ");
            edad = key.nextInt();

            bw.write(nombre + " " + edad);
            bw.newLine();


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
