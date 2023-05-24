package ficheros.ejercicio3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        // Atributos para guardar la edad y la estatura
        int edad = 0;
        double estatura = 0;
        // Creación de lista para guardar nombres
        ArrayList<String> nombres = new ArrayList<>();

        try {
            // Creación de escáner
            Scanner key = new Scanner(new FileReader("src\\ficheros\\ejercicio3\\Alumnos.txt")).useLocale(Locale.US);
            // Mientras encuentre algo en la siguiente posición
            while (key.hasNext()) {
                // Añade nombre con un key next
                nombres.add(key.next());
                // Suma la edad
                edad += key.nextInt();
                // Suma la estatura
                estatura += key.nextDouble();

            }
            // Se cierra el escáner
            key.close();
        // Excepción por si el archivo no se encuentra
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se encuentra");
        } finally {
            // Muestra la media dividiendo por el tamaño de la lista
            System.out.println("La media de los numeros es " +  estatura / nombres.size());
            System.out.println("La media de los numeros es " + (double) edad / nombres.size());
        }

    }
}
