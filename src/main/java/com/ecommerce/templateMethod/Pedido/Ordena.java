package com.ecommerce.templateMethod.Pedido;

import com.ecommerce.model.Carrinho;
import com.ecommerce.model.Pedido;
import com.ecommerce.service.CarrinhoService;
import com.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class Ordena {

    @Autowired
    private PedidoService pedidoService;

    public Ordena(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }
    public abstract boolean Ordena(Pedido p1, Pedido p2);

    public List<Pedido> listaCarrinhos() throws Exception {
        List<Pedido> array = this.pedidoService.pegarTodosItem();
        for (int i = 0; i < array.size(); i++) {
            for (int j = i; j < array.size(); j++) {

                if (!Ordena(array.get(i),array.get(j))) {
                    Pedido temp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, temp);
                }
            }
        }
        return array;
    }
}
