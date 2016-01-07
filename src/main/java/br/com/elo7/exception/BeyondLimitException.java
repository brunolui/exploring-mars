package br.com.elo7.exception;

public class BeyondLimitException extends RuntimeException {

    public BeyondLimitException() {
        super("This action is leaving the space probe beyond the plateau limits");
    }

}
