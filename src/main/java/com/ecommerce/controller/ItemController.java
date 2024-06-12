package com.ecommerce.controller;

import java.util.List;

import com.ecommerce.DTO.ItemPostDTO;
import com.ecommerce.model.Carrinho;
import com.ecommerce.model.Produto;
import com.ecommerce.service.CarrinhoService;
import com.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.model.Item;
import com.ecommerce.service.ItemService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins="*")

public class ItemController {
  @Autowired
    private ItemService itemService;
  @Autowired
    private ProdutoService produtoService;
  @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping("/")
    public List<Item> listar() {
        return this.itemService.pegarTodosItem();
    }

    @GetMapping("/{id}")
    public Item buscarPorId(@PathVariable(value = "id") Long id) {
        return this.itemService.pegarItemPorId(id);
    }

    @PostMapping("/")
    @Transactional
    public Item salvar(@RequestBody ItemPostDTO item) {
        Produto produto = produtoService.pegarProdutoPorId(item.getId_produto());
        Carrinho carrinho = carrinhoService.pegarCarrinhoPorId(item.getId_carrinho());
        Item itemInserir = new Item();
        itemInserir.setProduto(produto);
        itemInserir.setCarrinho(carrinho);
        itemInserir.setQuantidade(item.getQuantidade());
        return this.itemService.salvar(itemInserir);
    }

    @PutMapping("/")
    @Transactional
    public Item alterar(@RequestBody Item item) {
        return this.itemService.alterar(item);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable("id") long id) {
        this.itemService.deletar(id);
    }
}
