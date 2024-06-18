package com.ecommerce.service;

import com.ecommerce.model.ItemPedido;
import com.ecommerce.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    ItemPedido salvar(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }
}
