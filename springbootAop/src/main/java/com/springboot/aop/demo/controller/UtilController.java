package com.springboot.aop.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilController {
    @RequestMapping("/unit")
    public Object Util(){
        return "Util Controller";
    }
    @RequestMapping("doError")
    public Object someWrong(){
        return "1/0";
    }
}
