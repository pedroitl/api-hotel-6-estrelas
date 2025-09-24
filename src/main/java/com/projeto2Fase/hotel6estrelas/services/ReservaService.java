package com.projeto2Fase.hotel6estrelas.services;

import com.projeto2Fase.hotel6estrelas.entities.Reserva;
import com.projeto2Fase.hotel6estrelas.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private HospedeRepository hospedeRepository;

    public List<Reserva> listarReserva(){
        return reservaRepository.findAll();
    }
    public Reserva criarReserva (Reserva reserva){
        if (reserva.getHospede().getId() == null) {
            hospedeRepository.save(reserva.getHospede());
        }
        if (reserva.getPagamento() != null) {
            reserva.getPagamento().setReserva(reserva);
        }
        return reservaRepository.save(reserva);
    }

    public Reserva atualizarReserva (Long id, Reserva reservaAtualizada) throws EntityNotFoundException{
        Reserva reserva = buscarReservaId(id);

        if (reserva == null) {
            throw new EntityNotFoundException("Não existe reservas com esse id");
        }
        reserva.setDataEntrada(reservaAtualizada.getDataEntrada());
        reserva.setDataSaida(reservaAtualizada.getDataSaida());
        reserva.setHospede(reservaAtualizada.getHospede());
        reserva.setServico(reservaAtualizada.getServico());
        reserva.setQuartos(reservaAtualizada.getQuartos());
        reserva.setPagamento(reservaAtualizada.getPagamento());
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
