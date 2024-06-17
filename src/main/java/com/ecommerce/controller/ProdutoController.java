package com.ecommerce.controller;

import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;
import com.ecommerce.templateMethod.Produto.OrdenaPorCategoria;
import com.ecommerce.templateMethod.Produto.OrdenaPorPrecoDesc;
import com.ecommerce.templateMethod.Produto.OrdenaPorQuantidadeDesc;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin(origins="*")

public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> listar(String tipoOrdenacao) throws Exception {
        OrdenaPorPrecoDesc ordenacao = null;
        OrdenaPorQuantidadeDesc ordenacaoQuantidade = null;
        OrdenaPorCategoria  ordenacaoCategoria = null;
        if(tipoOrdenacao==null){
            return this.produtoService.pegarTodosProduto();
        }
        if(tipoOrdenacao.equals("categoria")){
            ordenacaoCategoria = new OrdenaPorCategoria(this.produtoService);
            return ordenacaoCategoria.listaProdutos();
        }
        if(tipoOrdenacao.equals("preco")){
            ordenacao = new OrdenaPorPrecoDesc(this.produtoService);
            return ordenacao.listaProdutos();
        }
        if(tipoOrdenacao.equals("quantidade")){
            ordenacaoQuantidade = new OrdenaPorQuantidadeDesc(this.produtoService);
            return ordenacaoQuantidade.listaProdutos();
        }
        assert ordenacao != null;
        return this.produtoService.pegarTodosProduto();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable(value = "id") Long id) {
        return this.produtoService.pegarProdutoPorId(id);
    }

    @PostMapping("/")
    @Transactional
    public Produto salvar(@RequestBody Produto produto) {
        return this.produtoService.salvar(produto);
    }

    @PutMapping("/")
    @Transactional
    public Produto alterar(@RequestBody Produto produto) {
        return this.produtoService.alterar(produto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable("id") long id) {
        this.produtoService.deletar(id);
    }

}
