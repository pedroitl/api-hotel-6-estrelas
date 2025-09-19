package com.projeto2Fase.hotel6estrelas.controllers;

import com.projeto2Fase.hotel6estrelas.entities.Reserva;
import com.projeto2Fase.hotel6estrelas.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @PostMapping
    public Reserva criar (@RequestBody Reserva reserva){
        return reservaService.criarReserva(reserva);
    }
    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Long id){
        reservaService.deletarReserva(id);
    }
    @PutMapping("/{id}")
    public void atualizar (@PathVariable Long id, @RequestBody Reserva reserva){
        reservaService.atualizarReserva(id, reserva);
    }
}
