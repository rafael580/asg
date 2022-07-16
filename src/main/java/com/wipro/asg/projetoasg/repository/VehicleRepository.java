package com.wipro.asg.projetoasg.repository;


import com.wipro.asg.projetoasg.entity.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleDetails,Long> {

}
