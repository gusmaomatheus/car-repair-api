package br.com.gusmaomatheus.api.utils.mapper.veiculo;

import br.com.gusmaomatheus.api.model.dto.DadosVeiculo;
import br.com.gusmaomatheus.api.model.entity.Veiculo;

import java.util.Objects;
import java.util.Optional;

public final class VeiculoMapperImpl implements VeiculoMapper {
    @Override
    public Optional<DadosVeiculo> toDadosVeiculo(Veiculo veiculo) {
        if (Objects.isNull(veiculo)) {
            return Optional.empty();
        }

        return Optional.of(new DadosVeiculo(veiculo.getMarca(), veiculo.getModelo(), veiculo.getCor(), veiculo.getAno()));
    }
}