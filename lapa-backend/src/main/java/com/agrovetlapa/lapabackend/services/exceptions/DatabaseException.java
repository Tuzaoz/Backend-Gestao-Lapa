package com.agrovetlapa.lapabackend.services.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg) {
        super(msg);
    }
}
