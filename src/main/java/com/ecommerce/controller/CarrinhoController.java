package com.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.ecommerce.DTO.CarrinhoPostDTO;
import com.ecommerce.Enum.TipoStatus;
import com.ecommerce.model.Session;
import com.ecommerce.model.Usuario;
import com.ecommerce.service.SessionService;
import com.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.model.Carrinho;
import com.ecommerce.service.CarrinhoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/carrinho")
@CrossOrigin(origins="*")

public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SessionService sessionService;


    @GetMapping("/")
    public List<Carrinho> listar() {
        return this.carrinhoService.pegarTodosCarrinho();
    }

    @GetMapping("/{session_token}")
    public ResponseEntity CarrinhoUsuario(@PathVariable String session_token) {
        Map<String, Object> jsonEnvio = new HashMap<>();
        Session session = sessionService.getUserByIdSession(session_token);
        Carrinho carrinho = carrinhoService.pegarCarrinhoPorUsuario(session.getUsuario().getId());
        jsonEnvio.put("id_carrinho", carrinho.getId());
        jsonEnvio.put("status" , carrinho.getStatus());
        jsonEnvio.put("itens", carrinhoService.pegarItensCarrinhoPorUsuario(session.getUsuario().getId()));
        return ResponseEntity.ok(jsonEnvio);
    }

    @PostMapping("/")
    @Transactional
    public Carrinho salvar(@RequestBody CarrinhoPostDTO carrinho) {
        Session session = sessionService.getUserByIdSession(carrinho.getId());
        Usuario usuario = usuarioService.pegarUsuarioPorId(session.getUsuario().getId());
        Carrinho carrinhoInserir = new Carrinho();
        carrinhoInserir.setUsuario(usuario);
        carrinhoInserir.setStatus(TipoStatus.PENDENTE);
        return this.carrinhoService.salvar(carrinhoInserir);

    }

    @PutMapping("/")
    @Transactional
    public Carrinho alterar(@RequestBody Carrinho carrinho) {
        return this.carrinhoService.alterar(carrinho);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable("id") long id) {
        this.carrinhoService.deletar(id);
    }

}
