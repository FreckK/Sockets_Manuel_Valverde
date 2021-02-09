package socket.client.chatclient_sockets.data;

import java.io.Serializable;

public class Solicitud implements Serializable {

    private String nombre;

    public Solicitud() {
        this(null);
    }

    public Solicitud(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "nombre=" + nombre + '}';
    }



}
