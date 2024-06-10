package com.ecommerce.service;

import com.ecommerce.model.Item;
import com.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item salvar(Item item) {
        return itemRepository.save(item);
    }
    public Item alterar(Item item) {
        return this.itemRepository.save(item);
    }

    public void deletar(long id) {
        this.itemRepository.deleteById(id);
    }

    public List<Item> pegarTodosItem() {
        return this.itemRepository.findAll();
    }

    public Item pegarItemPorId(Long id) {
        return this.itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

}
