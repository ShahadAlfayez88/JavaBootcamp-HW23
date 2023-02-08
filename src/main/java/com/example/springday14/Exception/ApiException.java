package com.example.springday14.Exception;

public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);
    }
}
