package com.ecommerce.templateMethod.Produto;

import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class Ordena {

    @Autowired
    private ProdutoService produtoService;

    public Ordena(ProdutoService produtoService){
        this.produtoService = produtoService;
    }
    public abstract boolean Ordena(Produto p1, Produto p2);

    public List<Produto> listaProdutos() throws Exception {
        List<Produto> array = this.produtoService.pegarTodosProduto();
        for (int i = 0; i < array.size(); i++) {
            for (int j = i; j < array.size(); j++) {

                if (!Ordena(array.get(i),array.get(j))) {
                    Produto temp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, temp);
                }
            }
        }
        return array;
    }
}
