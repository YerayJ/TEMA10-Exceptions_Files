package excepciones.ejercicio3;

public class ErrorYearException extends Exception {
    @Override
    public String toString() {
        return "El año no es correcto";
    }

    @Override
    public String getMessage() {
        return "El año no es correcto";
    }
}
