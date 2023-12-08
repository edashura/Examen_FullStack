package com.examen.examen_fullstack.exception;

public class RessourceDoesntExist extends RuntimeException {
    public RessourceDoesntExist(String message) {
        super(message);
    }
}
