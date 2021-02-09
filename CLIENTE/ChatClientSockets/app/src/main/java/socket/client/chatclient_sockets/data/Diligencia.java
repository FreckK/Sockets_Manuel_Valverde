package socket.client.chatclient_sockets.data;

public class Diligencia {

    private boolean aprovada;
    private String motivo;

    public Diligencia() {
        this(false, null);
    }

    public Diligencia(boolean aprovada, String motivo) {
        this.aprovada = aprovada;
        this.motivo = motivo;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Diligencia{" + "aprovada=" + aprovada + ", motivo=" + motivo + '}';
    }


}