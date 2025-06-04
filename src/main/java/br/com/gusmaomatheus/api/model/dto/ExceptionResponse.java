package br.com.gusmaomatheus.api.model.dto;

import java.time.LocalDateTime;

public record ExceptionResponse(int code, String message, LocalDateTime timestamp) { }