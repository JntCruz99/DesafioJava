package com.desafio.DESAFIO.controller;

import com.desafio.DESAFIO.controller.exceptions.StandardError;
import com.desafio.DESAFIO.domain.entity.Cliente;
import com.desafio.DESAFIO.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> findById(@PathVariable Long idCliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(idCliente));
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<Cliente> update(@PathVariable Long idCliente, @RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(idCliente, cliente));
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> delete(@PathVariable Long idCliente){
        clienteService.delete(idCliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!!");
    }
}
