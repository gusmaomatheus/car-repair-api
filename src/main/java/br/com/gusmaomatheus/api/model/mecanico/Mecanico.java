package br.com.gusmaomatheus.api.model.mecanico;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Mecanico {
    private String nome;
    private Integer anosDeExperiencia;

    public Mecanico(MecanicoDTO dados) {
        this.nome = dados.nome();
        this.anosDeExperiencia = dados.anosDeExperiencia();
    }
}