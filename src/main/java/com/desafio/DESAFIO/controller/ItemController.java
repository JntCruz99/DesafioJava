package com.desafio.DESAFIO.controller;

import com.desafio.DESAFIO.domain.entity.Item;
import com.desafio.DESAFIO.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
    }

    @GetMapping("/{idItem}")
    public ResponseEntity<Item> findById(@PathVariable Long idItem){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findById(idItem));
    }

    @PostMapping
    public ResponseEntity<Item> save(@RequestBody Item item){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(item));
    }

    @PutMapping("/{idItem}")
    public ResponseEntity<Item> update(@PathVariable Long idItem, @RequestBody Item item){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.update(idItem, item));
    }

    @DeleteMapping("/{idItem}")
    public ResponseEntity<String> delete(@PathVariable Long idItem){
        itemService.delete(idItem);
        return ResponseEntity.status(HttpStatus.OK).body("Item deletado com sucesso");
    }

}
