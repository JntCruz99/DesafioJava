package com.desafio.DESAFIO.service;

import com.desafio.DESAFIO.domain.entity.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente save(Cliente cliente);

    Cliente findById(Long idCliente);

    Cliente update(Long idClente, Cliente clienteAtual);

    void delete(Long idCliente);
}
