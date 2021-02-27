package com.agrimachine.gestiondesmachinesagricoles.controllers;

import com.agrimachine.gestiondesmachinesagricoles.entities.Machine;
import com.agrimachine.gestiondesmachinesagricoles.services.MachineServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/machine/")
public class MachineController
{
    @Autowired
    private MachineServices machineServices;

    Log logger = LogFactory.getLog(MachineController.class);

    /*
     * List all machine
     */
    @GetMapping(path = "/all")
    public List<Machine> pageMachine()
    {
        logger.info(String.format("List all machines"));
        return machineServices.getAll();
    }

    /*
     * Add machine
     */
    @PostMapping(path = "/add")
    public Machine addMachine(@RequestBody Machine machine)
    {
        logger.info(String.format("Add Machine"));
        return machineServices.addMachine(machine);
    }

    /*
     * Update machine
     */
    @PatchMapping(path = "/update")
    public Machine updateMachine(@RequestBody Machine machine)
    {
        logger.info(String.format("Update Machine"));
        return machineServices.updateMachine(machine);
    }

    /*
     * Attach driver to machine
     */
    @PostMapping(path = "/attachDriver/{matricule}/toMachine/{driver}")
    public void attachMachineToDriverMachine(@PathVariable(name = "matricule") String matricule, @PathVariable(name = "driver") String driver)
    {
        logger.info(String.format("Attach driver " + driver + " to machine " + matricule));
        machineServices.attachdriverToMachine(matricule, driver);
    }

    /*
     * Delete machine
     */
    @DeleteMapping(path = "/delete/{matricule}")
    public void delete(@PathVariable String matricule)
    {
        logger.info(String.format("Delete Machine where immatricule = " + matricule));
        machineServices.deleteMachine(matricule);
    }

    /*
     * Return Machine where immatriculetion equal to @Param immatricule
     */
    @GetMapping(path = "/getMachine/{immatricule}")
    public Machine getMachine(@PathVariable(name = "immatricule") String immatricule)
    {
        logger.info(String.format("Getting Machine where immatricule = " + immatricule));
        return machineServices.getByImmatricule(immatricule);
    }
}
