package com.ecommerce.service;

import com.ecommerce.model.Produto;
import com.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return this.produtoRepository.save(produto);
    }
    public Produto alterar(Produto produto) {return this.produtoRepository.save(produto);}
    public void deletar(long id){this.produtoRepository.deleteById(id);}
    public List<Produto> pegarTodosProduto(){
        return this.produtoRepository.findAll();
    }
    public Produto pegarProdutoPorId(int id) {return this.produtoRepository.findById(id);}

}
