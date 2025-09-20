package com.projeto2Fase.hotel6estrelas.services;

import com.projeto2Fase.hotel6estrelas.entities.Servico;
import com.projeto2Fase.hotel6estrelas.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;


    public Servico cadastrarServico(Servico servico) {
        return repository.save(servico);
    }

    public List<Servico> listarServicos() {
        return repository.findAll();
    }

    public Servico atualizarServico(long id, Servico servicoAtualizado) {
        return repository.findById(id)
                .map(Servico -> {
                    Servico.setNome(servicoAtualizado.getNome());
                    Servico.setPreco(servicoAtualizado.getPreco());
                    Servico.setDisponibilidade(servicoAtualizado.isDisponibilidade());
                    return repository.save(Servico);
                })
                .orElseThrow(() -> new RuntimeException("servico nao encontrado!"));
    }

    public void removerServico(long id) {
        repository.deleteById(id);
    }

}
