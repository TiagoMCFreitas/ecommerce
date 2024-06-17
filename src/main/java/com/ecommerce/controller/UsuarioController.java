package com.ecommerce.controller;

import com.ecommerce.DTO.LoginDTO;
import com.ecommerce.model.Usuario;
import com.ecommerce.service.SessionService;
import com.ecommerce.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins="*")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SessionService sessionService;

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
    public Map<String, Object> login(@RequestBody LoginDTO login) {
        Map<String, Object> response = new HashMap<>();
        Usuario usuario = this.usuarioService.fazerLogin(login.getEmail(),login.getSenha());
        response.put("usuario", usuario);
        response.put("session" , this.sessionService.getSessionByIdUser(usuario.getId()));

        return response;
    }
}
