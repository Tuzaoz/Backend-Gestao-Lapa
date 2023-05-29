package com.agrovetlapa.lapabackend.repositories;

import com.agrovetlapa.lapabackend.entities.Dia;
import com.agrovetlapa.lapabackend.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface DiaRepository extends JpaRepository<Dia,Long> {
    @Query("select obj FROM Dia obj WHERE obj.data = :date")
    Dia findDiaByData (LocalDate date);
    @Query( "SELECT obj FROM Dia obj where obj.data between :min and :max")
    List<Dia> getDiasByDateRange (LocalDate min, LocalDate max);
    @Transactional
    @Modifying
    @Query("DELETE FROM Dia obj where obj.data between :min and :max")
    void deleteDiasByDataIsBetween(LocalDate min, LocalDate max);

}
