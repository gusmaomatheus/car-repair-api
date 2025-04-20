package br.com.gusmaomatheus.api.model.veiculo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public final class Veiculo {
    private String marca;
    private String modelo;
    private String cor;
    private String ano;

    public Veiculo(VeiculoDTO dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.cor = dados.cor();
        this.ano = dados.ano();
    }
}