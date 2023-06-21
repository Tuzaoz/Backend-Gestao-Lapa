package com.agrovetlapa.lapabackend.controller;

import com.agrovetlapa.lapabackend.entities.Conta;
import com.agrovetlapa.lapabackend.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/contagits")
public class ContaController {
    @Autowired
    ContaService contaService;

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Conta> findById(@PathVariable Integer id) {
        Conta obj = contaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Conta>> findAll(){
        List<Conta> contaList = contaService.findAll();
        return ResponseEntity.ok().body(contaList);

    }
    @PostMapping
    public ResponseEntity<Conta> insertConta(@RequestBody Conta conta) {
        conta = contaService.insert(conta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).body(conta);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Conta> update(@PathVariable Integer id, @RequestBody Conta obj){
        obj = contaService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }

}
