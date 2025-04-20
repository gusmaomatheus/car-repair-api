package br.com.gusmaomatheus.api.model.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotBlank(message = "O campo 'nome' é obrigatório")
        String nome,
        Integer anosDeExperiencia
) {}