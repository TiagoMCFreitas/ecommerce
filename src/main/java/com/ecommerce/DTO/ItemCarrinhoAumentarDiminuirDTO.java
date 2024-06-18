package com.ecommerce.DTO;

import com.ecommerce.Enum.TipoProduto;

import java.util.Objects;

public class ItemCarrinhoAumentarDiminuirDTO {
    private Long id;
    private String nome;
    private String descricao;
    private float precoTotal;
    private int quantidade;
    private String foto;
    private TipoProduto tipoProduto;
    private Long id_carrinho;


    public ItemCarrinhoAumentarDiminuirDTO() {
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

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
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

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Long getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(Long id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrinhoAumentarDiminuirDTO that = (ItemCarrinhoAumentarDiminuirDTO) o;
        return Float.compare(precoTotal, that.precoTotal) == 0 && quantidade == that.quantidade && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(foto, that.foto) && tipoProduto == that.tipoProduto && Objects.equals(id_carrinho, that.id_carrinho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, precoTotal, quantidade, foto, tipoProduto, id_carrinho);
    }

    public ItemCarrinhoAumentarDiminuirDTO(Long id, String nome, String descricao, float precoTotal, int quantidade, String foto, TipoProduto tipoProduto, Long id_carrinho) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoTotal = precoTotal;
        this.quantidade = quantidade;
        this.foto = foto;
        this.tipoProduto = tipoProduto;
        this.id_carrinho = id_carrinho;
    }
}
