package socket.client.chatclient_sockets.data;

import java.io.Serializable;

public class Message implements Serializable {
    private int idEmisor, idReceptor;
    private String message;
    private String horaEmision;

    public Message(int idEmisor, int idReceptor, String message, String horaEmision) {
        this.idEmisor = idEmisor;
        this.idReceptor = idReceptor;
        this.message = message;
        this.horaEmision = horaEmision;
    }

    public int getIdEmisor() {
        return idEmisor;
    }

    public Message setIdEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
        return this;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public Message setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getHoraEmision() {
        return horaEmision;
    }

    public Message setHoraEmision(String horaEmision) {
        this.horaEmision = horaEmision;
        return this;
    }
}
