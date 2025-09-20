package com.projeto2Fase.hotel6estrelas.services;

import com.projeto2Fase.hotel6estrelas.entities.Reserva;
import com.projeto2Fase.hotel6estrelas.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva criarReserva (Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public Reserva atualizarReserva (Long id, Reserva reservaAtualizada){
        Reserva reserva = buscarReservaId(id);
        if (reserva == null) {
            throw new EntityNotFoundException("Não existe reservas com esse id");
        }
        reservaAtualizada.setId(id);
        return reservaRepository.save(reservaAtualizada);
    }

    public Reserva buscarReservaId(Long id){
        Optional<Reserva> buscarReserva = reservaRepository.findById(id);
        if(buscarReserva.isPresent()){
            Reserva reserva = buscarReserva.get();
            return reserva;
        }else{
            return null;
        }
    }
    public void deletarReserva(Long id){
        if (buscarReservaId(id) != null){
            reservaRepository.deleteById(id);
        }

    }
}
