package com.agrovetlapa.lapabackend.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Historico {
    LocalDate getdata();

    Double gettotal_cartao_cred();

    Double gettotal_dinheiro();

    Double gettotal_pix();
    Double gettotal_deb();

    Double gettotal_venda();

    Double gettotal_conta();
}
