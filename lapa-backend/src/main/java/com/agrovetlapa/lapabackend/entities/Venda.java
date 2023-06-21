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
public class Venda implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itemVenda = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "cliente_id")
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

    public Venda(List<ItemVenda> itemVenda, Cliente nomeCliente, LocalDate data, String metodoPagamento) {
        this.itemVenda = itemVenda;
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

    public List<ItemVenda> getitemVenda() {
        return itemVenda;
    }

    public void setitemVenda(List<ItemVenda> itemVenda) {
        this.itemVenda = itemVenda;
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
        for (ItemVenda itens:
             this.itemVenda) {
            itens.setValorTotal();
            this.valor += itens.getValorTotal();
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
