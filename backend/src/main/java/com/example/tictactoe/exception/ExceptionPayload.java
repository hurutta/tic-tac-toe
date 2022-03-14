package com.example.tictactoe.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionPayload 
{
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ExceptionPayload(String message, HttpStatus status, LocalDateTime timestamp)
    {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
