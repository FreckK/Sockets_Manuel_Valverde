/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsocketserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 *
 * @author FreckK
 */
public class ChatSocketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hebra hilo = new Hebra();
        hilo.start();
    }
    
    public static class Hebra extends Thread {
        @Override
        public void run() {
            super.run();
            
        try {
            ServerSocket servidor = new ServerSocket(5000);
            while (true){
                Socket socket = servidor.accept();
                DataInputStream flujoEntrada = new DataInputStream(socket.getInputStream());
                String valor = flujoEntrada.readUTF();
                System.out.println("servidor recibe: "+valor);
                socket.close();
            }
        } catch (IOException ex) {
            System.err.println("ERROR " +ex.getLocalizedMessage());
        }
            
        }
    }
    
}
