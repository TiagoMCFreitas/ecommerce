package com.ecommerce.templateMethod.Produto;

import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;

public class OrdenaPorQuantidadeDesc extends Ordena{
    public OrdenaPorQuantidadeDesc(ProdutoService produtoService){
        super(produtoService);
    }

    @Override
    public boolean Ordena(Produto p1, Produto p2) {
        return p1.getQuantidade() <= p2.getQuantidade();
    }
}
