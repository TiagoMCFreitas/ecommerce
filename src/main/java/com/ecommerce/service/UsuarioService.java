package com.ecommerce.service;

import com.ecommerce.model.Usuario;
import com.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
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
}
