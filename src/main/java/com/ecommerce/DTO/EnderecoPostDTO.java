package com.ecommerce.DTO;

import java.util.Objects;

public class EnderecoPostDTO {
    private String cep;
    private String rua;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;
    private String bairro;
    private String session_token;


    public EnderecoPostDTO(String cep, String rua, String cidade, String uf, String numero, String complemento, String bairro, String session_token) {
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.session_token = session_token;
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

    public String getSession() {
        return session_token;
    }

    public void setSession(String session_token) {
        this.session_token = session_token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoPostDTO that = (EnderecoPostDTO) o;
        return Objects.equals(cep, that.cep) && Objects.equals(rua, that.rua) && Objects.equals(cidade, that.cidade) && Objects.equals(uf, that.uf) && Objects.equals(numero, that.numero) && Objects.equals(complemento, that.complemento) && Objects.equals(bairro, that.bairro) && Objects.equals(session_token, that.session_token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, rua, cidade, uf, numero, complemento, bairro, session_token);
    }
}
