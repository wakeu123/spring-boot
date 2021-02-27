package com.agrimachine.gestiondestock.repositories;

import com.agrimachine.gestiondestock.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface StockRepository extends JpaRepository<Stock, Long>
{
    @RestResource(path = "/listPiece")
    public List<Stock> findByPieceNameContains(@Param("name") String name);
}
