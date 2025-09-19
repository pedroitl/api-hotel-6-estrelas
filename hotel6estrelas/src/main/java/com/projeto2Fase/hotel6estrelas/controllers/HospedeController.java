package com.projeto2Fase.hotel6estrelas.controllers;

import com.projeto2Fase.hotel6estrelas.entities.Hospede;
import com.projeto2Fase.hotel6estrelas.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospede")
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @GetMapping
    public List<Hospede> hospedes() {
        return hospedeService.listarHospedes();
    }

    @PostMapping
    public Hospede cadastrarHospede(@RequestBody Hospede hospede){
        return hospedeService.cadastrarHospede(hospede);
    }

    @DeleteMapping("/{id}")
    public void excluirHospede(@PathVariable Long id) {
        hospedeService.excluirHospede(id);
    }

    @PutMapping("/{id}")
    public Hospede atualizarHospede(@PathVariable Long id, @RequestBody Hospede hospedeAtualizado) {
        return hospedeService.atualizarHospede(id, hospedeAtualizado);
    }
}
