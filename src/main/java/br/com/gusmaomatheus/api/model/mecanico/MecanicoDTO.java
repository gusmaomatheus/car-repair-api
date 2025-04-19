package br.com.gusmaomatheus.api.model.mecanico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record MecanicoDTO(
        @NotBlank(message = "O campo 'nome' é obrigatório")
        String nome,
        @NotNull(message = "O campo 'anos_de_experiencia' é obrigatório")
        @PositiveOrZero(message = "O campo 'anos_de_experiencia' deve ser igual ou maior do que zero.")
        Integer anosDeExperiencia
) {}