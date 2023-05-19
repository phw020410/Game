package com.example.demo.mysocket.multiple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

public class ServerMain {
    public static void main(String[] args) {
        try {
            ServerSocketFactory sslServerSocket = SSLServerSocketFactory.getDefault();
            
            ServerSocket serverSocket = sslServerSocket.createServerSocket(8080);

            while(true) {
                Socket socket = serverSocket.accept();
                Server server = new Server(socket);
                server.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
