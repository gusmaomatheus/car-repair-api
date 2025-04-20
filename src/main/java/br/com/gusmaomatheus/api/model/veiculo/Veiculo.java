package br.com.gusmaomatheus.api.model.veiculo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;

    public Veiculo(VeiculoDTO dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
    }
}