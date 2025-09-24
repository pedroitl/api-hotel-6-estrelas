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
@Table(name = "hospedes")
@NoArgsConstructor
@AllArgsConstructor
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @OneToMany(mappedBy = "hospede", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"dataEntrada", "dataSaida", "hospede", "servico", "pagamento", "quartos"})
    private List<Reserva> reservas = new ArrayList<>();

}
