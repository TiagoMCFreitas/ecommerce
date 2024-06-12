package com.ecommerce.service;

import com.ecommerce.adapterEncriptador.adapter.HashAdapter;
import com.ecommerce.adapterEncriptador.especifico.SHA256Hasher;
import com.ecommerce.model.Usuario;
import com.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JsonComponentModule jsonComponentModule;

    public Usuario salvar(Usuario usuario) {
        HashAdapter adapter = new SHA256Hasher();
        String senhaEncriptada = adapter.hash(usuario.getSenha()) ;
        usuario.setSenha(senhaEncriptada);
        return usuarioRepository.save(usuario);
    }
    public Usuario alterar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public void deletar(long id) {
        this.usuarioRepository.deleteById(id);
    }

    public List<Usuario> pegarTodosUsuario() {
        return  this.usuarioRepository.findAll();
    }

    public Usuario pegarUsuarioPorId(Long id) {
        return this.usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public boolean fazerLogin(String email, String senha) {
        String senhaBanco = this.usuarioRepository.senhaUsuario(email);
        HashAdapter adapter = new SHA256Hasher();
        String senhaEncriptada = adapter.hash(senha);
        if(!senhaBanco.isEmpty()){
            return senhaBanco.equals(senhaEncriptada);
        }else{
            return false;
        }
    }

}
