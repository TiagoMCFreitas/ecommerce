package com.ecommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="total_pedido")
    private float totalPedido;

    @Column(name="cep_entrega")
    private String cepEntrega;

    @Column(name="rua_entrega")
    private String ruaEntrega;

    @Column(name="numero_entrega")
    private int numeroEntrega;

    @Column(name="complemento_entrega")
    private String complementoEntrega;

    @ManyToOne
    @JoinColumn(name="id_carrinho")
    private Carrinho carrinho;

    @Column(name="status")
    private String status;


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Float.compare(totalPedido, pedido.totalPedido) == 0 && numeroEntrega == pedido.numeroEntrega && Objects.equals(id, pedido.id) && Objects.equals(cepEntrega, pedido.cepEntrega) && Objects.equals(ruaEntrega, pedido.ruaEntrega) && Objects.equals(complementoEntrega, pedido.complementoEntrega) && Objects.equals(carrinho, pedido.carrinho) && Objects.equals(status, pedido.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPedido, cepEntrega, ruaEntrega, numeroEntrega, complementoEntrega, carrinho, status);
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

    public String getCepEntrega() {
        return cepEntrega;
    }

    public void setCepEntrega(String cepEntrega) {
        this.cepEntrega = cepEntrega;
    }

    public String getRuaEntrega() {
        return ruaEntrega;
    }

    public void setRuaEntrega(String ruaEntrega) {
        this.ruaEntrega = ruaEntrega;
    }

    public int getNumeroEntrega() {
        return numeroEntrega;
    }

    public void setNumeroEntrega(int numeroEntrega) {
        this.numeroEntrega = numeroEntrega;
    }

    public String getComplementoEntrega() {
        return complementoEntrega;
    }

    public void setComplementoEntrega(String complementoEntrega) {
        this.complementoEntrega = complementoEntrega;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pedido(Long id, float totalPedido, String cepEntrega, String ruaEntrega, int numeroEntrega, String complementoEntrega, Carrinho carrinho, String status) {
        this.id = id;
        this.totalPedido = totalPedido;
        this.cepEntrega = cepEntrega;
        this.ruaEntrega = ruaEntrega;
        this.numeroEntrega = numeroEntrega;
        this.complementoEntrega = complementoEntrega;
        this.carrinho = carrinho;
        this.status = status;
    }
}
