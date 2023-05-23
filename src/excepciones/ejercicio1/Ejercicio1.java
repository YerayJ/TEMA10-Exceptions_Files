package excepciones.ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

    static Scanner key = new Scanner(System.in);

    public static double readDouble(Scanner key) {
        double dato = 0;

        try {
            System.out.println("Introduzca el valor: ");
            dato = key.nextDouble();
            key.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("El valor introducido no es de tipo Double");
        }

        return dato;
    }

    public static int readInt(Scanner key) {
        int dato = 0;

        try {
            System.out.println("Introduzca el valor: ");
            dato = key.nextInt();
            key.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("El valor introducido no es de tipo Integer");
        }

        return dato;
    }
}
