package org.example.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE") // By default will have TWOWHEELER but now will have Bike for all objects of TwoWheeler Class
public class TwoWheeler extends VehicleInheritance{
    // If TablePerClass strategy then child class will inherit id and name and also generatedValue so VehicleID will be
    // generated for its own
    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
