package com.ecommerce.repository;

import com.ecommerce.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query("SELECT s FROM Session s where s.usuario.id = :idUsuario order by s.dataRegistro desc limit 1")
    Session findByUsuario(@Param("idUsuario") Long idUsuario);

    @Query("SELECT s FROM Session s where s.id = :uuid order by s.dataRegistro desc limit 1")
    Session getUserByIdSession(@Param("uuid") String uuid);

}

