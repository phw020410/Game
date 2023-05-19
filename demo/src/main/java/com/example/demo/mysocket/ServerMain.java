package com.example.demo.mysocket;

import java.io.IOException;

import com.example.demo.mysocket.single.ServerImpl;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        // Single socket programming
        ServerImpl server = new ServerImpl();
        server.start(8080);
    }
}