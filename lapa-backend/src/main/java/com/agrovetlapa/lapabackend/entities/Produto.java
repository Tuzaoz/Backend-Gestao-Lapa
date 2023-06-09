package com.agrovetlapa.lapabackend.entities;

import com.agrovetlapa.lapabackend.entities.enums.CategoriaProduto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double valor;

    @OneToMany(mappedBy = "produto")
    @JsonIgnore
    private List<ItemVenda> itemVendas = new ArrayList<>();
    @CollectionTable(name = "produto_categorias")
    private CategoriaProduto categorias;
    private Double quantidade;

    public Produto() {
    }

    public Produto(Integer id, String name, Double valor, CategoriaProduto categorias, Double quantidade) {
        this.id = id;
        this.name = name;
        this.valor = valor;
        this.categorias = categorias;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CategoriaProduto getCategorias() {
        return categorias;
    }

    public void setCategorias(CategoriaProduto categorias) {
        this.categorias = categorias;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    public void removerEstoque(Double quantidade){
        this.quantidade-= quantidade;
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
