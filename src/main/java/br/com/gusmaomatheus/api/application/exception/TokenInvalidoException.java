package br.com.gusmaomatheus.api.application.exception;

public final class TokenInvalidoException extends RuntimeException {
    public TokenInvalidoException(String message) {
        super(message);
    }
}