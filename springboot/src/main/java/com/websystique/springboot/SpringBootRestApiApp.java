package com.websystique.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.websystique.springboot"}) //same as @configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootRestApiApp {
    public static void main(String[] args){
        SpringApplication.run(SpringBootRestApiApp.class,args);
    }
}