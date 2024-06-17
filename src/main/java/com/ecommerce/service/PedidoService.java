package com.ecommerce.service;

import com.ecommerce.model.ItemCarrinho;
import com.ecommerce.model.Pedido;
import com.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido salvar(Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }

    public Pedido alterar(Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }

    public void deletar(long id) {
        this.pedidoRepository.deleteById(id);
    }

    public List<Pedido> pegarTodosItem() {
        return this.pedidoRepository.findAll();
    }

    public Pedido pegarItemPorId(Long id) {
        return this.pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }


}
