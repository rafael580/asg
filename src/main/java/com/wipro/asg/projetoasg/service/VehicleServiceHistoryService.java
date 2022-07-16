package com.wipro.asg.projetoasg.service;

import com.wipro.asg.projetoasg.entity.VehicleServiceHistory;
import com.wipro.asg.projetoasg.repository.VehicleServiceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VehicleServiceHistoryService {

    @Autowired
    private VehicleServiceHistoryRepository vehicleServiceHistory;

    public List<VehicleServiceHistory> listar(){
        List<VehicleServiceHistory> vehicleServiceHistories = vehicleServiceHistory.findAll();
        if(Objects.isNull(vehicleServiceHistories)){
            return null;
        }
        return vehicleServiceHistories;
    }

    public VehicleServiceHistory criar(VehicleServiceHistory vh){
        if(Objects.isNull(vh)){
            return null;
        }
        return vehicleServiceHistory.save(vh);
    }
}
