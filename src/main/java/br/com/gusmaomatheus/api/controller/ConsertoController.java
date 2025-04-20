package br.com.gusmaomatheus.api.controller;

import br.com.gusmaomatheus.api.model.conserto.Conserto;
import br.com.gusmaomatheus.api.model.conserto.ConsertoDTO;
import br.com.gusmaomatheus.api.model.conserto.DadosResumoConserto;
import br.com.gusmaomatheus.api.model.mecanico.MecanicoDTO;
import br.com.gusmaomatheus.api.model.veiculo.VeiculoDTO;
import br.com.gusmaomatheus.api.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsertoDTO> cadastrar(@RequestBody @Valid ConsertoDTO dados) {
        repository.save(new Conserto(dados));

        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
    }

    @GetMapping
    public ResponseEntity<Page<ConsertoDTO>> listar(Pageable pageable) {

        // TODO: melhorar esse map...
        // ? talvez adicionar alguma lib para mapear a entidade para o dto (modelmapper, mapstruct, outra...)
        final Page<ConsertoDTO> consertos = repository.findAll(pageable)
                .map(conserto -> new ConsertoDTO(
                        conserto.getDataEntrada().toString(),
                        conserto.getDataSaida().toString(),
                        new MecanicoDTO(conserto.getMecanico().getNome(), conserto.getMecanico().getAnosDeExperiencia()),
                        new VeiculoDTO(conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo(), conserto.getVeiculo().getCor(), conserto.getVeiculo().getAno())));

        return ResponseEntity.status(HttpStatus.OK).body(consertos);
    }

    // TODO: pensar em algum nome melhor para o endpoint (existe?)
    @GetMapping("/resumo")
    public ResponseEntity<List<DadosResumoConserto>> listarResumo() {
        // TODO: não fazer a conversão desse jeito bla bla bla
        final List<DadosResumoConserto> consertos = repository.findAll()
                .stream()
                .map(conserto -> new DadosResumoConserto(
                        conserto.getDataEntrada().toString(),
                        conserto.getDataSaida().toString(),
                        conserto.getMecanico().getNome(),
                        conserto.getVeiculo().getMarca(),
                        conserto.getVeiculo().getModelo()
                )).toList();

        return ResponseEntity.status(HttpStatus.OK).body(consertos);
    }
}