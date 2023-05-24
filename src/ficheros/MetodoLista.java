package ficheros;

import ficheros.ejercicio7.Ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class MetodoLista {

    public static HashMap<String, Long> leerFichero() {

        HashMap<String, Long> productos = new HashMap<>();

        String nombre;
        long precio;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(Ejercicio7.DIR));

            String linea = br.readLine();
            String[] datos;

            while (linea != null) {
                datos = linea.split(" ");

                nombre = datos[0];
                precio = Long.parseLong(datos[1]); // Devuelve double, tipo primitivo

                productos.put(nombre, precio);

                linea = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR al abrir el fichero");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR al leer el fichero");
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("ERROR al cerrar el búfer");
                    System.out.println(e.getMessage());
                }
            }
        }

        return productos;

    }

    public static void escribirFichero(HashMap<String, Double> productos) {
        BufferedWriter bw = null;
        String nombre;
        double precio;
        try {
            bw = new BufferedWriter(new FileWriter("src\\ejercicio5\\productos.txt"));

            for(String nom : productos.keySet()) {
                nombre = nom;
                precio = productos.get(nom);

                bw.write(nombre + " " + precio);
                bw.newLine();
            }

            bw.flush();

        } catch (IOException e) {
            System.out.println("Error al abrir el fichero");
            System.out.println(e.getMessage());
        } finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el búfer");
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}