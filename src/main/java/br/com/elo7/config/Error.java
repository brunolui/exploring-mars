package br.com.elo7.config;

import org.springframework.validation.FieldError;

public class Error {

    private String field;
    private String message;

    public Error(FieldError error) {
        this.field = error.getField();
        this.message = error.getDefaultMessage();
    }

    public Error(String message) {
        this.message = message;
    }

    public Error(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
