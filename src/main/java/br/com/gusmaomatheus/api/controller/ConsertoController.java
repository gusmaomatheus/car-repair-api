package br.com.gusmaomatheus.api.controller;

import br.com.gusmaomatheus.api.model.conserto.Conserto;
import br.com.gusmaomatheus.api.model.conserto.ConsertoDTO;
import br.com.gusmaomatheus.api.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsertoDTO> cadastrar(@RequestBody ConsertoDTO dados) {
        repository.save(new Conserto(dados));

        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
    }
}