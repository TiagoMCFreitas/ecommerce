package com.ecommerce.service;

import com.ecommerce.DTO.ItemCarrinhoAumentarDiminuirDTO;
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

        if(itemCarrinho.getQuantidade() == 0){
            System.out.println(itemCarrinho.getId());
            this.itemCarrinhoRepository.deleteById(itemCarrinho.getId());
        }else{
            this.itemCarrinhoRepository.save(itemCarrinho);
        }

        return null;
    }

    public void deletar(long id) {
        this.itemCarrinhoRepository.deleteById(id);
    }

    public List<ItemCarrinho> pegarTodosItem() {
        return this.itemCarrinhoRepository.listAllItemCarrinho();
    }

    public ItemCarrinho pegarItemPorId(Long id) {
        return this.itemCarrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

}
