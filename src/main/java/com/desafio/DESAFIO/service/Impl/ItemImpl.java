package com.desafio.DESAFIO.service.Impl;

import com.desafio.DESAFIO.domain.entity.Item;
import com.desafio.DESAFIO.domain.repository.ItemRepository;
import com.desafio.DESAFIO.service.ItemService;
import com.desafio.DESAFIO.service.exceptions.ItemNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long idItem) {

        try {
            return itemRepository.findById(idItem).orElseThrow(() ->
                    new ItemNotFoundExceptions("Id do Item invalido ou não encontrado."));
        }catch (Exception e){
            throw new RuntimeException("Erro ao procurar Item:" + e.getMessage());
        }

    }

    @Override
    public Item save(Item item) {
        try {
            return itemRepository.save(item);
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar item: " + e.getMessage());
        }
    }

    @Override
    public Item update(Long idItem, Item itemAtual) {
        Item item = findById(idItem);
        try {
            item.setNome(itemAtual.getNome());
            item.setPreco(itemAtual.getPreco());

            return save(item);
        }catch (Exception e){
            throw new RuntimeException("Erro ao atualizar item: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long idItem) {
        Item item = findById(idItem);

        try {
            itemRepository.delete(item);
        }catch (Exception e){
            throw new RuntimeException("Erro ao deletar Item: " + e.getMessage());
        }
    }
}
