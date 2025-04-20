package br.com.gusmaomatheus.api.utils.mapper.conserto;

import br.com.gusmaomatheus.api.model.dto.DadosConserto;
import br.com.gusmaomatheus.api.model.dto.DadosResumoConserto;
import br.com.gusmaomatheus.api.model.entity.Conserto;
import br.com.gusmaomatheus.api.utils.mapper.mecanico.MecanicoMapper;
import br.com.gusmaomatheus.api.utils.mapper.mecanico.MecanicoMapperImpl;
import br.com.gusmaomatheus.api.utils.mapper.veiculo.VeiculoMapper;
import br.com.gusmaomatheus.api.utils.mapper.veiculo.VeiculoMapperImpl;

import java.util.Objects;
import java.util.Optional;


public final class ConsertoMapperImpl implements ConsertoMapper {

    private final MecanicoMapper mecanicoMapper = new MecanicoMapperImpl();
    private final VeiculoMapper veiculoMapper = new VeiculoMapperImpl();

    @Override
    public Optional<DadosConserto> toDadosConserto(Conserto conserto) {
        if (Objects.isNull(conserto)) {
            return Optional.empty();
        }

        return Optional.of(new DadosConserto(
                conserto.getDataEntrada().toString(),
                conserto.getDataSaida().toString(),
                mecanicoMapper.toDadosMecanico(conserto.getMecanico()).get(),
                veiculoMapper.toDadosVeiculo(conserto.getVeiculo()).get()
        ));
    }

    @Override
    public Optional<DadosResumoConserto> toDadosResumoConserto(Conserto conserto) {
        if (Objects.isNull(conserto)) {
            return Optional.empty();
        }

        return Optional.of(new DadosResumoConserto(
                conserto.getDataEntrada().toString(),
                conserto.getDataSaida().toString(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
        ));
    }
}