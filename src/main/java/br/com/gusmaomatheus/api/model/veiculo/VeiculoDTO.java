package br.com.gusmaomatheus.api.model.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record VeiculoDTO(
        @NotBlank(message = "O campo 'marca' é obrigatório.")
        String marca,
        @NotBlank(message = "O campo 'modelo' é obrigatório.")
        String modelo,
        @NotBlank(message = "O campo 'ano' é obrigatório.")
        @Size(min = 4, max = 4, message = "O campo 'ano' deve possuir 4 dígitos (Ex.: 2025).")
        String ano) {}