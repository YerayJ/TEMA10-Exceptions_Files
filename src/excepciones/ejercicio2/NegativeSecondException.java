package excepciones.ejercicio2;

public class NegativeSecondException extends Exception{
    @Override
    public String toString() {
        return "El valor del segundo es negativo";
    }

    @Override
    public String getMessage() {
        return "El valor del segundo es negativo";
    }
}
