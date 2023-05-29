package com.agrovetlapa.lapabackend;

import com.agrovetlapa.lapabackend.entities.Cliente;
import com.agrovetlapa.lapabackend.repositories.ClienteRepository;
import com.agrovetlapa.lapabackend.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LapaBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(LapaBackendApplication.class, args);
    }

}
