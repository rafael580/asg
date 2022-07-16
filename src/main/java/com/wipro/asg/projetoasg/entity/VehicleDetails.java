package com.wipro.asg.projetoasg.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_vehicle")
public class VehicleDetails implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long VehicleId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserDetails user;

    private String  VehicleRegNumber;
    private String   ChassisNumber;
    private String    EngineNumber;
    private String    Make ;
    private Integer  MakeMonthYear ;
    private Date PurchaseDate;
    private Integer CurrentOdometerReading ;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updateAt;

    public VehicleDetails(){}

    public VehicleDetails(UserDetails user, String vehicleRegNumber, String chassisNumber,
                          String engineNumber, String make, Integer makeMonthYear, Date purchaseDate,
                          Integer currentOdometerReading) {
        this.user = user;
        VehicleRegNumber = vehicleRegNumber;
        ChassisNumber = chassisNumber;
        EngineNumber = engineNumber;
        Make = make;
        MakeMonthYear = makeMonthYear;
        PurchaseDate = purchaseDate;
        CurrentOdometerReading = currentOdometerReading;
    }

    public Long getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        VehicleId = vehicleId;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public String getVehicleRegNumber() {
        return VehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        VehicleRegNumber = vehicleRegNumber;
    }

    public String getChassisNumber() {
        return ChassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        ChassisNumber = chassisNumber;
    }

    public String getEngineNumber() {
        return EngineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        EngineNumber = engineNumber;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public Integer getMakeMonthYear() {
        return MakeMonthYear;
    }

    public void setMakeMonthYear(Integer makeMonthYear) {
        MakeMonthYear = makeMonthYear;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public Integer getCurrentOdometerReading() {
        return CurrentOdometerReading;
    }

    public void setCurrentOdometerReading(Integer currentOdometerReading) {
        CurrentOdometerReading = currentOdometerReading;
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
        VehicleDetails that = (VehicleDetails) o;
        return Objects.equals(VehicleId, that.VehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VehicleId);
    }
}
