package com.example.demo.myserializer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        User user = new User("Park Hyeon Woo", "phw020410@gmail.com", 22);
        System.out.println(user);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./demo/src/main/java/user");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));

            objectOutputStream.writeObject(user);
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("./demo/src/main/java/user");
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
            
            User clone = (User) objectInputStream.readObject();
            System.out.println(clone);
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
