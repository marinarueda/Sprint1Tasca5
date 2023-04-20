package exercici5;

import java.io.Serializable;

public class Serializacion implements Serializable {
    int valor;
    String mensaje;

    public Serializacion(int valor, String mensaje) {
        this.valor = valor;
        this.mensaje = mensaje;
    }

}
