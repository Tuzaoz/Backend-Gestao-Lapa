package com.agrovetlapa.lapabackend.services;

import com.agrovetlapa.lapabackend.entities.Conta;
import com.agrovetlapa.lapabackend.entities.Conta;
import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.repositories.ContaRepository;
import com.agrovetlapa.lapabackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

    public Conta findById(Integer id) {
        Optional<Conta> obj = contaRepository.findById(Long.valueOf(id));
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public List<Conta> getByData(String date){
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate data = LocalDate.parse(date);
        return contaRepository.findByData_Day(data);
    }




    public Conta insert(Conta conta){
        return contaRepository.save(conta);
    }
    public Conta update(Integer id, Conta conta) {
        conta.setId(id);
        Conta contaupdt = contaRepository.getReferenceById(Long.valueOf(id));
        updateData(contaupdt,conta);
        return contaRepository.save(contaupdt);
    }
    private void updateData(Conta entity, Conta obj) {
        entity.setNomeConta(obj.getNomeConta());
        entity.setData(obj.getData());
        entity.setValor(obj.getValor());
    }

//    public List<Conta> getContasByDateRange(String minDate, String maxDate){
//        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
//
//        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
//        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
//        return contaRepository.getContasByDateRange(min,max);
//    }
}

