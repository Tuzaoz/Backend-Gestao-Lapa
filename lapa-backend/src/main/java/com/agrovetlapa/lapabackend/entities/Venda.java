package com.agrovetlapa.lapabackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Venda implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    @ManyToMany
    @JoinTable(name = "produto_venda",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
        private List<Produto> produto = new ArrayList<>();
        @ManyToOne
        @JoinColumn(name = "cliente")
        private Cliente nomeCliente;
        private LocalDate data;
        private Double valor = 0.0;
        private String metodoPagamento;
    public Venda() {
    }


    public Venda(Integer id, Cliente nomeCliente, LocalDate data, String metodoPagamento) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.metodoPagamento = metodoPagamento;
    }

    public Venda(List<Produto> produto, Cliente nomeCliente, LocalDate data, String metodoPagamento) {
        this.produto = produto;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.metodoPagamento = metodoPagamento;
    }

    public void setNomeCliente(Cliente nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
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

    public void setValor() {
        for (Produto produtos:
             this.produto) {
            this.valor += produtos.getValor();
        }

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
