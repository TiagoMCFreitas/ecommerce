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
    public List<Produto> listar() throws Exception {
        return this.produtoService.pegarTodosProduto();
    }

    @GetMapping("/preco")
    public List<Produto> listarPorPreco() throws Exception {
        OrdenaPorPrecoDesc ordena = new OrdenaPorPrecoDesc(this.produtoService);
        return ordena.listaProdutos();
    }

    @GetMapping("/categoria")
    public List<Produto> listarPorCategoria() throws Exception {
        OrdenaPorCategoria ordena = new OrdenaPorCategoria(this.produtoService);
        return ordena.listaProdutos();
    }
    @GetMapping("/quantidade")
    public List<Produto> listarPorQuantidade() throws Exception {
        OrdenaPorQuantidadeDesc ordena = new OrdenaPorQuantidadeDesc(this.produtoService);
        return ordena.listaProdutos();
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
