package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity(name="Session")
@Table(name="session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @Column(name="data_registro")
    private Date dataRegistro;
    public Session() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) && Objects.equals(usuario, session.usuario) && Objects.equals(dataRegistro, session.dataRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, dataRegistro);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Session(String id, Usuario usuario, Date dataRegistro) {
        this.id = id;
        this.usuario = usuario;
        this.dataRegistro = dataRegistro;
    }
}
