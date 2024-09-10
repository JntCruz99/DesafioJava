package com.desafio.DESAFIO.service;

import com.desafio.DESAFIO.domain.entity.Cliente;
import com.desafio.DESAFIO.domain.entity.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    Item findById(Long idItem);

    Item save(Item item);

    Item update(Long idItem, Item itemAtual);

    void delete(Long idItem);
}
