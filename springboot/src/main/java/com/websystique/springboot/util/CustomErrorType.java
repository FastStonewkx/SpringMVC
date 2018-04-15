package com.websystique.springboot.util;

public class CustomErrorType{
    private String errorMessgae;
    public CustomErrorType(String errorMessgae){
        this.errorMessgae = errorMessgae;
    }
    public String getErrorMessgae(){
        return errorMessgae;
    }
}

