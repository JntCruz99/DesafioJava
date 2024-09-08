package com.desafio.DESAFIO.service;

import com.desafio.DESAFIO.domain.entity.Cliente;
import com.desafio.DESAFIO.domain.entity.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ResponseEntity<List<Item>> findAll();
}
