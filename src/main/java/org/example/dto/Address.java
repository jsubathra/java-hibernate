package org.example.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// Here Address is not a table but will be stored in UserDetails as columns
//Address saved as Object in User_Details, and it has member variables
@Embeddable
public class Address {
    @Column (name= "STREET_NAME")
    private String streetName;
    @Column (name= "CITY")
    private String city;
    @Column (name= "STATE")
    private String state;
    @Column (name= "ZIP_CODE")
    private String pinCode;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

}
