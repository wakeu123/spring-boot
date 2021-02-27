package com.agri.metier.servicedegestiondutravail.controllers;

import com.agri.metier.servicedegestiondutravail.entities.Task;
import com.agri.metier.servicedegestiondutravail.repositories.TaskRepository;
import com.agri.metier.servicedegestiondutravail.services.TaskService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task/")
public class TaskController
{
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;

    Log logger = LogFactory.getLog(TaskController.class);

    /*
    * Return AGRI TASK
     */
    @GetMapping(path = "/info")
    public String getInfo()
    {
        return "AGRI TASK";
    }

    /*
    * Return all Tasks
     */
    @GetMapping(path = "/all")
    public List<Task> getAllTasks()
    {
        logger.info(String.format("Getting all Tasks"));
        return taskRepository.findAll();
    }

    /*
    * Return Task where reference equal to @Param ref
     */
    @GetMapping(path = "/{ref}")
    public Task getTask(@PathVariable(name = "ref") String reference)
    {
        logger.info(String.format("Getting Task where reference = " + reference));
        Task task = taskRepository.findByRefTask(reference);
        return task;
    }

    /*
    * Add Tasks
     */
    @PostMapping(path = "/add")
    public Task addTasks(@RequestBody Task task)
    {
        logger.info(String.format("Add Tasks"));
        taskService.addTask(task);
        return task;
    }
    /*
     * Delete Task where reference equal to @Param ref
     */
    @DeleteMapping(path = "/delete/{ref}")
    public void deleteTasks(@PathVariable(name = "ref") String reference)
    {
        logger.info(String.format("Delete Task where reference = " + reference));
        taskService.deleteTask(reference);
    }

    /*
     * Update Task
     */
    @PatchMapping(path = "/update")
    Task upDateTask(@RequestBody Task task)
    {
        logger.info(String.format("Update Tasks"));
        return  taskService.updateTask(task);
    }


}
