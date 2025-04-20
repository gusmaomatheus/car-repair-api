package br.com.gusmaomatheus.api.controller;

import br.com.gusmaomatheus.api.model.conserto.Conserto;
import br.com.gusmaomatheus.api.model.conserto.ConsertoDTO;
import br.com.gusmaomatheus.api.model.mecanico.MecanicoDTO;
import br.com.gusmaomatheus.api.model.veiculo.VeiculoDTO;
import br.com.gusmaomatheus.api.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<ConsertoDTO>> listar() {

        // TODO: melhorar esse map...
        // ? talvez adicionar alguma lib para mapear a entidade para o dto (modelmapper, mapstruct, outra...)
        final List<ConsertoDTO> consertos = repository.findAll()
                .stream()
                .map(conserto -> new ConsertoDTO(
                        conserto.getDataEntrada().toString(),
                        conserto.getDataSaida().toString(),
                        new MecanicoDTO(conserto.getMecanico().getNome(), conserto.getMecanico().getAnosDeExperiencia()),
                        new VeiculoDTO(conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo(), conserto.getVeiculo().getAno())))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(consertos);
    }
}