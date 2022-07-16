package com.wipro.asg.projetoasg.controller;

import com.wipro.asg.projetoasg.entity.VehicleDetails;
import com.wipro.asg.projetoasg.service.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class VehicleDetailsController {

    @Autowired
    private VehicleDetailsService vehicleDetailsService;


    @GetMapping("/VehicleDetails/index/listar")
    public ResponseEntity<List<VehicleDetails>> listarTodos(){
        return ResponseEntity.ok().body(vehicleDetailsService.pegarVehiculos());
    }

    @PostMapping("/VehicleDetails/Create/criar")
    public ResponseEntity<VehicleDetails> criar(@RequestBody VehicleDetails vh){
        return ResponseEntity.ok().body(vehicleDetailsService.criarVeiculo(vh));
    }

    @PutMapping("/VehicleDetails/Edit/{id}/editar")
    public ResponseEntity<VehicleDetails> editar(@PathVariable Long id,@RequestBody VehicleDetails vh){
        return ResponseEntity.ok().body(vehicleDetailsService.atualizarId(id,vh));
    }

}
