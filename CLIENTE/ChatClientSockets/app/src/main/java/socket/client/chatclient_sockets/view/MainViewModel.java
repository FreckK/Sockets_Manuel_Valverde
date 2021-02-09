package socket.client.chatclient_sockets.view;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import socket.client.chatclient_sockets.listeners.ListeningListener;
import socket.client.chatclient_sockets.data.Message;
import socket.client.chatclient_sockets.model.Repository;

public class MainViewModel {

    private Repository repository;

    public MainViewModel(Context context, ListeningListener listener){
        this.repository = Repository.getRepository(context);
        repository.setListeningListener(listener);
    }

    public void sendMessage(Message message){
        repository.sendMessage(message);
    }

    public void closeConnection() {
        repository.closeConnection();
    }
/*
    public MutableLiveData<Message> getLiveMessage(){
        return repository.getLiveMessage();
    }*/
}
