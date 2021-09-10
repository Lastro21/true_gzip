package com.example.simple_artefact_for_war.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/hello")
    public String helloStringReturn() {
        return "Hello, World !!!";
    }

}
