package com.ecommerce.service;

import com.ecommerce.model.ItemCarrinho;
import com.ecommerce.repository.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinho salvar(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }
    public ItemCarrinho alterar(ItemCarrinho itemCarrinho) {
        return this.itemCarrinhoRepository.save(itemCarrinho);
    }

    public void deletar(long id) {
        this.itemCarrinhoRepository.deleteById(id);
    }

    public List<ItemCarrinho> pegarTodosItem() {
        return this.itemCarrinhoRepository.findAll();
    }

    public ItemCarrinho pegarItemPorId(Long id) {
        return this.itemCarrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

}
