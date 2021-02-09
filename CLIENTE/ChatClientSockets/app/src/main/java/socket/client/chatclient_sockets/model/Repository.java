package socket.client.chatclient_sockets.model;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import socket.client.chatclient_sockets.data.Message;
import socket.client.chatclient_sockets.data.Solicitud;
import socket.client.chatclient_sockets.listeners.ListeningListener;
import socket.client.chatclient_sockets.listeners.StartListener;

/**
 * El repositorio solo tendrá una instancia y será la misma para todas las vistas
 */
public class Repository {

    //Instancia unica
    private static Repository repositorio;

    //Contexto
    private Context context;

    //Atributos del Cliente Socket
    private Socket cliente;
    private ObjectInputStream flujoIn;
    private ObjectOutputStream flujoOut;

    //Eventos (Listeners)
    private ListeningListener listeningListener;
    private StartListener startListener;

    //################################## Constructor
    private Repository(Context context) {
        this.context = context;
        startClient("192.168.1.142", 5000);
    }

    //################################## Getter Instancia Singleton
    public static Repository getRepository(Context context) {
        if (repositorio == null) {
            repositorio = new Repository(context);
        }
        return repositorio;
    }

    //################################## Setters
    public void setListeningListener(ListeningListener listeningListener) {
        listeningListener = listeningListener;
    }

    public void setStartListener(StartListener startListener) {
        startListener = startListener;
    }


    /**
     * Inicializamos el socket cliente, los flujos IO y avisamos a la vista de que la conenxón está
     * inicializada donde mostrará el input para introducir el nombre
     * @param ip
     * @param puerto
     */
    public void startClient(String ip, int puerto){
        new Thread(){
            @Override
            public void run() {
                try {
                    Log.d("DEPURACION", "startClient()");
                    cliente = new Socket(ip, puerto);
                    Log.d("DEPURACION", "1");
                    flujoIn = new ObjectInputStream(cliente.getInputStream());
                    Log.d("DEPURACION", "2");
                    flujoOut = new ObjectOutputStream(cliente.getOutputStream());
                    Log.d("DEPURACION", "3");
                    startListener.isStart(false);
                    Log.d("DEPURACION", "4");
                } catch (IOException e) {
                    Log.d("DEPURACION", "5");
                    e.printStackTrace();
                }
            }
        }.start();
    }


    public void sendMessage(Message message) {
        new Thread(){
            @Override
            public void run() {
                Message text;
                try {
                    flujoOut.writeObject(message);
                    text = (Message) flujoIn.readObject();
                    listeningListener.listening(text);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }.start();

    }

    public void closeConnection() {
        try {
            flujoOut.writeBoolean(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendSolicitud(Solicitud solicitud) {
        try {
            flujoOut.writeObject(solicitud);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
