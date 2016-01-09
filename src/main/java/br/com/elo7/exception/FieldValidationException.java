package br.com.elo7.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.elo7.config.Error;

public class FieldValidationException extends RuntimeException {

    final List<Error> errors = new ArrayList<>();

    public FieldValidationException(String message, String field) {
        this.errors.add(new Error(message, field));
    }

    public List<Error> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
