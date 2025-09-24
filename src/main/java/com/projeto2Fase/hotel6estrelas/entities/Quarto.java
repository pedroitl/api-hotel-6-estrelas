package com.projeto2Fase.hotel6estrelas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import com.projeto2Fase.hotel6estrelas.enums.enumTipoQuarto;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "quartos")
@NoArgsConstructor
@AllArgsConstructor

public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double valorDiaria;
    private int numero;

    @Enumerated(EnumType.STRING)
    @Column
    private enumTipoQuarto tipo;

    @ManyToMany(mappedBy = "quartos")
    @JsonIgnoreProperties({"dataEntrada", "dataSaida", "hospede", "servico", "pagamento", "quartos"})
    private List<Reserva> reservas = new ArrayList<>();

}
