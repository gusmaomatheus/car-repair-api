package br.com.gusmaomatheus.api.model.dto;

public record DadosResumoConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        String mecanico,
        String marcaVeiculo,
        String modeloVeiculo
) {}