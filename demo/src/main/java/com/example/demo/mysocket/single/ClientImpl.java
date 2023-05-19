package com.example.demo.mysocket.single;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientImpl implements Client {
    private Socket client;

    public ClientImpl() {
        this.client = null;
    }

    @Override
    public void close() throws IOException {
        client.close();
    }

    @Override
    public void start(InetAddress ip, int port) throws IOException {
        client = new Socket(ip, port);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())));

        while(client.isConnected()) {
            String str = reader.readLine();
            writer.println(str + "\n");
            writer.flush();
            System.out.println("Send : " + str);
        }
    }
}
