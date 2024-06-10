package com.ecommerce.model;

import com.ecommerce.Enum.TipoProduto;
import jakarta.persistence.*;

import java.util.Objects;


@Table(name = "produto")
@Entity(name = "Produto")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Produto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private float preco;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "foto")
    private String foto;

    @Column(name="tipo_produto")
    private String tipoProduto;


    public Produto(Long id, String nome, String descricao, float preco, int quantidade, String foto, TipoProduto tipoProduto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.foto = foto;
        this.tipoProduto = tipoProduto.toString();
    }

    public Produto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
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

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Float.compare(preco, produto.preco) == 0 && quantidade == produto.quantidade && Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao) && Objects.equals(foto, produto.foto) && Objects.equals(tipoProduto, produto.tipoProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, quantidade, foto, tipoProduto);
    }
}
