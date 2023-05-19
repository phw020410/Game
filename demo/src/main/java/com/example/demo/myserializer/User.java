package com.example.demo.myserializer;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private int age;

    @Override
    public String toString() {
        return String.format("name : %s, email : %s, age : %d", name, email, age);
    }
}
