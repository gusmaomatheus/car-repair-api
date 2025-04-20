package br.com.gusmaomatheus.api.controller;

import br.com.gusmaomatheus.api.model.dto.DadosConserto;
import br.com.gusmaomatheus.api.model.dto.DadosResumoConserto;
import br.com.gusmaomatheus.api.model.entity.Conserto;
import br.com.gusmaomatheus.api.repository.ConsertoRepository;
import br.com.gusmaomatheus.api.utils.mapper.conserto.ConsertoMapper;
import br.com.gusmaomatheus.api.utils.mapper.conserto.ConsertoMapperImpl;
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

    private ConsertoMapper mapper = new ConsertoMapperImpl();

    @PostMapping
    @Transactional
    public ResponseEntity<DadosConserto> cadastrar(@RequestBody @Valid DadosConserto dados) {
        repository.save(new Conserto(dados));

        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosConserto>> listar(Pageable pageable) {
        final Page<DadosConserto> consertos = repository.findAll(pageable)
                .map(conserto -> mapper.toDadosConserto(conserto).get());

        return ResponseEntity.status(HttpStatus.OK).body(consertos);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<DadosResumoConserto>> listarResumo() {
        final List<DadosResumoConserto> consertos = repository.findAll()
                .stream()
                .map(conserto -> mapper.toDadosResumoConserto(conserto).get()).toList();

        return ResponseEntity.status(HttpStatus.OK).body(consertos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosConserto> buscarPorId(@PathVariable Long id) {
        final Optional<Conserto> consertoOpt = repository.findById(id);

        return consertoOpt
                .map(conserto -> ResponseEntity.ok(mapper.toDadosConserto(conserto).get()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}