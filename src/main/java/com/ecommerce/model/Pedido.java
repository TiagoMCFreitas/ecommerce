package com.ecommerce.model;

import com.ecommerce.Enum.TipoStatus;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name="Pedido")
@Table(name="pedido")

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="total_pedido")
    private float totalPedido;

    @ManyToOne
    @JoinColumn(name="id_carrinho")
    private Carrinho carrinho;

    @Column(name="status")
    private TipoStatus status;

    public Pedido(Long id, float totalPedido, Carrinho carrinho, TipoStatus status) {
        this.id = id;
        this.totalPedido = totalPedido;
        this.carrinho = carrinho;
        this.status = status;
    }

    public Pedido() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(float totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public TipoStatus getStatus() {
        return status;
    }

    public void setStatus(TipoStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Float.compare(totalPedido, pedido.totalPedido) == 0 && Objects.equals(id, pedido.id) && Objects.equals(carrinho, pedido.carrinho) && Objects.equals(status, pedido.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPedido, carrinho, status);
    }
}
