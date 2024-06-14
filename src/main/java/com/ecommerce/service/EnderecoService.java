package com.ecommerce.service;

import com.ecommerce.DTO.EnderecoDTO;
import com.ecommerce.model.Endereco;
import com.ecommerce.realizarRequisicoes.HTTP;
import com.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarPorIdUsuario(Long id) {
        return enderecoRepository.findAllByIdUsuario(id);
    }

    public Endereco atualizar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoService that = (EnderecoService) o;
        return Objects.equals(enderecoRepository, that.enderecoRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(enderecoRepository);
    }

    public void remover(Long id) {
        enderecoRepository.deleteById(id);
    }

    public Map<String , String> buscarEnderecoCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            HTTP http = new HTTP();
            JSONObject obj = new JSONObject(http.getHttpGET(url));
            EnderecoDTO novoCEP = new EnderecoDTO(obj.getString("cep"),
                    obj.getString("logradouro"),
                    obj.getString("complemento"),
                    obj.getString("bairro"),
                    obj.getString("localidade"),
                    obj.getString("uf"),
                    obj.getString("ibge"),
                    obj.getString("gia"));
            Map<String, String> cepAtual = new HashMap<>();
            cepAtual.put("cep", novoCEP.getCep());
            cepAtual.put("rua", novoCEP.getRua());
            cepAtual.put("complemento", novoCEP.getComplemento());
            cepAtual.put("bairro", novoCEP.getBairro());
            cepAtual.put("cidade", novoCEP.getLocalidade());
            cepAtual.put("uf", novoCEP.getUf());
            cepAtual.put("ibge", novoCEP.getIbge());
            cepAtual.put("gia", novoCEP.getGia());

        return cepAtual;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
