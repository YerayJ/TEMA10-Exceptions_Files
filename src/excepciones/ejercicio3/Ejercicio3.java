package excepciones.ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        Fecha fecha = new Fecha(2, 9, 2004);
        try {
            fecha.setAnho(-3);

        } catch (ErrorYearException e) {
            System.out.println(e.getMessage());
        }

        try {
            fecha.setMes(-8);

        } catch (ErrorMonthException e) {
            System.out.println(e.getMessage());
        }

        try {
            fecha.setDia(-10);

        } catch (ErrorDayException e) {
            System.out.println(e.getMessage());
        }
    }
}
