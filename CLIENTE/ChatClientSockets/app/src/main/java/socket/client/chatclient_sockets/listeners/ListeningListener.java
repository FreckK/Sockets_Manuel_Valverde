package socket.client.chatclient_sockets.listeners;

import socket.client.chatclient_sockets.data.Message;

public interface ListeningListener {
    void listening(Message response);
}
