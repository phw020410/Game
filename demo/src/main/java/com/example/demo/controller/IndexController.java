package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @GetMapping("index")
    public String index(HttpServletResponse httpServletResponse) {
        System.out.println(httpServletResponse.getStatus());
        return "index";
    }
}
