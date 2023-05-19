package com.example.demo.mysocket;

import java.io.IOException;
import java.net.InetAddress;

import com.example.demo.mysocket.single.ClientImpl;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        // Single socket programming
        InetAddress ip = InetAddress.getLocalHost();

        ClientImpl client = new ClientImpl();
        client.start(ip, 8080);
    }
}
