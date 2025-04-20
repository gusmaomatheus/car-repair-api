package br.com.gusmaomatheus.api.model.dto;

public record DadosResumoConserto(
  String dataEntrada,
  String dataSaida,
  String mecanico,
  String marcaVeiculo,
  String modeloVeiculo
) {}