package com.ecommerce.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name="item")
@Entity(name="Item")

public class Item {
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


    public Item(Long id, int quantidade, Carrinho carrinho, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.carrinho = carrinho;
        this.produto = produto;
    }

    public Item() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantidade == item.quantidade && Objects.equals(id, item.id) && Objects.equals(carrinho, item.carrinho) && Objects.equals(produto, item.produto);
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
