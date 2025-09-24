package com.projeto2Fase.hotel6estrelas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.projeto2Fase.hotel6estrelas.enums.enumPagamento;
import jakarta.persistence.*;
import lombok.*;

import com.projeto2Fase.hotel6estrelas.entities.Reserva;


@Entity
@Table(name = "pagamento")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    @Enumerated(EnumType.STRING)
    @Column
    private enumPagamento metodo;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    @JsonIgnoreProperties({"dataEntrada", "dataSaida", "hospede", "servico", "pagamento", "quartos"})
    private Reserva reserva;

}
