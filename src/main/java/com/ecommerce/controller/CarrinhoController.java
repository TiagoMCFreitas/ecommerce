package com.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.ecommerce.DTO.CarrinhoPostDTO;
import com.ecommerce.model.Usuario;
import com.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Carrinho;
import com.ecommerce.service.CarrinhoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/")
    public List<Carrinho> listar() {
        return this.carrinhoService.pegarTodosCarrinho();
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity CarrinhoUsuario(@PathVariable Long id_usuario) {
        Map<String, Object> jsonEnvio = new HashMap<>();
        jsonEnvio.put("id_carrinho", carrinhoService.pegarIdCarrinhoPorUsuario(id_usuario));
        jsonEnvio.put("itens", carrinhoService.pegarCarrinhoPorUsuario(id_usuario));

        return ResponseEntity.ok(jsonEnvio);
    }
//    @GetMapping("/{id}")
//    public Carrinho buscarPorId(@PathVariable(value = "id") Long id) {
//        return this.carrinhoService.pegarCarrinhoPorId(id);
//    }

    @PostMapping("/")
    @Transactional
    public Carrinho salvar(@RequestBody CarrinhoPostDTO carrinho) {
        Usuario usuario = usuarioService.pegarUsuarioPorId(carrinho.getId());
        Carrinho carrinhoInserir = new Carrinho();
        carrinhoInserir.setUsuario(usuario);
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
