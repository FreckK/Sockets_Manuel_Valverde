package socket.client.chatclient_sockets.view;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import socket.client.chatclient_sockets.data.Diligencia;
import socket.client.chatclient_sockets.data.Solicitud;
import socket.client.chatclient_sockets.listeners.StartListener;
import socket.client.chatclient_sockets.model.Repository;

public class NameViewModel {

    private Repository repository;
    private MutableLiveData<Diligencia> liveDiligencia;

    public NameViewModel(Context context, StartListener startListener){
        repository = Repository.getRepository(context);
        repository.setStartListener(startListener);
        liveDiligencia = new MutableLiveData<>();
        liveDiligencia.setValue(new Diligencia());
    }

    public void sendSolicitud(String text){
        Solicitud solicitud = new Solicitud();
        solicitud.setNombre(text);
        MutableLiveData<Solicitud> liveSolicitud = new MutableLiveData<>();
        liveSolicitud.setValue(solicitud);
        repository.sendSolicitud(solicitud);
    }

    public MutableLiveData<Diligencia> getDiligencia(){
        return this.liveDiligencia;
    }


}
