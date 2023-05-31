package com.agrovetlapa.lapabackend.entities.enums;

public enum MetodoDePagamento {
    DINHEIRO(0),
    PIX(1),
    CARTÃO_DE_CRÉDITO(2),
    CARTÃO_DE_DÉBITO(3);


    private Integer codigo;

    MetodoDePagamento(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
