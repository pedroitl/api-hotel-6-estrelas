package com.projeto2Fase.hotel6estrelas.repository;

import com.projeto2Fase.hotel6estrelas.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}
