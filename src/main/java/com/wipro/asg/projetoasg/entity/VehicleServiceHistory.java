package com.wipro.asg.projetoasg.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_vehicle_service")
public class VehicleServiceHistory implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private VehicleDetails  vehicleId;
    private  Integer odometerReading;
    private Date serviceDoneDate;
    private String  serviceDetails;
    private String  serviceDealerDetails;
    private Date nextServiceDueDate ;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updateAt;


    public VehicleServiceHistory() {
    }

    public VehicleServiceHistory(Long id, VehicleDetails vehicleId,
                                 Integer odometerReading,
                                 Date serviceDoneDate,
                                 String serviceDetails, String serviceDealerDetails,
                                 Date nextServiceDueDate) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.odometerReading = odometerReading;
        this.serviceDoneDate = serviceDoneDate;
        this.serviceDetails = serviceDetails;
        this.serviceDealerDetails = serviceDealerDetails;
        this.nextServiceDueDate = nextServiceDueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleDetails getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(VehicleDetails vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    public Date getServiceDoneDate() {
        return serviceDoneDate;
    }

    public void setServiceDoneDate(Date serviceDoneDate) {
        this.serviceDoneDate = serviceDoneDate;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public String getServiceDealerDetails() {
        return serviceDealerDetails;
    }

    public void setServiceDealerDetails(String serviceDealerDetails) {
        this.serviceDealerDetails = serviceDealerDetails;
    }

    public Date getNextServiceDueDate() {
        return nextServiceDueDate;
    }

    public void setNextServiceDueDate(Date nextServiceDueDate) {
        this.nextServiceDueDate = nextServiceDueDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    @PrePersist
    public void preCreat(){
        this.createdAt = Instant.now();
    }

    public Instant getUpdateAt() {
        return updateAt;
    }
    @PreUpdate
    public void UpdateCreat(){
        this.updateAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleServiceHistory that = (VehicleServiceHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
