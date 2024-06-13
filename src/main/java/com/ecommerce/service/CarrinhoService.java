package com.ecommerce.service;

import java.util.*;

import com.ecommerce.DTO.CarrinhoGetItensDTO;
import com.ecommerce.model.Produto;
import com.ecommerce.repository.ProdutoRepository;
import com.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Carrinho;
import com.ecommerce.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

     @Autowired
    private CarrinhoRepository carrinhoRepository;
     @Autowired
     private ProdutoRepository produtoRepository;

    public Carrinho salvar(Carrinho carrinho) {

        return carrinhoRepository.save(carrinho);
    }
    public Carrinho alterar(Carrinho carrinho) {
        return this.carrinhoRepository.save(carrinho);
    }

    public void deletar(long id) {
        this.carrinhoRepository.deleteById(id);
    }

    public List<Carrinho> pegarTodosCarrinho() {
        return this.carrinhoRepository.findAll();
    }

    public Carrinho pegarCarrinhoPorId(Long id) {
        return this.carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    public List<CarrinhoGetItensDTO> pegarCarrinhoPorUsuario(Long id_usuario){
        Long id_carrinho = carrinhoRepository.findCarrinhoByUsuario(id_usuario);
        List<CarrinhoGetItensDTO> itens = produtoRepository.findProdutosByCarrinhoId(id_carrinho);
        System.out.println(itens);
        return itens;
    }
    public Long pegarIdCarrinhoPorUsuario(Long id_usuario){
        return carrinhoRepository.findCarrinhoByUsuario(id_usuario);
    }
}
