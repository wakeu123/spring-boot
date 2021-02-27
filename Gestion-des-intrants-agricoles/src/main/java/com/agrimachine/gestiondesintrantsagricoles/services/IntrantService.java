package com.agrimachine.gestiondesintrantsagricoles.services;

import com.agrimachine.gestiondesintrantsagricoles.clients.MachineClientService;
import com.agrimachine.gestiondesintrantsagricoles.entities.Intrant;
import com.agrimachine.gestiondesintrantsagricoles.model.Machine;
import com.agrimachine.gestiondesintrantsagricoles.repositories.IntrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class IntrantService
{
    @Autowired
    private IntrantRepository intrantRepository;
    @Autowired
    private MachineClientService machineClientService;

    public Intrant add(Intrant intrant){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setTimeZone(TimeZone.getTimeZone("Africa/Douala"));
        Date date = null;
        try {
            date = df.parse(df.format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }
        Machine machine = machineClientService.getMachine(intrant.getImmatriculeMachine());
        intrant.setMacineId(machine.getId());
        intrant.setCreatedDate(date);
        return intrantRepository.save(intrant);
    }

    public Intrant show(String name){
        return intrantRepository.findByIntrantName(name);
    }

    public List<Intrant> all(){
        return intrantRepository.findAll();
    }

    public void delete(Long id){
        intrantRepository.deleteById(id);
    }

    public Intrant update(Intrant intrant){
        return intrantRepository.save(intrant);
    }

}
