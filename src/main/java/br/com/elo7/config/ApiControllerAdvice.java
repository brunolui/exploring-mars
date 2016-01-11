package br.com.elo7.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.com.elo7.exception.FieldValidationException;

@ControllerAdvice
public class ApiControllerAdvice {

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    ResponseEntity<ErrorResult> customHandler(Exception ex) {
        return new ResponseEntity<>(
            new ErrorResult(new Error(ex.getLocalizedMessage())),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResult validationExceptionHandler(MethodArgumentNotValidException ex) {
            List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        return new ErrorResult(
            errors.stream().map(Error::new).collect(Collectors.toList())
        );
    }

    @ResponseBody
    @ExceptionHandler(FieldValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResult fieldValidationExceptionHandler(FieldValidationException ex) {
        return new ErrorResult(ex.getErrors());
    }

}
