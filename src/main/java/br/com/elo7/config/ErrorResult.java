package br.com.elo7.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ErrorResult {

    List<Error> errors = new ArrayList<>();

    public ErrorResult(List<Error> errors) {
        this.errors.addAll(errors);
    }

    public ErrorResult(Error error) {
        this.errors.add(error);
    }

    public List<Error> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
