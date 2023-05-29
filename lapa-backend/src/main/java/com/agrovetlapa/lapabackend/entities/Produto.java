package com.agrovetlapa.lapabackend.entities;

import com.agrovetlapa.lapabackend.entities.enums.Categoria;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double valor;
    private int categoria;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(Integer id, String name, Double valor, int categoria, Integer quantidade) {
        this.id = id;
        this.name = name;
        this.valor = valor;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
