package com.example.demo.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mybatis.dto.User;
import com.example.demo.mybatis.service.UserService;

@RestController
public class TestPrint {
    @Autowired
    UserService userService;

    @GetMapping("test")
    public List<User> test() {
        return userService.getAllUser();
    }
}
