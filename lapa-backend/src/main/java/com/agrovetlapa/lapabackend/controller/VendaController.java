package com.agrovetlapa.lapabackend.controller;

import com.agrovetlapa.lapabackend.entities.Dia;
import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.repositories.DiaRepository;
import com.agrovetlapa.lapabackend.repositories.VendaRepository;
import com.agrovetlapa.lapabackend.responses.VendaResponse;
import com.agrovetlapa.lapabackend.services.DiaService;
import com.agrovetlapa.lapabackend.services.VendaService;
import com.agrovetlapa.lapabackend.services.exceptions.NullKeySerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;
    @Autowired
    private DiaService diaService;
    @Autowired
    private DiaRepository diaRepository;

    @GetMapping
    public ResponseEntity<List<Venda>> findAll() {
        List<Venda> list = vendaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<Venda>> findByData_Dia(@RequestParam(value = "date", defaultValue = "") String date) {
        List<Venda> vendas = vendaService.getByData(date);
        return ResponseEntity.ok().body(vendas);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Venda> findById(@PathVariable Integer id) {
        Venda obj = vendaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/hoje")
    public ResponseEntity<VendaResponse> dadosHoje(Pageable pageable) {
        Page<Venda> list = vendaService.findTodayDate(pageable);
        Double valor = vendaService.totalDia();
        VendaResponse response = new VendaResponse(list, valor);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Venda> insertVenda(@RequestBody Venda venda) {
        venda = vendaService.insert(venda);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }


}
