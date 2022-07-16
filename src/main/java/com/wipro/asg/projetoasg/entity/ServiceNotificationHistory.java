package com.wipro.asg.projetoasg.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_service_history")
public class ServiceNotificationHistory implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private VehicleDetails  vehicleId;
    private String  NotificationMessage;
    private Instant NotificationSentDate;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;


    public ServiceNotificationHistory() {
    }

    public ServiceNotificationHistory(Long id, VehicleDetails vehicleId,
                                      String notificationMessage,
                                      Instant notificationSentDate) {
        this.id = id;
        this.vehicleId = vehicleId;
        NotificationMessage = notificationMessage;
        NotificationSentDate = notificationSentDate;
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

    public String getNotificationMessage() {
        return NotificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        NotificationMessage = notificationMessage;
    }

    public Instant getNotificationSentDate() {
        return NotificationSentDate;
    }

    public void setNotificationSentDate(Instant notificationSentDate) {
        NotificationSentDate = notificationSentDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    @PrePersist
    public void preCreat(){
        this.createdAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceNotificationHistory that = (ServiceNotificationHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
