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

    public Carrinho(Long id, Usuario usuario, List<Item> items) {
        this.id = id;
        this.usuario = usuario;
    }

    public Carrinho() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return Objects.equals(id, carrinho.id) && Objects.equals(usuario, carrinho.usuario) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario);
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
