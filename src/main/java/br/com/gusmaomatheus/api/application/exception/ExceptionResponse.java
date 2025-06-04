package br.com.gusmaomatheus.api.application.exception;

import java.time.LocalDateTime;

public record ExceptionResponse(int code, String message, LocalDateTime timestamp) { }