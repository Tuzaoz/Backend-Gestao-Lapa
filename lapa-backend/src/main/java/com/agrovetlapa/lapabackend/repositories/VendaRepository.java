package com.agrovetlapa.lapabackend.repositories;

import com.agrovetlapa.lapabackend.entities.Dia;
import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.responses.VendaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface VendaRepository extends JpaRepository<Venda,Long> {
    @Query("select obj FROM Venda obj WHERE obj.data = CURRENT_DATE ")
    Page<Venda> findTodaySales(Pageable pageable);

    @Query("SELECT  SUM(valor) FROM Venda WHERE data = CURRENT_DATE ")
    Double totalDia();
    @Query( "SELECT obj FROM Venda obj where obj.data between :min and :max")
    List<Venda> getVendasByDateRange (LocalDate min, LocalDate max);


}
