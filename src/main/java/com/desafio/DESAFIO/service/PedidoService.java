package com.desafio.DESAFIO.service;

import com.desafio.DESAFIO.domain.entity.Cliente;
import com.desafio.DESAFIO.domain.entity.Item;
import com.desafio.DESAFIO.domain.entity.Pedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoService {

    ResponseEntity<List<Pedido>> findAll();
}
