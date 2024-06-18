package com.ecommerce.service;

import com.ecommerce.DTO.EnderecoDTO;
import com.ecommerce.DTO.EnderecoPostDTO;
import com.ecommerce.model.Endereco;
import com.ecommerce.model.Session;
import com.ecommerce.model.Usuario;
import com.ecommerce.realizarRequisicoes.HTTP;
import com.ecommerce.repository.EnderecoRepository;
import com.ecommerce.repository.SessionRepository;
import com.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.util.*;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SessionRepository sessionRepository;



    public Endereco salvar(EnderecoPostDTO endereco) {
        Session session = sessionRepository.getUserByIdSession(endereco.getSession());
        Usuario usuario = usuarioRepository.findById(session.getUsuario().getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Endereco enderecoSavar = new Endereco(0L,endereco.getCep(), endereco.getRua(),endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(),endereco.getUf(), usuario);
        return enderecoRepository.save(enderecoSavar);
    }

    public List<Endereco> buscarPorIdUsuario(Long id) {
        return enderecoRepository.findAllByIdUsuario(id);
    }

    public Endereco atualizar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> buscarPorSession(String session){
        Session usuario = sessionRepository.getUserByIdSession(session);
        return this.enderecoRepository.findAllByIdUsuario(usuario.getUsuario().getId());
    }

    public Endereco buscarPorId(Long id){
        return this.enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
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
