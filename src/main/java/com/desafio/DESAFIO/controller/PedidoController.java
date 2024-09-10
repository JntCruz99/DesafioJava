package com.desafio.DESAFIO.controller;

import com.desafio.DESAFIO.domain.dto.PedidoDTO;
import com.desafio.DESAFIO.domain.entity.Pedido;
import com.desafio.DESAFIO.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<Pedido> findById(@PathVariable Long idPedido){
        return ResponseEntity.ok().body(pedidoService.findById(idPedido));
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoDTO pedidoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoDTO));
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<String> delete(@PathVariable Long idPedido){
        pedidoService.delete(idPedido);
        return ResponseEntity.ok().body("Pedido Excluido com sucesso");
    }

}
