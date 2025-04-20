package br.com.gusmaomatheus.api.utils.mapper.veiculo;

import br.com.gusmaomatheus.api.model.dto.DadosVeiculo;
import br.com.gusmaomatheus.api.model.entity.Veiculo;

import java.util.Optional;

public interface VeiculoMapper {
    Optional<DadosVeiculo> toDadosVeiculo(Veiculo veiculo);
}