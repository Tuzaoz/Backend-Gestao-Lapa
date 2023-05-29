package com.agrovetlapa.lapabackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table
public class Dia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private Double totalVendas;
    private Double totalVendasCartao;
    private Double totalVendasDinheiroPix;


    public Dia() {
    }

    public Dia(Long id, LocalDate data, Double totalVendas, Double totalVendasCartao, Double totalVendasDinheiroPix) {
        this.id = id;
        this.data = data;
        this.totalVendas = totalVendas;
        this.totalVendasCartao = totalVendasCartao;
        this.totalVendasDinheiroPix = totalVendasDinheiroPix;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(Double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public Double getTotalVendasCartao() {
        return totalVendasCartao;
    }

    public void setTotalVendasCartao(Double totalVendasCartao) {
        this.totalVendasCartao = totalVendasCartao;
    }


    public Double getTotalVendasDinheiroPix() {
        return totalVendasDinheiroPix;
    }

    public void setTotalVendasDinheiroPix(Double totalVendasDinheiroPix) {
        this.totalVendasDinheiroPix = totalVendasDinheiroPix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dia data1 = (Dia) o;
        return Objects.equals(data, data1.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

