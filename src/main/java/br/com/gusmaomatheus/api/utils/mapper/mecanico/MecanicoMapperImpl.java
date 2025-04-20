package br.com.gusmaomatheus.api.utils.mapper.mecanico;

import br.com.gusmaomatheus.api.model.dto.DadosMecanico;
import br.com.gusmaomatheus.api.model.entity.Mecanico;

import java.util.Objects;
import java.util.Optional;

public final class MecanicoMapperImpl implements MecanicoMapper {

    @Override
    public Optional<DadosMecanico> toDadosMecanico(Mecanico mecanico) {
        if (Objects.isNull(mecanico)) {
            return Optional.empty();
        }

        return Optional.of(new DadosMecanico(mecanico.getNome(), mecanico.getAnosDeExperiencia()));
    }
}