package com.projeto2Fase.hotel6estrelas.controllers;

import com.projeto2Fase.hotel6estrelas.entities.Pagamento;
import com.projeto2Fase.hotel6estrelas.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public Pagamento criar(@RequestBody Pagamento pagamento) {
        return pagamentoService.criarPagamento(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento atualizar(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        return pagamentoService.atualizarPagamento(id, pagamento);
    }

    @GetMapping("/{id}")
    public Pagamento buscar(@PathVariable Long id) {
        return pagamentoService.buscarPagamentoId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pagamentoService.deletarPagamento(id);
    }
}