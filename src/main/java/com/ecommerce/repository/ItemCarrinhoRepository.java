package com.ecommerce.repository;

import com.ecommerce.model.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
    @Query("UPDATE ItemCarrinho i SET i.ativo = false  WHERE i.id = :idItem ")
    ItemCarrinho updateItemCarrinho(long idItem);

    @Query("SELECT i FROM ItemCarrinho i WHERE i.ativo != false")
    List<ItemCarrinho> listAllItemCarrinho();

}
