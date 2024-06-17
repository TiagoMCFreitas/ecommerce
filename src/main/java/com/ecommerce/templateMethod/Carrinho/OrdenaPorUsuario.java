package com.ecommerce.templateMethod.Carrinho;

import com.ecommerce.model.Carrinho;
import com.ecommerce.service.CarrinhoService;

public class OrdenaPorUsuario extends Ordena {

    public OrdenaPorUsuario(CarrinhoService carrinhoService){
        super(carrinhoService);
    }

    @Override
    public boolean Ordena(Carrinho p1, Carrinho p2) {
        return p1.getUsuario().getId() >= p2.getUsuario().getId();
     }
}
