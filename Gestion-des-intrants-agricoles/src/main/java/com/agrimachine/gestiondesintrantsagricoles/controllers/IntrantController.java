package com.agrimachine.gestiondesintrantsagricoles.controllers;

import com.agrimachine.gestiondesintrantsagricoles.entities.Intrant;
import com.agrimachine.gestiondesintrantsagricoles.services.IntrantService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/intrant/")
public class IntrantController
{
    @Autowired
    private IntrantService intrantService;
    Log logger = LogFactory.getLog(IntrantController.class);

    /*
    * Return all intrants
     */
    @GetMapping(path = "/all")
    public List<Intrant> all(){
        return intrantService.all();
    }

    /*
     * Add Intrant
     */
    @PostMapping(path = "/add")
    public Intrant add(@RequestBody Intrant intrant)
    {
        logger.info(String.format("Add Intrant object "+ intrant.toString()));
        return intrantService.add(intrant);
    }

    /*
     * Update Intrant
     */
    @PatchMapping(path = "/update")
    public Intrant update(@RequestBody Intrant intrant)
    {
        logger.info(String.format("Update Intrant "));
        return intrantService.update(intrant);
    }

    /*
    * Delete Intrant
     */
    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        logger.info(String.format("Delete Intrant where id = " + id));
        intrantService.delete(id);
    }

    /*
    * Return Intrant where Name equal to @Param name
     */
    @GetMapping(path = "/show/{name}")
    public Intrant getIntrant(@PathVariable String name)
    {
        logger.info(String.format("Getting Intrant where name = "+ name));
        return intrantService.show(name);
    }
}
