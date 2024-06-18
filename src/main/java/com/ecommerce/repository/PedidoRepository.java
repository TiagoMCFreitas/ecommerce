package com.ecommerce.repository;

import com.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
@Query("SELECT p FROM Pedido p where p.carrinho.usuario.id = :idUsuario")
    List<Pedido> findByUsuario(@Param("idUsuario") Long idUsuario);
}
