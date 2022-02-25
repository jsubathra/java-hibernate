package org.example.dto;

import javax.persistence.*;

@Entity
/*
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //This is the base class
//nBase class and child class will have seperate tables // The child class will have the columns of the base class
@DiscriminatorColumn
        (name="VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING
) // The user specified column name and datatype for the DTYPE column
@DiscriminatorValue("VEHICLE")

 */
/*
// If Inheritance type is Table Per class then no discriminator column or value not needed
//duplicated
// The vehicle and TwoWheeler and FourWheeler will all be seperate tables.
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
 */

//The base class will have the vehicleid and name of the child classes also
//Child class will have the vehicleid(as foreign key from base)and its members
@Inheritance(strategy = InheritanceType.JOINED)
public class VehicleInheritance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name="VEHICLE_ID") //DTYPE in the vehicleClass will give the class name of the class - the descriminator class name
    private int vehicleId;
    private String vehicleName;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
