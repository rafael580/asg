package com.wipro.asg.projetoasg.repository;


import com.wipro.asg.projetoasg.entity.VehicleServiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleServiceHistoryRepository extends JpaRepository<VehicleServiceHistory,Long> {
}
