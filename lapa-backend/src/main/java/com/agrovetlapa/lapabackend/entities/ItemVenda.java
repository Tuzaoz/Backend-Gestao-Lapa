package com.agrovetlapa.lapabackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonIgnore
    private Venda venda;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Double quantidadeProduto;

    private Double valorTotal= 0.0;

    public ItemVenda(Produto produto, Double quantidadeProduto) {
        this.produto = produto;
        this.quantidadeProduto = quantidadeProduto;
    }


    public ItemVenda() {
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Double getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }



    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidadeProduto;
    }

    public void setQuantidade(Double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal() {
        this.valorTotal = this.getProduto().getValor() * this.quantidadeProduto;
    }
}
