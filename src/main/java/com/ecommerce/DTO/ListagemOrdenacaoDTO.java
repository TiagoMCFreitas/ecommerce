package com.ecommerce.DTO;

import java.util.Objects;

public class ListagemOrdenacaoDTO {

    private String listaParaOrdenar;
    private String tipoOrdenacao;


    public ListagemOrdenacaoDTO() {
    }

    public ListagemOrdenacaoDTO(String listaParaOrdenar, String tipoOrdenacao) {
        this.listaParaOrdenar = listaParaOrdenar;
        this.tipoOrdenacao = tipoOrdenacao;
    }

    public String getListaParaOrdenar() {
        return listaParaOrdenar;
    }

    public void setListaParaOrdenar(String listaParaOrdenar) {
        this.listaParaOrdenar = listaParaOrdenar;
    }

    public String getTipoOrdenacao() {
        return tipoOrdenacao;
    }

    public void setTipoOrdenacao(String tipoOrdenacao) {
        this.tipoOrdenacao = tipoOrdenacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListagemOrdenacaoDTO that = (ListagemOrdenacaoDTO) o;
        return Objects.equals(listaParaOrdenar, that.listaParaOrdenar) && Objects.equals(tipoOrdenacao, that.tipoOrdenacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaParaOrdenar, tipoOrdenacao);
    }
}
