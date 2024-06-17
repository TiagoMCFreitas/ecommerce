package com.ecommerce.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name="item_carrinho")
@Entity(name="ItemCarrinho")

public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantidade")
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_carrinho", nullable = false)
    @JsonBackReference
    private Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name="id_produto", nullable = false)
    private Produto produto;


    public ItemCarrinho(Long id, int quantidade, Carrinho carrinho, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.carrinho = carrinho;
        this.produto = produto;
    }

    public ItemCarrinho() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrinho itemCarrinho = (ItemCarrinho) o;
        return quantidade == itemCarrinho.quantidade && Objects.equals(id, itemCarrinho.id) && Objects.equals(carrinho, itemCarrinho.carrinho) && Objects.equals(produto, itemCarrinho.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, carrinho, produto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
