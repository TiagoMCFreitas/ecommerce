package com.ecommerce.repository;

import com.ecommerce.model.Carrinho;
import com.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    @Query("SELECT c.id FROM Carrinho c where c.usuario.id = :idUsuario")
    Long findCarrinhoByUsuario(@Param("idUsuario") Long idUsuario);
}
