package com.agrovetlapa.lapabackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String produto;
    @ManyToOne
    @JoinColumn(name = "nome")
    private Cliente nomeCliente;
    private LocalDate data;
    private Double valor;
    private String categoriaProduto;
    private String metodoPagamento;

    public Venda() {
    }


    public Venda(Integer id, String produto, Cliente nomeCliente, LocalDate data, Double valor, String categoriaProduto, String metodoPagamento) {
        this.id = id;
        this.produto = produto;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.valor = valor;
        this.categoriaProduto = categoriaProduto;
        this.metodoPagamento = metodoPagamento;
    }

    public void setNomeCliente(Cliente nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Cliente getNomeCliente() {
        return nomeCliente;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return id.equals(venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
