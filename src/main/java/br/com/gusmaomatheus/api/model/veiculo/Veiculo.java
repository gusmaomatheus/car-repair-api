package br.com.gusmaomatheus.api.model.veiculo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Table(name = "veiculos")
@Entity(name = "Veiculo")
@NoArgsConstructor
@Getter
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String ano;

    public Veiculo(VeiculoDTO dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(getId(), veiculo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}