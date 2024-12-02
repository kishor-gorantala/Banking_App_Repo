package com.example.demo.exceptionHandler;

import java.util.Date;

public class ErrorResponseEntity {

    private Date timestamp;
    private String message;
    private String details;

    public ErrorResponseEntity(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date timestamp() {
        return timestamp;
    }

    public String message() {
        return message;
    }

    public String details() {
        return details;
    }
}
