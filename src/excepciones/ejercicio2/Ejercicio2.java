package excepciones.ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
        Hora hora = new Hora(2, 9, 10);
        try {
            hora.setHora(-3);

        } catch (NegativeHourException e) {
            System.out.println(e.getMessage());
        }

        try {
            hora.setMin(-8);

        } catch (NegativeMinuteException e) {
            System.out.println(e.getMessage());
        }

        try {
            hora.setSeg(-10);

        } catch (NegativeSecondException e) {
            System.out.println(e.getMessage());
        }
    }
}
