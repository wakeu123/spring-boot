package com.agri.metier.servicedegestiondutravail.services;

import com.agri.metier.servicedegestiondutravail.client.DriverMachineClient;
import com.agri.metier.servicedegestiondutravail.entities.Task;
import com.agri.metier.servicedegestiondutravail.models.DriverMachine;
import com.agri.metier.servicedegestiondutravail.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
@Transactional
public class TaskService
{
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private DriverMachineClient driverMachineClient;

    public Task getTask(String ref){
        Task task = taskRepository.findByRefTask(ref);
        if(task == null) throw new RuntimeException("Task don't exist.");
        return task;
    }

    public Task addTask(Task task)  {
        SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
        df1.setTimeZone(TimeZone.getTimeZone("Africa/Douala"));
        Date date  = null;
        try {
            date = df1.parse(df1.format(new Date()));
        }catch (ParseException e){
            e.printStackTrace();
        }

        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss");
        df2.setTimeZone(TimeZone.getTimeZone("Africa/Douala"));
        Date heure  = null;
        try {
            heure = df2.parse(df2.format(new Date()));
        }catch (ParseException e){
            e.printStackTrace();
        }
        DriverMachine driver = driverMachineClient.getDriverByName(task.getDriverMachineName());

        task.setDriverMachineId(driver.getId());
        task.setCreateDate(date);
        task.setCreateTime(heure);
        taskRepository.save(task);
        return task;
    }

    public void deleteTask(String ref){
        Task task = getTask(ref);
        taskRepository.delete(task);
    }

    public Task updateTask(Task task){
        taskRepository.saveAndFlush(task);
        return task;
    }
}
