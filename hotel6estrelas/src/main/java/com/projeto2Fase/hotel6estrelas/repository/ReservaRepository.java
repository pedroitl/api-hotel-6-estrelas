package com.projeto2Fase.hotel6estrelas.repository;

import com.projeto2Fase.hotel6estrelas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
