package excepciones.ejercicio2;

public class NegativeHourException extends Exception{
    @Override
    public String toString() {
        return "El valor de hora es negativo";
    }

    @Override
    public String getMessage() {
        return "El valor de hora es negativo";
    }
}
