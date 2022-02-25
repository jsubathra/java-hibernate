package org.example.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name ="NEWUSERDETAILS")
public class NewUserDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int UserId;
    private String UserName;
    /*
    @OneToOne
    @JoinColumn (name="VEHICLE_ID")
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    */
/*
    //#####ONE TO MANY #######
    @OneToMany
    @JoinTable(name="USER_VEHICLE", joinColumns = @JoinColumn(name="USER_ID"),
            inverseJoinColumns =@JoinColumn(name="VEHICLE_ID")
            )
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle> ();

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }
    */
    /* ######ONETOMANY #########
    @OneToMany(mappedBy = "userdet") // where the mapping has to happen -- create a column in vehicle table for the mapping
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle> ();

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

     */

   // @ManyToMany // Bidirectional - entries in both tables and 2 seperate mapping table
    @ManyToMany(mappedBy = "userdet") // Bidirectional - entries in both tables and mapped only one table
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle> ();

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
