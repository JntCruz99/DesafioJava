package com.desafio.DESAFIO.service.Impl;

import com.desafio.DESAFIO.domain.entity.Cliente;
import com.desafio.DESAFIO.domain.repository.ClienteRepository;
import com.desafio.DESAFIO.service.ClienteService;
import com.desafio.DESAFIO.service.exceptions.ClienteNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClienteImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar Cliente: "+ e.getMessage());
        }
    }

    @Override
    public Cliente findById(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(
                () -> new ClienteNotFoundExceptions("Id do cliente invalido ou não encontrado."));
        try {
            return cliente;
        }catch (Exception e){
            throw  new RuntimeException("Erro ao procurar cliente:" + e.getMessage());
        }

    }

    @Override
    public Cliente update(Long idCliente, Cliente clienteAtual) {
        Cliente cliente = findById(idCliente);

        try{
            cliente.setName(clienteAtual.getName());
            cliente.setIdade(clienteAtual.getIdade());

            return save(cliente);
        }catch (Exception e){
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
        }

    }

    @Override
    public void delete(Long idCliente) {

        Cliente cliente = findById(idCliente);

        try {
            clienteRepository.delete(cliente);
        }catch (Exception e){
            throw new RuntimeException("Erro ao Deletar Cliente: " + e.getMessage());
        }

    }
}
