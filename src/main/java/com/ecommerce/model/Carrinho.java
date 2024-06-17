package com.ecommerce.model;

import com.ecommerce.Enum.TipoStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name="Carrinho")
@Table(name="carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @Column(name="status")
    private TipoStatus status;

    public Carrinho(Long id, Usuario usuario,TipoStatus status) {
        this.id = id;
        this.usuario = usuario;
        this.status = status;
    }

    public Carrinho() {}




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoStatus getStatus() {
        return status;
    }

    public void setStatus(TipoStatus carrinhoFechado) {
        this.status = carrinhoFechado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return Objects.equals(id, carrinho.id) && Objects.equals(usuario, carrinho.usuario) && status == carrinho.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, status);
    }
}
