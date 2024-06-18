package com.ecommerce.repository;

import com.ecommerce.Enum.TipoStatus;
import com.ecommerce.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    @Query(value = "SELECT c FROM Carrinho c where c.usuario.id = :idUsuario and c.status != 2")
    Carrinho findCarrinhoByUsuario(@Param("idUsuario") Long idUsuario );


}
