package com.ecommerce.service;

import com.ecommerce.DTO.PedidoPostDTO;
import com.ecommerce.Enum.TipoProduto;
import com.ecommerce.Enum.TipoStatus;
import com.ecommerce.model.*;
import com.ecommerce.repository.PedidoRepository;
import com.ecommerce.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CarrinhoService carrinhoService;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ItemPedidoService itemPedidoService;
    @Autowired
    private SessionRepository sessionRepository;

    public Pedido salvar(PedidoPostDTO pedido) {
        Carrinho carrinho = carrinhoService.pegarCarrinhoPorId(pedido.getId_carrinho());
        Endereco endereco = enderecoService.buscarPorId(pedido.getId_endereco());
        Pedido pedidoInserir = new Pedido(0L, pedido.getTotalPedido(), carrinho, endereco, TipoStatus.CONCLUIDO, new Date());
        this.carrinhoService.atualizarCarrinho(carrinho);
        for (int i = 0; i < pedido.getItemCarrinho().size(); i++) {
            Produto prods = this.produtoService.findProdutoByIdItemCarrinho(pedido.getItemCarrinho().get(i).getId());
            prods.setQuantidade(prods.getQuantidade() - pedido.getItemCarrinho().get(i).getQuantidade());
            this.produtoService.removerQuantidadeProduto(prods);
        }
        return this.pedidoRepository.save(pedidoInserir);
    }

    public Pedido alterar(Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }

    public void deletar(long id) {
        this.pedidoRepository.deleteById(id);
    }

    public List<Pedido> pegarTodosItem() {
        return this.pedidoRepository.findAll();
    }

    public Pedido pegarItemPorId(Long id) {
        return this.pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    public List<Pedido> pegarTodos(){
        return this.pedidoRepository.findAll();
    }

    public List<Pedido> pegarPedidosUsuario(String session){
        Session sessionUser = this.sessionRepository.getUserByIdSession(session);
        return this.pedidoRepository.findByUsuario(sessionUser.getUsuario().getId());
    }

}
