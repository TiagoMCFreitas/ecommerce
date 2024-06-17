package com.ecommerce.templateMethod.Carrinho;

import com.ecommerce.model.Carrinho;
import com.ecommerce.model.Produto;
import com.ecommerce.service.CarrinhoService;
import com.ecommerce.service.ItemCarrinhoService;
import com.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class Ordena {

    @Autowired
    private CarrinhoService carrinhoService;

    public Ordena(CarrinhoService carrinhoService){
        this.carrinhoService = carrinhoService;
    }
    public abstract boolean Ordena(Carrinho p1, Carrinho p2);

    public List<Carrinho> listaCarrinhos() throws Exception {
        List<Carrinho> array = this.carrinhoService.pegarTodosCarrinho();
        for (int i = 0; i < array.size(); i++) {
            for (int j = i; j < array.size(); j++) {

                if (!Ordena(array.get(i),array.get(j))) {
                    Carrinho temp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, temp);
                }
            }
        }
        return array;
    }
}
