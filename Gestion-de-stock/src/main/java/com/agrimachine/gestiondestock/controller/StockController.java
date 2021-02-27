package com.agrimachine.gestiondestock.controller;

import com.agrimachine.gestiondestock.entities.Stock;
import com.agrimachine.gestiondestock.services.StockService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stock/")
public class StockController
{

    @Autowired
    private StockService stockService;

    Log logger = LogFactory.getLog(StockController.class);

    /*
     * Return all stock
     */
    @GetMapping(path = "/all")
    public List<Stock> all()
    {
        logger.info(String.format("Getting all stock"));
        return stockService.all();
    }

    /*
     * Add a new stock
     */
    @PostMapping(path = "/add")
    public Stock add(@RequestBody Stock stock)
    {
        logger.info(String.format("Add a new stock"));
        return stockService.add(stock);
    }

    /*
     * Update stock
     */
    @PatchMapping(path = "/update")
    public Stock update(@RequestBody Stock stock)
    {
        logger.info(String.format("Update stock"));
        return stockService.update(stock);
    }

    /*
     * Delete stock where id equal to @Param id
     */
    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        logger.info(String.format("Delete stock where id = " + id));
        stockService.delete(id);
    }
}
