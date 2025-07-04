package br.com.gusmaomatheus.api.application.exception;

import br.com.gusmaomatheus.api.model.dto.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public final class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ExceptionResponse> handleEntityNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                404,
                "Objeto não encontrado no banco de dados!",
                LocalDateTime.now()));
    }

    @ExceptionHandler(TokenInvalidoException.class)
    private ResponseEntity<ExceptionResponse> handleTokenInvalido(TokenInvalidoException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse(
                403,
                exception.getMessage(),
                LocalDateTime.now()
        ));
    }
}