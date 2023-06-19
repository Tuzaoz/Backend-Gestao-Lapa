package com.agrovetlapa.lapabackend.repositories;

import com.agrovetlapa.lapabackend.entities.Conta;
import com.agrovetlapa.lapabackend.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Long> {

}
