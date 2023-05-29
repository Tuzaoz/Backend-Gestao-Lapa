package com.agrovetlapa.lapabackend.repositories;

import com.agrovetlapa.lapabackend.entities.Cliente;
import com.agrovetlapa.lapabackend.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Produto findByName(String name);
}
