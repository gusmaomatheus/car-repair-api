package br.com.gusmaomatheus.api.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        @NotBlank(message = "O campo 'dataEntrada' é obrigatório.")
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "O campo 'data_entrada' deve seguir o padrão: dd/mm/yyyy (Ex.: 20/04/2025)")
        String dataEntrada,
        @NotBlank(message = "O campo 'dataSaida' é obrigatório.")
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "O campo 'data_saida' deve seguir o padrão: dd/mm/yyyy (Ex.: 20/04/2025)")
        String dataSaida,
        @NotNull
        @Valid
        DadosMecanico dadosMecanico,
        @NotNull
        @Valid
        DadosVeiculo dadosVeiculo
) {}