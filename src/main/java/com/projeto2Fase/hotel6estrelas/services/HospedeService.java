package com.projeto2Fase.hotel6estrelas.services;

import com.projeto2Fase.hotel6estrelas.entities.Hospede;
import com.projeto2Fase.hotel6estrelas.repository.HospedeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {
    @Autowired
    private HospedeRepository hospedeRepository;

    public Hospede cadastrarHospede(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public List<Hospede> listarHospedes(){
        return hospedeRepository.findAll();
    }

    public void excluirHospede(Long id) {
        hospedeRepository.deleteById(id);
    }

    public Hospede atualizarHospede(Long id, Hospede hospedeAtualizado) {
        Hospede hospede = hospedeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hospede não encontrado!"));;
        hospede.setNome(hospedeAtualizado.getNome());
        hospede.setEmail(hospedeAtualizado.getEmail());
        hospede.setCpf(hospedeAtualizado.getCpf());
        hospede.setTelefone(hospedeAtualizado.getTelefone());
        return hospedeRepository.save(hospede);
    }

}
