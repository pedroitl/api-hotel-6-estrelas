package com.projeto2Fase.hotel6estrelas.repository;

import com.projeto2Fase.hotel6estrelas.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
