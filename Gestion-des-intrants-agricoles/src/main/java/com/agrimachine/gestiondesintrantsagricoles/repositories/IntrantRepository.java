package com.agrimachine.gestiondesintrantsagricoles.repositories;

import com.agrimachine.gestiondesintrantsagricoles.entities.Intrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface IntrantRepository extends JpaRepository<Intrant, Long>
{
    @RestResource(path = "getIntrants")
    public List<Intrant> findByIntrantNameContains(@Param("name") String name);

    public Intrant findByIntrantName(String name);

}
