package com.example.demo.mysocket.multiple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSender extends Thread {
    private Client client;
    private Socket socket;
    
    public ClientSender(Client client) {
        this.client = client;
        this.socket = client.getSocket();
    }

    @Override
    public void run() {
        try {
            System.out.print("Set your name : ");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

            client.setUserName(in.readLine());

            writer.println(client.getUserName());
            writer.flush();

            System.out.println("Your name is " + client.getUserName());

            while(socket.isConnected()) {
                // System.out.print(": ");
                String msg = in.readLine();
                writer.println(msg);
                writer.flush();

                System.out.println("Send : " + msg);

                if(socket.isClosed() || msg.equals("/quit")) {
                    in.close();
                    writer.close();
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
