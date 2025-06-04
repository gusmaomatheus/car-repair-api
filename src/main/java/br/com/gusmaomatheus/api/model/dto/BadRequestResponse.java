package br.com.gusmaomatheus.api.model.dto;

import org.springframework.validation.FieldError;

public record BadRequestResponse(String field, String message) {
    public BadRequestResponse(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}