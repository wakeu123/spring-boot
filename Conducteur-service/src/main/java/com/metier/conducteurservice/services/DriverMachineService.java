package com.metier.conducteurservice.services;

import com.metier.conducteurservice.entities.DriverMachine;
import com.metier.conducteurservice.exceptions.ResourceNotFoundException;
import com.metier.conducteurservice.repositories.DriverMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


@Service
@Transactional
public class DriverMachineService
{
    @Autowired
    private DriverMachineRepository driverMachineRepository;

    public DriverMachine addDriverMachine(DriverMachine driverMachine)  {
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

        driverMachine.setCreateDate(date);
        driverMachine.setCreateTime(heure);
        driverMachineRepository.save(driverMachine);
        return driverMachine;
    }

    public List<DriverMachine> all(){
        List<DriverMachine>  listeDrivers = driverMachineRepository.findAll();
        if (listeDrivers != null && !listeDrivers.isEmpty()){
            return listeDrivers;
        }
        else {
            throw  new ResourceNotFoundException("Driver Machine List is Empty");
        }
    }

    public void deleteDriverMachine(String matricule){
        List<DriverMachine> driver = driverMachineRepository.findByMatriculeContains(matricule);
        if(driver.size() == 1){
            driverMachineRepository.delete(driver.get(0));
        }
        else{
            //System.out.println("ERROR IN MATRICULE" + matricule);
            throw  new ResourceNotFoundException("Driver Machine Not Found With Matricule = " + matricule);
        }


    }

    public DriverMachine getDriverMachineById(Long id){
        return driverMachineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver Machine Not Found With Id = " + id));
    }

    public DriverMachine updateDriver(DriverMachine driverMachine, Long id){
        DriverMachine driver = this.driverMachineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver Machine Not Found With Id = " + id));
        driver.setBirthDay(driverMachine.getBirthDay());
        driver.setAdress(driverMachine.getAdress());
        driver.setCni(driverMachine.getCni());
        driver.setEmail(driverMachine.getEmail());
        driver.setMatricule(driverMachine.getMatricule());
        driver.setName(driverMachine.getName());
        driver.setNumberPhone(driverMachine.getNumberPhone());
        driver.setSecondName(driverMachine.getSecondName());
        return this.driverMachineRepository.save(driver);
    }
}
