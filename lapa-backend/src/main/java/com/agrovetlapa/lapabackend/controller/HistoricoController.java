package com.agrovetlapa.lapabackend.controller;

import com.agrovetlapa.lapabackend.entities.Dia;
import com.agrovetlapa.lapabackend.entities.Historico;
import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/historico")
public class HistoricoController {
    @Autowired
    VendaService vendaService;
    @GetMapping
    public ResponseEntity<List<Historico>> getHistoricoCompleto(){
        List<Historico> historico = vendaService.getHistoricoCompleto();
        return ResponseEntity.ok().body(historico);
    }
    @GetMapping(value = "/filter")
    public ResponseEntity<List<Historico>> getHistoricoByDateRange(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                       @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        List<Historico> historico = vendaService.getHistoricoInDateRange(minDate, maxDate);
        return ResponseEntity.ok().body(historico);
    }
}
