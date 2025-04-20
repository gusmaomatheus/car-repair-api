package br.com.gusmaomatheus.api.model.conserto;

public record DadosResumoConserto(
  String dataEntrada,
  String dataSaida,
  String mecanico,
  String marcaVeiculo,
  String modeloVeiculo
) {}