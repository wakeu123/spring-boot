package com.agrimachine.gestiondestock.services;

import com.agrimachine.gestiondestock.clients.IntrantClientService;
import com.agrimachine.gestiondestock.entities.Stock;
import com.agrimachine.gestiondestock.model.Intrant;
import com.agrimachine.gestiondestock.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class StockService
{
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private IntrantClientService intrantClientService;

    public List<Stock> all(){
        return stockRepository.findAll();
    }

    public Stock add(Stock stock){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setTimeZone(TimeZone.getTimeZone("Africa/Douala"));
        Date date = null;
        try {
            date  = df.parse(df.format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }
        Intrant intrant = intrantClientService.show(stock.getIntrantName());
        stock.setPieceName(intrant.getIntrantName());
        stock.setCreatedDate(date);
        return stockRepository.save(stock);
    }

    public Stock update(Stock stock){
        return stockRepository.save(stock);
    }

    public void delete(Long id){
        stockRepository.deleteById(id);
    }
}
