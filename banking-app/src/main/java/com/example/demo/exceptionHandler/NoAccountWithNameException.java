package com.example.demo.exceptionHandler;

public class NoAccountWithNameException extends RuntimeException{


    public  NoAccountWithNameException (String msg){
        super(msg);

    }



}
