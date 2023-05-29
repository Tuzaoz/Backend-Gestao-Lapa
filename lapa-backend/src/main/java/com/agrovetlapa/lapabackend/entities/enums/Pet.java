package com.agrovetlapa.lapabackend.entities.enums;

public enum Pet {
    CACHORRO(1),
    GATO(2),
    GATO_E_CACHORRO(3);

    private int code;

    private Pet(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Pet valueOf(int code) {
        for (Pet value : Pet.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }
}