package com.agrovetlapa.lapabackend.entities.enums;

import jakarta.persistence.Enumerated;


public enum CategoriaProduto {
    RAÇÕES(0),
    GRANEL(1),
    ACESSÓRIOS(2),
    MEDICAMENTOS(3),
    INSETICIDAS(4),
    VERMÍFUGO(5),
    ANTIPULGAS(6);


    private Integer codigo;

    CategoriaProduto(Integer codigo) {
        this.codigo = codigo;
    }

    public static CategoriaProduto fromCodigo(Integer codigo) {
        for (CategoriaProduto categoria : CategoriaProduto.values()) {
            if (categoria.getCodigo() == codigo) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Código de categoria inválido: " + codigo);
    }


    public Integer getCodigo() {
        return codigo;
    }
}
