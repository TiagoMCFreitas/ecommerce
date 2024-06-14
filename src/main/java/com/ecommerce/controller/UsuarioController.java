package com.ecommerce.controller;

import com.ecommerce.DTO.LoginDTO;
import com.ecommerce.model.Usuario;
import com.ecommerce.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins="*")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<Usuario> listar() {
        return this.usuarioService.pegarTodosUsuario();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable(value = "id") Long id) {
        return this.usuarioService.pegarUsuarioPorId(id);
    }

    @PostMapping("/")
    @Transactional
    public Usuario salvar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvar(usuario);
    }

    @PutMapping("/")
    @Transactional
    public Usuario alterar(@RequestBody Usuario usuario) {
        return this.usuarioService.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable("id") long id) {
        this.usuarioService.deletar(id);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody LoginDTO login) {
        return this.usuarioService.fazerLogin(login.getEmail(),login.getSenha());
    }
}
