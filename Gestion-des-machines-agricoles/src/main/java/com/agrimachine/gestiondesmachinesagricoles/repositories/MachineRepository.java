package com.agrimachine.gestiondesmachinesagricoles.repositories;

import com.agrimachine.gestiondesmachinesagricoles.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface MachineRepository extends JpaRepository<Machine, Long>
{
    @RestResource(path = "/listMachineName")
    public List<Machine> findByMachineName(@Param("name") String name);

    public Machine findByMatriculeMachine(String matricule);

    @RestResource(path = "/listMaachineMatricule")
    public List<Machine> findByMatriculeMachineContains(@Param("immatricule") String immatricule);
}
