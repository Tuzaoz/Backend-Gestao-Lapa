package com.agrovetlapa.lapabackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String fone;
    private LocalDate dataCriacao;
    private LocalDate dataAniversario;

    @OneToMany(mappedBy = "nomeCliente")
    @JsonIgnore
    private List<Venda> vendas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String fone, LocalDate dataCriacao, LocalDate dataAniversario) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.dataCriacao = dataCriacao;
        this.dataAniversario = dataAniversario;
    }

    public Cliente(Integer id, String nome, String fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public List<Venda> getVendas() {
        return vendas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
