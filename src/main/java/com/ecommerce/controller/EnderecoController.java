package com.ecommerce.controller;

import com.ecommerce.DTO.EnderecoDTO;
import com.ecommerce.DTO.EnderecoPostDTO;
import com.ecommerce.model.Endereco;
import com.ecommerce.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public Map<String, String> cep(@PathVariable(value = "cep") String cep) {
        return enderecoService.buscarEnderecoCep(cep);
    }

    @PostMapping("/")
    public Endereco save(@RequestBody EnderecoPostDTO endereco) {
        return enderecoService.salvar(endereco);
    }



}

