package com.ecommerce.repository;

import com.ecommerce.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT e FROM Endereco e where e.usuario.id = :idUsuario")
    List<Endereco> findAllByIdUsuario(@Param("idUsuario") Long idUsuario);
}
