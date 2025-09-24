package com.projeto2Fase.hotel6estrelas.enums;

public enum TipoQuarto {
    TRIPLO("Triplo"),
    DUPLO_STANDALONE("Duplo Standalone"),
    QUADRUPLO("Quadruplo"),
    QUINTUPLO("Quintuplo");

    private final String descricao;

    TipoQuarto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
