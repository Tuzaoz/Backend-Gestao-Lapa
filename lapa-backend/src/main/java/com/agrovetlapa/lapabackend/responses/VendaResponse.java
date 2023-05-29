package com.agrovetlapa.lapabackend.responses;

import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.services.VendaService;
import org.springframework.data.domain.Page;

import java.util.List;

public class VendaResponse {
    private Page<Venda> vendas;
    private Double valorTotal;

    public VendaResponse(Page<Venda> vendas, Double valorTotal) {
        this.vendas = vendas;
        this.valorTotal = valorTotal;
    }

    public Page<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Page<Venda> vendas) {
        this.vendas = vendas;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
