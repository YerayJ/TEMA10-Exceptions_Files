package excepciones.ejercicio2;

public class Hora {
    /**
     * Variable que contiene la hora
     */
    int hora;
    /**
     * Variable que contiene los minutos
     */
    int min;
    /**
     * Variable que contiene los segundos
     */
    int seg;

    /**
     * Constructor por defecto
     */
    Hora() {
        // Constructor por defecto
    }

    /**
     * Constructor con parámetros
     *
     * @param hora Variable que contiene la hora
     * @param min  Variable que contiene los minutos
     * @param seg  Variable que contiene los segundos
     */
    Hora(int hora, int min, int seg) {
        this.hora = hora;
        this.min = min;
        this.seg = seg;
    }

    /**
     * Setter
     *
     * @param hora Variable que contiene la hora
     */
    public void setHora(int hora) throws NegativeHourException {
        if (hora < 0) { // Comprueba que la hora es negativa
            throw new NegativeHourException();
        } else { // Asigna la hora
            this.hora = hora;
        }
    }

    /**
     * Getter
     *
     * @return Devuelve la hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * Setter
     *
     * @param min Variable que contiene los min
     */
    public void setMin(int min) throws NegativeMinuteException {
        if (min < 0) { // Comprueba que los minutos son negativa
            throw new NegativeMinuteException();
        } else { // Asigna los minutos
            this.min = min;
        }
    }

    /**
     * Getter
     *
     * @return Devuelve los minutos
     */
    public int getMin() {
        return min;
    }

    /**
     * Setter
     *
     * @param seg Variable que contiene los segundos
     */
    public void setSeg(int seg) throws NegativeSecondException{
        if (seg < 0) { // Comprueba que los segundos es negativa
            throw new NegativeSecondException();
        } else { // Asigna los segundos
            this.seg = seg;
        }
    }

    /**
     * Getter
     *
     * @return Devuelve los segundos
     */
    public int getSeg() {
        return seg;
    }

    /**
     * Método que incrementa la hora
     *
     * @param incrementa Parámetro que pasa el usuario en segundos
     */
    public void incrementaSegundo(int incrementa) {
        // Se añade la cantidad pasada por parámetros al atributo seg
        seg += incrementa;
        // Comprueba si los segundos son mayor-igual a 60
        if (seg >= 60) {
            // Añade un minuto
            min++;
            // Y le resta 60 a lo segundos
            seg -= 60;
        } else if (min >= 60) { // Comprueba si los minutos son mayor-igual a 60
            hora++;
            min -= 60;
        } else if (hora > 23) { // Comprueba si la hora es mayor a 23
            // Inicia la hora a 0
            hora = 0;
        }
    }

}

