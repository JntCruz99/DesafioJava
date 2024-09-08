package com.desafio.DESAFIO.service;

import com.desafio.DESAFIO.domain.entity.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    ResponseEntity<List<Cliente>> findAll();
}
