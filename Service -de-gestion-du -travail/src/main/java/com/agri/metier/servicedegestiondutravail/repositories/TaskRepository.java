package com.agri.metier.servicedegestiondutravail.repositories;

import com.agri.metier.servicedegestiondutravail.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long>
{

    public Task findByRefTask(String reference);

    @RestResource(path = "/listTask")
    public List<Task> findByCreateDate(@Param("date") Date date);
}