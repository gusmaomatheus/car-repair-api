package br.com.gusmaomatheus.api.model.entity;

import br.com.gusmaomatheus.api.model.dto.DadosAtualizacaoConserto;
import br.com.gusmaomatheus.api.model.dto.DadosMecanico;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
public final class Mecanico {
    private String nome;
    private Integer anosDeExperiencia;

    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.anosDeExperiencia = dados.anosDeExperiencia();
    }

    public void atualizar(DadosAtualizacaoConserto dados) {
        if (Objects.nonNull(dados.nomeMecanico())) {
            this.nome = dados.nomeMecanico();
        }

        if (Objects.nonNull(dados.anosDeExperiencia())) {
            this.anosDeExperiencia = dados.anosDeExperiencia();
        }
    }
}