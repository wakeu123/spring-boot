package com.metier.conducteurservice.repositories;

import com.metier.conducteurservice.entities.DriverMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface DriverMachineRepository extends JpaRepository<DriverMachine, Long>
{
    //@RestResource(path = "/byadressOrName") ====> J'utilise ce path si je ne veux pas utiliser celui prevu dans
    //la methode ie "findByAdressOrName"
    public List<DriverMachine> findByAdressOrName(String adress, String name);

    @RestResource(path = "/matBykeyword")
    public List<DriverMachine> findByMatriculeContains(@Param("kw") String matricule);

    public DriverMachine findByName(String nameDriver);


}
