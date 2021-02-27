package com.agrimachine.gestiondesmachinesagricoles.services;

import com.agrimachine.gestiondesmachinesagricoles.clients.DriverMachineClientService;
import com.agrimachine.gestiondesmachinesagricoles.entities.Machine;
import com.agrimachine.gestiondesmachinesagricoles.model.DriverMachine;
import com.agrimachine.gestiondesmachinesagricoles.repositories.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineServices
{
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private DriverMachineClientService driverMachineClientService;

    public List<Machine> getAll(){
        return machineRepository.findAll();
    }

    public Machine addMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    public void attachdriverToMachine(String refMachine, String driverName){
        Machine machine = machineRepository.findByMatriculeMachine(refMachine);
        DriverMachine driver = driverMachineClientService.getDriver(driverName);
        machine.setDriverMachineId(driver.getId());
    }

    public Machine updateMachine(Machine machine){
        Machine machine1 = machineRepository.getOne(machine.getId());
        machine1.setMachineName(machine.getMachineName());
        machine1.setTypeCarburation(machine.getTypeCarburation());
        machine1.setMatriculeMachine(machine.getMatriculeMachine());
        machine1.setDriverMachineId(machine.getDriverMachineId());
        return machineRepository.save(machine1);
    }

    public void deleteMachine(String matriculeMachine) {
        Machine machine = machineRepository.findByMatriculeMachine(matriculeMachine);
        if (machine.getDriverMachineId() != null){
            throw new RuntimeException("Cette machine ne peut pas etre supprimer car elle est lié à un conducteur");
        }
        machineRepository.deleteById(machine.getId());
    }

    public Machine getByImmatricule(String immatricule){
        return machineRepository.findByMatriculeMachine(immatricule);
    }

   /* public Machine getByDriverName(String name){
        DriverMachine driverMachine = driverMachineClientService.getDriver(name);
        return machineRepository.findByDriverMachineName(driverMachine.getName());
    }*/
}
