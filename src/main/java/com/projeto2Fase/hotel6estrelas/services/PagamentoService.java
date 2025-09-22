package com.projeto2Fase.hotel6estrelas.services;

import com.projeto2Fase.hotel6estrelas.entities.Pagamento;
import com.projeto2Fase.hotel6estrelas.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento criarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento atualizarPagamento(Long id, Pagamento pagamentoAtualizado) {
        Pagamento pagamento = buscarPagamentoId(id);
        if (pagamento == null) {
            throw new EntityNotFoundException("Não existe pagamento com esse id");
        }
        pagamentoAtualizado.setId(id);
        return pagamentoRepository.save(pagamentoAtualizado);
    }

    public Pagamento buscarPagamentoId(Long id) {
        Optional<Pagamento> buscarPagamento = pagamentoRepository.findById(id);
        return buscarPagamento.orElse(null);
    }

    public void deletarPagamento(Long id) {
        if (buscarPagamentoId(id) != null) {
            pagamentoRepository.deleteById(id);
        }
    }
}