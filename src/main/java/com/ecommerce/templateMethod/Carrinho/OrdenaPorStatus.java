package com.ecommerce.templateMethod.Carrinho;

import com.ecommerce.model.Carrinho;
import com.ecommerce.service.CarrinhoService;

public class OrdenaPorStatus extends Ordena {
    public OrdenaPorStatus(CarrinhoService carrinhoService){
        super(carrinhoService);
    }

    @Override
    public boolean Ordena(Carrinho p1, Carrinho p2) {
        int comparacaoTipo =p1.getStatus().toString().compareToIgnoreCase( p2.getStatus().toString());
        return comparacaoTipo <= 0;
    }

}
