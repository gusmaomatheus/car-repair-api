package br.com.gusmaomatheus.api.model.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAuth(
        @NotBlank
        String login,
        @NotBlank
        String senha
) {
}