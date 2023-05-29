package com.agrovetlapa.lapabackend.services;

import com.agrovetlapa.lapabackend.entities.Dia;
import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.repositories.DiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class DiaService {
    @Autowired
    private DiaRepository diaRepository;

    public List<Dia> getDiasByDateRange(String minDate, String maxDate){
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return diaRepository.getDiasByDateRange(min,max);
    }
    public void deleteDiasByDataIsBetween(String minDate, String maxDate){
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        diaRepository.deleteDiasByDataIsBetween(min,max);
    }
}
