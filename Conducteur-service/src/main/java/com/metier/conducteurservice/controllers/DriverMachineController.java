package com.metier.conducteurservice.controllers;

import com.metier.conducteurservice.entities.DriverMachine;
import com.metier.conducteurservice.repositories.DriverMachineRepository;
import com.metier.conducteurservice.services.DriverMachineService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/driver/")
public class DriverMachineController
{

    private Log logger = LogFactory.getLog(DriverMachineController.class);

    private DriverMachineService driverMachineService;
    private DriverMachineRepository driverMachineRepository;

    public DriverMachineController(DriverMachineService driverMachineService, DriverMachineRepository driverMachineRepository) {
        this.driverMachineService = driverMachineService;
        this.driverMachineRepository = driverMachineRepository;
    }

    @GetMapping(path = "/info")
    public String getInfo(){
        return "AGRI-DRIVER-MACHINE-SERVICE";
    }

    /*
    * Add Driver Machine
     */
    @PostMapping(path = "/add")
    public DriverMachine add(@RequestBody DriverMachine driverMachine){
        logger.info(String.format("Add Driver machine in database"));
        return driverMachineService.addDriverMachine(driverMachine);
    }

    /*
    * List all driver machine
     */
    @GetMapping(path = "/all")
    public List<DriverMachine> findAll(){
        logger.info(String.format("Getting all driverMachine in database."));
        return driverMachineService.all();
    }

    /*
    * return driver machine where id equal to @Param id
     */
    @GetMapping(path = "/getItem/{id}")
    public DriverMachine getItem(@PathVariable(name = "id") Long id){
        logger.info(String.format("Return driver machine where id = " + id));
        return driverMachineService.getDriverMachineById(id);
    }

    /*
     * return driver machine where name equal to @Param name
     */
    @GetMapping(path = "/getDriverName/{name}")
    public DriverMachine getDriverName(@PathVariable(name = "name") String nameDriver){
        logger.info(String.format("Return driver machine where name = " + nameDriver));
        return driverMachineRepository.findByName(nameDriver);
    }

    /*
     * delete driver machine where matricule equal to @Param mat
     */
    @DeleteMapping(path = "/del/{mat}")
    public void delete(@PathVariable(name = "mat") String matricule){
        logger.info(String.format("Delete driver machine where matricule = " + matricule));
        driverMachineService.deleteDriverMachine(matricule);
    }

    /*
     * Update driver machine where id equal to @Param id
     */
    @PatchMapping(path = "/updateDriver/{id}")
    public DriverMachine upDateDriverMachine(@RequestBody DriverMachine driverMachine, @PathVariable(name = "id") Long id){
        logger.info(String.format("Update driver machine where id = " + id));
        return driverMachineService.updateDriver(driverMachine, id);
    }

}
