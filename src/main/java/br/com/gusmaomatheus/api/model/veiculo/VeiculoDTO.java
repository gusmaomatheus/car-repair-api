package br.com.gusmaomatheus.api.model.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank(message = "O campo 'marca' é obrigatório.")
        String marca,
        @NotBlank(message = "O campo 'modelo' é obrigatório.")
        String modelo,
        @NotBlank(message = "O campo 'ano' é obrigatório.")
        @Pattern(regexp = "^\\d{4}$")
        String ano) {}