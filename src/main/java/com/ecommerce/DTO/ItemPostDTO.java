package com.ecommerce.DTO;

public class ItemPostDTO {
    private Long id_carrinho;
    private Long id_produto;
    private int quantidade;

    public Long getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(Long id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
