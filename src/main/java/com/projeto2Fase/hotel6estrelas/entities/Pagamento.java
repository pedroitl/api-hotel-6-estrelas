package com.projeto2Fase.hotel6estrelas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.projeto2Fase.hotel6estrelas.entities.Reserva;
import com.projeto2Fase.hotel6estrelas.enums.MetodoPagamento;
;

@Entity
@Table(name = "pagamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodo;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}
