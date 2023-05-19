package com.example.demo.mysocket.multiple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    public static ArrayList<Client> users = new ArrayList<>();
    private Client client;
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String userName = reader.readLine();

            this.client = new Client(this.socket, userName);
            users.add(this.client);
            System.out.println(socket.getInetAddress() + "/ " + userName + " is connected!!"); // xxx.xxx.xxx / #userName is connected!!

            while(socket.isBound()) {
                String str = reader.readLine();
                System.out.println(userName + " : " + str);

                for (int i = 0; i < users.size(); i++) {
                    PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(users.get(i).getSocket().getOutputStream())));
                    writer.println(userName + " : " + str);
                    writer.flush();
                }

                if(socket.isClosed() || str.equals("/quit")) {
                    reader.close();
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println(client.getUserName() + " is disconnected!!");
            users.remove(this.client);
            System.out.println("Left User : " + users.size());
        }
    }
}
