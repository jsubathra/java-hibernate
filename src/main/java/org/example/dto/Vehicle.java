package org.example.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table (name="VEHICLE")
public class Vehicle {

    @Id @GeneratedValue
    private int Vehicle_Id;
    private String VehicleName;
    /*
    @ManyToOne // The vehicle can have user_id
    @JoinColumn(name="USER_ID")
    private NewUserDetails userdet;

    public NewUserDetails getUser() {
        return userdet;
    }

    public void setUser(NewUserDetails userdet) {
        this.userdet = userdet;
    }

     */
    @ManyToMany
    private Collection<NewUserDetails> userdet = new ArrayList<NewUserDetails>();

    public Collection<NewUserDetails> getUserdet() {
        return userdet;
    }

    public void setUserdet(Collection<NewUserDetails> userdet) {
        this.userdet = userdet;
    }

    public int getVehicle_Id() {
        return Vehicle_Id;
    }

    public void setVehicle_Id(int vehicle_Id) {
        Vehicle_Id = vehicle_Id;
    }

    public String getVehicleName() {
        return VehicleName;
    }

    public void setVehicleName(String vehicleName) {
        VehicleName = vehicleName;
    }
}
