package br.com.gusmaomatheus.api.model.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosAtualizacaoConserto(
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "O campo 'dataSaida' deve seguir o padrão: dd/mm/yyyy (Ex.: 20/04/2025)")
        String dataSaida,
        String nomeMecanico,
        @PositiveOrZero(message = "O campo 'anosDeExperiencia' deve ser um número igual ou maior que 0.")
        Integer anosDeExperiencia
) {}