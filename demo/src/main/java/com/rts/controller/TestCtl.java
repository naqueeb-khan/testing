package com.rts.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TestCtl {

    @GetMapping("/get")
    public String getMethodName() {
        return "Hello";
    }
    

}
