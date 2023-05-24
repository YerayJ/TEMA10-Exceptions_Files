package ficheros.ejercicio2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int contador = 0, numeros = 0;

        try {
            Scanner key = new Scanner(new FileReader("src\\ficheros\\ejercicio2\\Enteros.txt"));

            while (key.hasNextInt()) {
                numeros += key.nextInt();
                contador++;
            }
            key.close();

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se encuentra");
        } finally {
            System.out.println("La media de los numeros es " + (double) numeros / contador);
            System.out.println("La suma es " + numeros);
        }

    }

}
