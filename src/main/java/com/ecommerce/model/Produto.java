package com.ecommerce.model;

import jakarta.persistence.*;

import java.util.Objects;
@Table(name = "produto")
@Entity(name = "Produto")

public class Produto {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;

    @Column(name="quantidade")
    private int quantidade;

    @Column(name="foto")
    private String foto;

    @Column(name="categoria")
    private String categoria;

    public Produto(int id, String nome, String descricao, double preco, int quantidade, String foto, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.foto = foto;
        this.categoria = categoria;
    }

    public Produto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCategoria() {return categoria;}

    public void setCategoria(String categoria) {this.categoria = categoria;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id && Double.compare(preco, produto.preco) == 0 && quantidade == produto.quantidade && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao) && Objects.equals(foto, produto.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, quantidade, foto, categoria);
    }


}
