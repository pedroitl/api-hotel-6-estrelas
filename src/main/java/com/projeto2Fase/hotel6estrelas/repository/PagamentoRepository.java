package com.projeto2Fase.hotel6estrelas.repository;

import com.projeto2Fase.hotel6estrelas.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    void deleteById(Long id);
}