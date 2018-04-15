package com.example.demo;

import java.math.BigDecimal;

public class TestDecimals {
    public static void main(String[] args){
        System.out.println(2.0-1.1);
        BigDecimal value1 = new BigDecimal("2.0");
        BigDecimal value2 = new BigDecimal("1.1");
        System.out.println(value1.subtract(value2));
    }
}
