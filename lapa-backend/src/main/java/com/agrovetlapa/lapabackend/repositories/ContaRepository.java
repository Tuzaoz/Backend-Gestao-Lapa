package com.agrovetlapa.lapabackend.repositories;

import com.agrovetlapa.lapabackend.entities.Conta;
import com.agrovetlapa.lapabackend.entities.Produto;
import com.agrovetlapa.lapabackend.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Long> {

    @Query("select obj FROM Conta obj WHERE obj.data = :date ")
    List<Conta> findByData_Day(LocalDate date);

}
