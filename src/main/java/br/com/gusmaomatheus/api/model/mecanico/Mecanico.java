package br.com.gusmaomatheus.api.model.mecanico;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Table(name = "mecanicos")
@Entity(name = "Mecanico")
@NoArgsConstructor
@Getter
public class Mecanico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anosDeExperiencia;

    public Mecanico(MecanicoDTO dados) {
        this.nome = dados.nome();
        this.anosDeExperiencia = dados.anosDeExperiencia();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mecanico mecanico = (Mecanico) o;
        return Objects.equals(getId(), mecanico.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}