package com.ecommerce.repository;
import com.ecommerce.DTO.CarrinhoGetItensDTO;
import com.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT new com.ecommerce.DTO.CarrinhoGetItensDTO(p.id,p.nome, p.descricao, (p.preco * i.quantidade), i.quantidade, p.foto, p.tipoProduto) " +
            "FROM Produto p " +
            "INNER JOIN ItemCarrinho i ON i.produto.id = p.id " +
            "WHERE i.carrinho.id = :idCarrinho")
    List<CarrinhoGetItensDTO> findProdutosByCarrinhoId(@Param("idCarrinho") Long idCarrinho);

    @Query("SELECT p FROM Produto p inner join ItemCarrinho c on p.id = c.produto.id where c.id = :idItemCarrinho")
    Produto findProdutoByIdItemCarrinho(@Param("idItemCarrinho") Long id);

    @Query("SELECT p FROM Produto p where p.quantidade > 0")
    List<Produto> pegarTodos();
}

