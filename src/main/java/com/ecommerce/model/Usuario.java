package com.ecommerce.model;


import com.ecommerce.Enum.TipoUsuario;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name="usuario")
@Entity(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="cpf")
    private String cpf;

    @Column(name="email")
    private String email;

    @Column(name="telefone")
    private String telefone;

    @Column(name="tipo_usuario")
    private String tipoUsuario;

    public Usuario(Long id, String nome, String cpf, String email, String telefone, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario.toString();
    }

    public Usuario() {}

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(cpf, usuario.cpf) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone) && Objects.equals(tipoUsuario, usuario.tipoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, email, telefone, tipoUsuario);
    }
}

