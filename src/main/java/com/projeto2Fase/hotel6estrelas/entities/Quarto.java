package com.projeto2Fase.hotel6estrelas.entities;

import jakarta.persistence.*;
import lombok.*;
import com.projeto2Fase.hotel6estrelas.enums.TipoQuarto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
    private TipoQuarto tipo;

    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();
}
