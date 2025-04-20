package br.com.gusmaomatheus.api.model.conserto;

import br.com.gusmaomatheus.api.model.mecanico.MecanicoDTO;
import br.com.gusmaomatheus.api.model.veiculo.VeiculoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoDTO(
        @NotBlank(message = "O campo 'data_entrada' é obrigatório.")
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "O campo 'data_entrada' deve seguir o padrão: dd/mm/yyyy (Ex.: 20/04/2025)")
        String dataEntrada,
        @NotBlank(message = "O campo 'data_saida' é obrigatório.")
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "O campo 'data_saida' deve seguir o padrão: dd/mm/yyyy (Ex.: 20/04/2025)")
        String dataSaida,
        @NotNull
        @Valid
        MecanicoDTO dadosMecanico,
        @NotNull
        @Valid
        VeiculoDTO dadosVeiculo
) {}