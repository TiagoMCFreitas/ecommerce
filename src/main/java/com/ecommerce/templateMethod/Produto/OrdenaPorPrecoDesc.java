package com.ecommerce.templateMethod.Produto;

import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;

public class OrdenaPorPrecoDesc extends Ordena {

    public OrdenaPorPrecoDesc(ProdutoService produtoService){
        super(produtoService);
    }

    @Override
    public boolean Ordena(Produto p1, Produto p2) {
        return p1.getPreco() >= p2.getPreco();
     }
}
