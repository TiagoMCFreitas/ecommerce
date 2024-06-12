package com.ecommerce.model;

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

    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @Column(name="carrinho_fechado")
    private boolean carrinhoFechado;

    public Carrinho(Long id, Usuario usuario,boolean carrinhoFechado) {
        this.id = id;
        this.usuario = usuario;
        this.carrinhoFechado = carrinhoFechado;
    }

    public Carrinho() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return Objects.equals(id, carrinho.id) && Objects.equals(usuario, carrinho.usuario) && Objects.equals(carrinhoFechado, carrinho.carrinhoFechado) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario,carrinhoFechado);
    }

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

}
