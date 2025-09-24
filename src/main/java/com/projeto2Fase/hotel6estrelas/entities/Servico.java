package com.projeto2Fase.hotel6estrelas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "servico")
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nome;
    private boolean disponibilidade;
    private double preco;

    @ManyToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"dataEntrada", "dataSaida", "hospede", "servico", "pagamento", "quartos"})
    private List<Reserva> reservas = new ArrayList<>();

}
