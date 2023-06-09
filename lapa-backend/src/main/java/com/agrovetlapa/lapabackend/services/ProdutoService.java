package com.agrovetlapa.lapabackend.services;

import com.agrovetlapa.lapabackend.entities.Cliente;
import com.agrovetlapa.lapabackend.entities.Produto;
import com.agrovetlapa.lapabackend.repositories.ClienteRepository;
import com.agrovetlapa.lapabackend.repositories.ProdutoRepository;
import com.agrovetlapa.lapabackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(Long.valueOf(id));
        return produto.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto insert(Produto produto){
        return produtoRepository.save(produto);
    }
    public Produto findByName(String name){
        Optional<Produto> produto = Optional.ofNullable(produtoRepository.findByName(name));
        return produto.orElseThrow(() -> new ResourceNotFoundException(name));
    }

    public Produto update(Integer id, Produto produto) {
        produto.setId(id);
        Produto produtoupdt = produtoRepository.getReferenceById(Long.valueOf(id));
        updateData(produtoupdt,produto);
        return produtoRepository.save(produtoupdt);
    }
    private void updateData(Produto entity, Produto obj) {
        entity.setName(obj.getName());
        entity.setQuantidade(obj.getQuantidade());
        entity.setValor(obj.getValor());
        entity.setCategorias(obj.getCategorias());
    }

}

