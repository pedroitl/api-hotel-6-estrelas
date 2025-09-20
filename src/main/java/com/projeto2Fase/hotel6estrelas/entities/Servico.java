package com.projeto2Fase.hotel6estrelas.entities;

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
    private String nome;
    private boolean disponibilidade;
    private double preco;
    @OneToMany
    private List<Reserva> reservas = new ArrayList<>();

}
