package excepciones.ejercicio2;

public class NegativeMinuteException extends Exception{
    @Override
    public String toString() {
        return "El valor de los minuto es negativo";
    }

    @Override
    public String getMessage() {
        return "El valor de los minutos es negativo";
    }
}
