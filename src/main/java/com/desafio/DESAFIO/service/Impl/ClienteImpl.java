package com.desafio.DESAFIO.service.Impl;

import com.desafio.DESAFIO.domain.entity.Cliente;
import com.desafio.DESAFIO.domain.repository.ClienteRepository;
import com.desafio.DESAFIO.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<List<Cliente>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }
}
