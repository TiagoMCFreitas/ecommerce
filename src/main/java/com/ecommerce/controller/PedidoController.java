package com.ecommerce.controller;


import com.ecommerce.DTO.PedidoPostDTO;
import com.ecommerce.model.Pedido;
import com.ecommerce.model.Produto;
import com.ecommerce.repository.PedidoRepository;
import com.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido/")
@CrossOrigin(origins="*")

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/")
    Pedido adicionar(@RequestBody PedidoPostDTO produto) {
        return this.pedidoService.salvar(produto);
    }
}
