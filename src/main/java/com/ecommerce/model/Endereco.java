package com.ecommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name="Endereco")
@Table(name="endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="cep")
    private String cep;

    @Column(name="rua")
    private String rua;

    @Column(name="bairro")
    private String bairro;

    @Column(name="numero")
    private String numero;

    @Column(name="complemento")
    private String complemento;

    @Column(name="cidade")
    private String cidade;

    @Column(name="uf")
    private String uf;

    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(cep, endereco.cep) && Objects.equals(rua, endereco.rua) && Objects.equals(numero, endereco.numero) && Objects.equals(complemento, endereco.complemento) && Objects.equals(bairro, endereco.bairro) && Objects.equals(cidade, endereco.cidade) && Objects.equals(uf, endereco.uf) && Objects.equals(usuario, endereco.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, rua, numero, complemento, bairro, cidade, uf, usuario);
    }

    public Endereco(Long id, String cep, String rua, String numero, String complemento, String bairro, String cidade, String uf, Usuario usuario) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.usuario = usuario;
    }


}
