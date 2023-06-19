package com.agrovetlapa.lapabackend.controller;

import com.agrovetlapa.lapabackend.entities.Cliente;
import com.agrovetlapa.lapabackend.entities.Produto;
import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/{nome}")
    public ResponseEntity<Cliente> findByName(@PathVariable String nome){
        Cliente obj = clienteService.findByName(nome);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clienteList = clienteService.findAll();
        return ResponseEntity.ok().body(clienteList);

    }
    @PostMapping
    public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cliente) {
        cliente = clienteService.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente obj){
        obj = clienteService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }

}
