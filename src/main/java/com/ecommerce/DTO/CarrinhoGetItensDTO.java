package com.ecommerce.DTO;

public class CarrinhoGetItensDTO {
        private Long id;
        private String nome;
        private String descricao;
        private double precoTotal;
        private int quantidade;
        private String foto;
        private String tipoProduto;

        public CarrinhoGetItensDTO() {
            // Construtor padrão
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

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
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

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public CarrinhoGetItensDTO(Long id, String nome, String descricao, double precoTotal, int quantidade, String foto, String tipoProduto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoTotal = precoTotal;
        this.quantidade = quantidade;
        this.foto = foto;
        this.tipoProduto = tipoProduto;
    }
}
