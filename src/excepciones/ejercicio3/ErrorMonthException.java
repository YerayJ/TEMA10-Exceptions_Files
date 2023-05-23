package excepciones.ejercicio3;

public class ErrorMonthException extends Exception {
    @Override
    public String toString() {
        return "El mes no es correcto";
    }

    @Override
    public String getMessage() {
        return "El mes no es correcto";
    }
}
