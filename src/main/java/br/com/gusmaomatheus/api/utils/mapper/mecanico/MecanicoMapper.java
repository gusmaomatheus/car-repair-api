package br.com.gusmaomatheus.api.utils.mapper.mecanico;

import br.com.gusmaomatheus.api.model.dto.DadosMecanico;
import br.com.gusmaomatheus.api.model.entity.Mecanico;

import java.util.Optional;

public interface MecanicoMapper {
    Optional<DadosMecanico> toDadosMecanico(Mecanico mecanico);
}