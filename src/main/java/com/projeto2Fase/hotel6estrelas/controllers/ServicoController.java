package com.projeto2Fase.hotel6estrelas.controllers;

import com.projeto2Fase.hotel6estrelas.entities.Servico;
import com.projeto2Fase.hotel6estrelas.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoService Service;


    @PostMapping
    public Servico cadastrar(@RequestBody Servico servico) {
        return Service.cadastrarServico(servico);
    }

    @GetMapping
    public List<Servico> listar() {
        return Service.listarServicos();
    }

    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable Long id, @RequestBody Servico servico) {
        return Service.atualizarServico(id, servico);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        Service.removerServico(id);
    }

}
