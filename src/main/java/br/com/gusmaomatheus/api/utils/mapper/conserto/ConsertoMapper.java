package br.com.gusmaomatheus.api.utils.mapper.conserto;

import br.com.gusmaomatheus.api.model.dto.DadosConserto;
import br.com.gusmaomatheus.api.model.dto.DadosResumoConserto;
import br.com.gusmaomatheus.api.model.entity.Conserto;

import java.util.Optional;

public interface ConsertoMapper {
    Optional<DadosConserto> toDadosConserto(Conserto conserto);
    Optional<DadosResumoConserto> toDadosResumoConserto(Conserto conserto);
}