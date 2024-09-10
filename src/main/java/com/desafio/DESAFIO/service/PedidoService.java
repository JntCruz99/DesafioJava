package com.desafio.DESAFIO.service;

import com.desafio.DESAFIO.domain.dto.PedidoDTO;
import com.desafio.DESAFIO.domain.entity.Cliente;
import com.desafio.DESAFIO.domain.entity.Item;
import com.desafio.DESAFIO.domain.entity.Pedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoService {

    List<Pedido> findAll();

    Pedido findById(Long idPedido);

    Pedido save(PedidoDTO data);

    Pedido update(Long idPedido, Pedido pedidoAtual);

    void delete(Long idPedido);
}
