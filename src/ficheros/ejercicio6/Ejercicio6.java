package ficheros.ejercicio6;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        // Creación de escáner
        Scanner key = null;

        // Declara el bw para escribir por teclado
        BufferedWriter bw = null;

        // Creación de una lista para guardar los números
        ArrayList<Integer> numeros = new ArrayList<>();

        try {
            // Con el parámetro true comprueba directamente si el archivo está creado y escribir debajo, si no lo crea
            bw = new BufferedWriter(new FileWriter("src\\ficheros\\ejercicio6\\numerosOrdenados.txt", true));

            // Creación de escáner para leer datos
            key = new Scanner(new FileReader("src\\ficheros\\ejercicio6\\numeros.txt"));

            // Recorre el archivo mientras haya números enteros
            while (key.hasNextInt()){
                // Añade los números a la lista
                numeros.add(key.nextInt());
            }
            // Ordena el array
            numeros.sort(null);

            // Inserta en el nuevo archivo los datos
            for (int numero : numeros) {
                bw.write(String.valueOf(numero));
                bw.newLine();

            }

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

                } catch (IOException e) { // Captura la excepción
                    System.out.println("El archivo no se cerró correctamente");
                }
            }
            key.close();
        }
    }
}
