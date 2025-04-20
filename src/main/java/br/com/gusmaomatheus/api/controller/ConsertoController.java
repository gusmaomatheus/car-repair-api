package br.com.gusmaomatheus.api.controller;

import br.com.gusmaomatheus.api.model.dto.DadosMecanico;
import br.com.gusmaomatheus.api.model.entity.Conserto;
import br.com.gusmaomatheus.api.model.dto.DadosConserto;
import br.com.gusmaomatheus.api.model.dto.DadosResumoConserto;
import br.com.gusmaomatheus.api.model.dto.DadosVeiculo;
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
import java.util.Optional;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosConserto> cadastrar(@RequestBody @Valid DadosConserto dados) {
        repository.save(new Conserto(dados));

        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosConserto>> listar(Pageable pageable) {

        // TODO: melhorar esse map...
        // ? talvez adicionar alguma lib para mapear a entidade para o dto (modelmapper, mapstruct, outra...)
        final Page<DadosConserto> consertos = repository.findAll(pageable)
                .map(conserto -> new DadosConserto(
                        conserto.getDataEntrada().toString(),
                        conserto.getDataSaida().toString(),
                        new DadosMecanico(conserto.getMecanico().getNome(), conserto.getMecanico().getAnosDeExperiencia()),
                        new DadosVeiculo(conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo(), conserto.getVeiculo().getCor(), conserto.getVeiculo().getAno())));

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

    @GetMapping("/{id}")
    public ResponseEntity<DadosConserto> buscarPorId(@PathVariable Long id) {
        final Optional<Conserto> consertoOpt = repository.findById(id);

        return consertoOpt
                .map(conserto -> ResponseEntity.status(HttpStatus.OK).body(new DadosConserto(
                        conserto.getDataEntrada().toString(),
                        conserto.getDataSaida().toString(),
                        new DadosMecanico(conserto.getMecanico().getNome(), conserto.getMecanico().getAnosDeExperiencia()),
                        new DadosVeiculo(conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo(), conserto.getVeiculo().getCor(), conserto.getVeiculo().getAno())
                )))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}