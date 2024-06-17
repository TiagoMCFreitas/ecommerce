package com.ecommerce.model;

import com.ecommerce.Enum.TipoStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.util.Date;
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

    @ManyToOne
    @JoinColumn(name="id_endereco")
    private Endereco endereco;

    @Column(name="status")
    private TipoStatus status;

    @Column(name="data_registro")
    private Date dataRegistro;

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoStatus getStatus() {
        return status;
    }

    public void setStatus(TipoStatus status) {
        this.status = status;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Float.compare(totalPedido, pedido.totalPedido) == 0 && Objects.equals(id, pedido.id) && Objects.equals(carrinho, pedido.carrinho) && Objects.equals(endereco, pedido.endereco) && status == pedido.status && Objects.equals(dataRegistro, pedido.dataRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPedido, carrinho, endereco, status, dataRegistro);
    }

    public Pedido(Long id, float totalPedido, Carrinho carrinho, Endereco endereco, TipoStatus status, Date dataRegistro) {
        this.id = id;
        this.totalPedido = totalPedido;
        this.carrinho = carrinho;
        this.endereco = endereco;
        this.status = status;
        this.dataRegistro = dataRegistro;
    }
}
