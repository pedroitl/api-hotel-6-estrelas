package com.projeto2Fase.hotel6estrelas.enums;

public enum MetodoPagamento {
    DEBITO("Débito"),
    CREDITO("Crédito"),
    PIX("Pix"),
    DINHEIRO("Dinheiro");

    private final String descricao;

    MetodoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
