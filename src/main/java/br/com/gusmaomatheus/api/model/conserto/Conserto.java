package br.com.gusmaomatheus.api.model.conserto;

import br.com.gusmaomatheus.api.model.mecanico.Mecanico;
import br.com.gusmaomatheus.api.model.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Table(name = "consertos")
@Entity(name = "Conserto")
@NoArgsConstructor
@Getter
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Conserto(ConsertoDTO dados) {
        this.dataEntrada = LocalDate.parse(dados.dataEntrada(), formatter);
        this.dataSaida = LocalDate.parse(dados.dataSaida(), formatter);
        this.mecanico = new Mecanico(dados.dadosMecanico());
        this.veiculo = new Veiculo(dados.dadosVeiculo());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conserto conserto = (Conserto) o;
        return Objects.equals(getId(), conserto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}