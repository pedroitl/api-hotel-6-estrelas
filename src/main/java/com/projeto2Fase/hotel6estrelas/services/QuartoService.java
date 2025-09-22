package com.projeto2Fase.hotel6estrelas.services;

import com.projeto2Fase.hotel6estrelas.entities.Quarto;
import com.projeto2Fase.hotel6estrelas.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Quarto> listarQUartos() {
        return quartoRepository.findAll();
    }

    public Quarto cadastrarQuarto(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public void removerQuarto(Long id) {
        quartoRepository.deleteById(id);
    }

    public Quarto atualizarQuarto(Long id, Quarto quartoAtualizado) {
        Optional<Quarto> quartoExistente = quartoRepository.findById(id);
        if (quartoExistente.isPresent()) {
            Quarto quarto = quartoExistente.get();
            quarto.setValorDiaria(quartoAtualizado.getValorDiaria());
            quarto.setNumero(quartoAtualizado.getNumero());
            quarto.setTipo(quartoAtualizado.getTipo());
            return quartoRepository.save(quarto);
        } else {
            return null;
        }
    }
}
