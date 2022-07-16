package com.wipro.asg.projetoasg.controller;

import com.wipro.asg.projetoasg.entity.VehicleServiceHistory;
import com.wipro.asg.projetoasg.service.VehicleServiceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class VehicleServiceHistoryController {

    @Autowired
    private VehicleServiceHistoryService repository;

    @GetMapping("/VehicleServiceHistory/Index/listar")
    public ResponseEntity<List<VehicleServiceHistory>> listarHistory(){
        return ResponseEntity.ok().body(repository.listar());
    }

    @PostMapping("/VehicleServiceHistory/Create/criar")
    public ResponseEntity<VehicleServiceHistory> criarHistory(@RequestBody VehicleServiceHistory vh){
        return ResponseEntity.ok().body(repository.criar(vh));
    }
}
