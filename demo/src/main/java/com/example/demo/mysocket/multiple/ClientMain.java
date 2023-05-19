package com.example.demo.mysocket.multiple;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class ClientMain {
    public static void main(String[] args) {
        try {
            SocketFactory socketFactory = SSLSocketFactory.getDefault();
            Socket socket = socketFactory.createSocket(InetAddress.getLocalHost(), 8080);
            Client client = new Client(socket);

            ClientSender clientSender = new ClientSender(client);
            ClientReceiver clientReceiver = new ClientReceiver(client);

            clientSender.start();
            clientReceiver.start();

            clientSender.join();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
