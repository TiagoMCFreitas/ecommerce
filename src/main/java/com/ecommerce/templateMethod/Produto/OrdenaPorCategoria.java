package com.ecommerce.templateMethod.Produto;

import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;

public class OrdenaPorCategoria extends Ordena{
    public OrdenaPorCategoria(ProdutoService produtoService){
        super(produtoService);
    }

    @Override
    public boolean Ordena(Produto p1, Produto p2) {
        int comparacaoTipo =p1.getTipoProduto().compareToIgnoreCase( p2.getTipoProduto());
        if(comparacaoTipo <= 0)return true;
        else return false;
    }

}
