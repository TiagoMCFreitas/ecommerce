package com.ecommerce.templateMethod.Pedido;

import com.ecommerce.model.Carrinho;
import com.ecommerce.model.Pedido;
import com.ecommerce.service.CarrinhoService;
import com.ecommerce.service.PedidoService;

public class OrdenaPorUsuario extends Ordena {

    public OrdenaPorUsuario(PedidoService pedidoService){
        super(pedidoService);
    }

    @Override
    public boolean Ordena(Pedido p1, Pedido p2) {
        return p1.getCarrinho().getUsuario().getId() >= p2.getCarrinho().getUsuario().getId();
     }
}
