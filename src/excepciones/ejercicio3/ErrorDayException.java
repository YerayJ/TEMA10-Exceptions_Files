package excepciones.ejercicio3;

public class ErrorDayException extends Exception {
    @Override
    public String toString() {
        return "El día no es correcto";
    }

    @Override
    public String getMessage() {
        return "El día no es correcto";
    }
}
