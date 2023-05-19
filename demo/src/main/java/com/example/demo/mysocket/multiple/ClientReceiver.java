package com.example.demo.mysocket.multiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiver extends Thread {
    private Client client;
    private Socket socket;

    public ClientReceiver(Client client) {
        this.client = client;
        this.socket = this.client.getSocket();
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            while(true) {
                String str = reader.readLine();
                if(!str.split(" : ")[0].equals(this.client.getUserName()) || (str != null)) {
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}
