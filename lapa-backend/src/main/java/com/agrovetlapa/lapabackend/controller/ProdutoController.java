package com.agrovetlapa.lapabackend.controller;

import com.agrovetlapa.lapabackend.entities.Produto;
import com.agrovetlapa.lapabackend.entities.Produto;
import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.entities.enums.CategoriaProduto;
import com.agrovetlapa.lapabackend.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    public ProdutoService produtoService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<Produto> insertProduto(@RequestBody Produto produto) {

        produto = produtoService.insert(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }
}
