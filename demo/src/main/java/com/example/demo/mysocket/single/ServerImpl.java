package com.example.demo.mysocket.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerImpl implements Server {
    private ServerSocket socket;
    private Socket client;

    public ServerImpl() {
        this.socket = null;
        this.client = null;
    }

    @Override
    public void close() throws IOException {
        socket.close();
        client.close();
    }

    @Override
    public void start(int port) throws IOException {
        socket = new ServerSocket(port);
        client = socket.accept();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

        while(socket.isBound()) {
            String str = reader.readLine();
            System.out.println(str);
        }
    }
}
