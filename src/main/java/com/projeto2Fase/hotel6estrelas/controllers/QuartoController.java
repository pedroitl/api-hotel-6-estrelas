package com.projeto2Fase.hotel6estrelas.controllers;

import com.projeto2Fase.hotel6estrelas.entities.Quarto;
import com.projeto2Fase.hotel6estrelas.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/quarto")
public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public List<Quarto> listarQuartos() {
        return quartoService.listarQUartos();
    }
    @PostMapping
    public Quarto castarQuarto(@RequestBody Quarto quarto) {
        return quartoService.cadastrarQuarto(quarto);
    }

    @DeleteMapping("/{id}")
    public void removerQuarto(@PathVariable Long id) {
        quartoService.removerQuarto(id);
    }

    @PutMapping("/{id}")
    public Quarto atualizarQuarto(@PathVariable Long id, @RequestBody Quarto quarto) {
        return quartoService.atualizarQuarto(id, quarto);
    }

}
