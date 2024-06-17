package com.ecommerce.templateMethod.Pedido;

import com.ecommerce.model.Carrinho;
import com.ecommerce.model.Pedido;
import com.ecommerce.service.CarrinhoService;
import com.ecommerce.service.PedidoService;

public class OrdenaPorStatus extends Ordena {
    public OrdenaPorStatus(PedidoService pedidoService){
        super(pedidoService);
    }

    @Override
    public boolean Ordena(Pedido p1, Pedido p2) {
        int comparacaoTipo =p1.getStatus().toString().compareToIgnoreCase( p2.getStatus().toString());
        return comparacaoTipo <= 0;
    }

}
