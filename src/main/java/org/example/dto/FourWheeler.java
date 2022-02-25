package org.example.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")
public class FourWheeler extends  VehicleInheritance{
    private String streeingWheel;

    public String getStreeingWheel() {
        return streeingWheel;
    }

    public void setStreeingWheel(String streeingWheel) {
        this.streeingWheel = streeingWheel;
    }
}
