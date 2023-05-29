package com.agrovetlapa.lapabackend.repositories;

import com.agrovetlapa.lapabackend.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente findByNome(String nome);
}
