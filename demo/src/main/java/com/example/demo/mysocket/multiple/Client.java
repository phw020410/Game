package com.example.demo.mysocket.multiple;

import java.net.Socket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    private Socket socket;
    private String userName;

    public Client(Socket socket) {
        this.socket = socket;
        this.userName = null;
    }
}
