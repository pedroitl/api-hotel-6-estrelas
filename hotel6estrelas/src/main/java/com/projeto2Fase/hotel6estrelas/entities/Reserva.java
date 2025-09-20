package com.projeto2Fase.hotel6estrelas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reserva")
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Date dataEntrada;
    private Date dataSaida;
    @ManyToOne
    @JoinColumn(name = "hospede_id")
    private Hospede hospede = new Hospede();
    @ManyToMany
    private List<Servico> servico = new ArrayList<>();
    //@OneToOne
    //private Pagamento pagamento = new Pagamento();
    //@OneToMany
    //@JoinColumn(name = "quarto_id")
    //private List<Quarto> quarto = new ArrayList<>();

}
