package com.ecommerce.controller;

import java.util.List;

import com.ecommerce.DTO.ItemCarrinhoAumentarDiminuirDTO;
import com.ecommerce.DTO.ItemPostDTO;
import com.ecommerce.model.Carrinho;
import com.ecommerce.model.ItemCarrinho;
import com.ecommerce.model.Produto;
import com.ecommerce.service.CarrinhoService;
import com.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.service.ItemCarrinhoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/item/carrinho")
@CrossOrigin(origins="*")

public class ItemCarrinhoController {
  @Autowired
    private ItemCarrinhoService itemCarrinhoService;
  @Autowired
    private ProdutoService produtoService;
  @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping("/")
    public List<ItemCarrinho> listar() {
        return this.itemCarrinhoService.pegarTodosItem();
    }

    @GetMapping("/{id}")
    public ItemCarrinho buscarPorId(@PathVariable(value = "id") Long id) {
        return this.itemCarrinhoService.pegarItemPorId(id);
    }

    @PostMapping("/")
    @Transactional
    public ItemCarrinho salvar(@RequestBody ItemPostDTO item) {
        Produto produto = produtoService.pegarProdutoPorId(item.getId_produto());
        Carrinho carrinho = carrinhoService.pegarCarrinhoPorId(item.getId_carrinho());
        ItemCarrinho itemCarrinhoInserir = new ItemCarrinho();
        itemCarrinhoInserir.setProduto(produto);
        itemCarrinhoInserir.setCarrinho(carrinho);
        itemCarrinhoInserir.setQuantidade(item.getQuantidade());
        itemCarrinhoInserir.setAtivo(true);
        return this.itemCarrinhoService.salvar(itemCarrinhoInserir);
    }

    @PutMapping("/")
    @Transactional
    public ItemCarrinho alterar(@RequestBody ItemCarrinho itemCarrinho) {
        System.out.println(itemCarrinho);
        return this.itemCarrinhoService.alterar(itemCarrinho);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable("id") long id) {
        this.itemCarrinhoService.deletar(id);
    }
}
