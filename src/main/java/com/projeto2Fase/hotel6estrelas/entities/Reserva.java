package com.projeto2Fase.hotel6estrelas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hospede_id")
    @JsonIgnoreProperties({"cpf", "telefone", "email", "reservas"})
    private Hospede hospede = new Hospede();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "reserva_servico",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    @JsonIgnoreProperties({"preco", "id", "disponibilidade", "reservas"})
    private List<Servico> servico = new ArrayList<>();

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"id", "reserva"})
    private Pagamento pagamento = new Pagamento();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "reserva_quarto",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "quarto_id")
    )
    @JsonIgnoreProperties({"reservas", "tipo", "valorDiaria"})
    private List<Quarto> quartos = new ArrayList<>();

}
