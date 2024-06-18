package com.ecommerce.DTO;

import com.ecommerce.model.ItemCarrinho;

import java.util.List;
import java.util.Objects;

public class PedidoPostDTO {
    private float totalPedido;
    private Long id_endereco;
    private Long id_carrinho;
    private List<ItemCarrinho> itemCarrinho;

    public PedidoPostDTO() {
    }

    public float getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(float totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public Long getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(Long id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public List<ItemCarrinho> getItemCarrinho() {
        return itemCarrinho;
    }

    public void setItemCarrinho(List<ItemCarrinho> itemCarrinho) {
        this.itemCarrinho = itemCarrinho;
    }

    public PedidoPostDTO(float totalPedido, Long id_endereco, Long id_carrinho, List<ItemCarrinho> itemCarrinho) {
        this.totalPedido = totalPedido;
        this.id_endereco = id_endereco;
        this.id_carrinho = id_carrinho;
        this.itemCarrinho = itemCarrinho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoPostDTO that = (PedidoPostDTO) o;
        return Float.compare(totalPedido, that.totalPedido) == 0 && Objects.equals(id_endereco, that.id_endereco) && Objects.equals(id_carrinho, that.id_carrinho) && Objects.equals(itemCarrinho, that.itemCarrinho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPedido, id_endereco, id_carrinho, itemCarrinho);
    }
}
