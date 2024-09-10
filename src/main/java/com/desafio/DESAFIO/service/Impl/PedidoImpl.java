package com.desafio.DESAFIO.service.Impl;

import com.desafio.DESAFIO.domain.dto.PedidoDTO;
import com.desafio.DESAFIO.domain.entity.Cliente;
import com.desafio.DESAFIO.domain.entity.Item;
import com.desafio.DESAFIO.domain.entity.Pedido;
import com.desafio.DESAFIO.domain.repository.PedidoRepository;
import com.desafio.DESAFIO.service.ClienteService;
import com.desafio.DESAFIO.service.ItemService;
import com.desafio.DESAFIO.service.PedidoService;
import com.desafio.DESAFIO.service.exceptions.PedidoNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long idPedido) {
        return pedidoRepository.findById(idPedido).
                orElseThrow(() -> new
                PedidoNotFoundExceptions("Id do pedido invalido ou não encontrado."));
    }

    @Override
    public Pedido save(PedidoDTO data) {

        if (data.idCliente() == null || data.idItem() == null) {
            throw new IllegalArgumentException("ID do cliente e do item não devem ser nulos");
        }

        Cliente cliente = clienteService.findById(data.idCliente());
        Item item = itemService.findById(data.idItem());

        Pedido newPedido = new Pedido();
        
        item.setPedido(newPedido);

        List<Item> list = new ArrayList<>();
        list.add(item);


        newPedido.setCliente(cliente);
        newPedido.setDate(LocalDate.now());
        newPedido.setItensList(list);
        newPedido.setValorTotal(item.getPreco());

        if (!newPedido.getCliente().getName().isEmpty()){
            if (!newPedido.getItensList().isEmpty()){

                try {
                    return pedidoRepository.save(newPedido);
                }catch (Exception e){
                    throw new RuntimeException("Erro ao salvar novo pedido: " + e.getMessage());
                }
            }else {
                throw new RuntimeException("Nenhum item informado no pedido");
            }
        }else {
            throw new RuntimeException("Cliente não informado!");
        }

    }

    @Override
    public Pedido update(Long idPedido, Pedido pedidoAtual) {
        return null;
    }


    @Override
    public void delete(Long idPedido) {
        Pedido pedido = findById(idPedido);

        try {
            pedidoRepository.delete(pedido);
        }catch (Exception e){
            throw new RuntimeException("Erro ao deletar Pedido: " + e.getMessage());
        }
    }
}
