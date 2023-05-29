package com.agrovetlapa.lapabackend.services;

import com.agrovetlapa.lapabackend.entities.Cliente;
import com.agrovetlapa.lapabackend.repositories.ClienteRepository;
import com.agrovetlapa.lapabackend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findByid(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(Long.valueOf(id));
        return cliente.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public Cliente findByName(String name){
        Optional<Cliente> cliente = Optional.ofNullable(clienteRepository.findByNome(name));
        return cliente.orElseThrow(() -> new ResourceNotFoundException(name));
    }

}
