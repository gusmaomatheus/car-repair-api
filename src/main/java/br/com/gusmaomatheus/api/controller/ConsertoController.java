package br.com.gusmaomatheus.api.controller;

import br.com.gusmaomatheus.api.model.dto.DadosAtualizacaoConserto;
import br.com.gusmaomatheus.api.model.dto.DadosConserto;
import br.com.gusmaomatheus.api.model.dto.DadosResumoConserto;
import br.com.gusmaomatheus.api.model.entity.Conserto;
import br.com.gusmaomatheus.api.repository.ConsertoRepository;
import br.com.gusmaomatheus.api.utils.mapper.conserto.ConsertoMapper;
import br.com.gusmaomatheus.api.utils.mapper.conserto.ConsertoMapperImpl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    private final ConsertoMapper mapper = new ConsertoMapperImpl();

    @PostMapping
    @Transactional
    public ResponseEntity<DadosConserto> cadastrar(@RequestBody @Valid DadosConserto dados,
                                                   UriComponentsBuilder uriBuilder) {

        final Conserto conserto = new Conserto(dados);
        final URI uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();

        repository.save(conserto);

        return ResponseEntity.created(uri).body(mapper.toDadosConserto(conserto).orElse(null));
    }

    @GetMapping
    public ResponseEntity<Page<DadosConserto>> listar(Pageable pageable) {
        final Page<DadosConserto> consertos = repository.findAll(pageable)
                .map(conserto -> mapper.toDadosConserto(conserto).get());

        return ResponseEntity.ok(consertos);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<DadosResumoConserto>> listarResumo() {
        final List<DadosResumoConserto> consertos = repository.findAllByAtivoTrue()
                .stream()
                .map(conserto -> mapper.toDadosResumoConserto(conserto).get()).toList();

        return ResponseEntity.ok(consertos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosConserto> buscarPorId(@PathVariable Long id) {
        final Optional<Conserto> consertoOpt = repository.findById(id);

        if (consertoOpt.isEmpty()) {
            throw new EntityNotFoundException();
        }

        final Conserto conserto = consertoOpt.get();

        return ResponseEntity.ok().body(mapper.toDadosConserto(conserto).get());
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity<DadosConserto> inativar(@PathVariable Long id) {
        final Optional<Conserto> consertoOpt = repository.findById(id);

        if (consertoOpt.isEmpty()) {
            throw new EntityNotFoundException();
        }

        final Conserto conserto = consertoOpt.get();
        conserto.inativar();

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosConserto> atualizarParcialmente(@RequestBody @Valid DadosAtualizacaoConserto dados,
                                                               @PathVariable Long id) {
        final Optional<Conserto> consertoOpt = repository.findById(id);

        if (consertoOpt.isEmpty()) {
            throw new EntityNotFoundException();
        }

        final Conserto conserto = consertoOpt.get();
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(mapper.toDadosConserto(conserto).get());
    }
}