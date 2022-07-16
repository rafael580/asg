package com.wipro.asg.projetoasg.service;

import com.wipro.asg.projetoasg.entity.VehicleDetails;
import com.wipro.asg.projetoasg.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VehicleDetailsService {

    private final VehicleRepository vehicleRepository;

    public VehicleDetailsService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDetails> pegarVehiculos(){
        List<VehicleDetails> vehicleDetails = vehicleRepository.findAll();
        if(Objects.isNull(vehicleDetails)){
            return null;
        }
        return vehicleDetails;
    }
    public VehicleDetails criarVeiculo(VehicleDetails vh){
        if(Objects.isNull(vh)){
            return null;
        }
        return vehicleRepository.save(vh);
    }

    public VehicleDetails atualizarId(Long id, VehicleDetails atualizado){
        Optional<VehicleDetails> vehicleDetails = vehicleRepository.findById(id);
        VehicleDetails vh = vehicleDetails.orElse(null);
        vh.setChassisNumber(atualizado.getChassisNumber());
        vh.setUser(atualizado.getUser());
        vh.setPurchaseDate(atualizado.getPurchaseDate());
        vh.setMakeMonthYear(atualizado.getMakeMonthYear());
        vh.setCurrentOdometerReading(atualizado.getCurrentOdometerReading());
        vh.setVehicleRegNumber(atualizado.getVehicleRegNumber());
        vh.setEngineNumber(atualizado.getEngineNumber());
        vh.setMake(atualizado.getMake());
        vh.setChassisNumber(atualizado.getChassisNumber());
        return vehicleRepository.save(vh);
    }
}
