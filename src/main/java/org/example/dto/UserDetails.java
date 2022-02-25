package org.example.dto;


import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity // if name given then table name will be this instead of class name - This is for the whole entity name
@Table (name = "USER_DETAILS") // use this as the table name instead of class name - this is only for the DB table name not the whole Entity
public class UserDetails {
    //@Id //This is the primary key for DB
    @Id @GeneratedValue(strategy = GenerationType.AUTO) // Types can be Identity /Sequence /Table
    private int userId;
    @Column (name= "USER_NAME")
    @Basic // Member Variable will be persisted inDB
    private String userName;
    private String department;
    /*
    // Use Case : To store Office and Home address as Value Type as part of User_Details
    @Embedded // used for Value Types - have to associated with Entity
    //Override column name for Value Types-- @AttributeOverride for single Column
    //@AttributeOverride(name = "street" , column = @Column (name="HOME_STREET_NAME"))
    @AttributeOverrides ({
            @AttributeOverride(name = "streetName" , column = @Column (name="HOME_STREET_NAME")),
            @AttributeOverride(name = "city" , column = @Column (name="HOME_CITY")),
            @AttributeOverride(name = "state" , column = @Column (name="HOME_STATE")),
            @AttributeOverride(name = "pinCode" , column = @Column (name="HOME_ZIP_CODE"))
    })
    private Address home_address;
    @Embedded
    private Address office_address;
    public Address getHome_address() {
        return home_address;
    }
    public void setHome_address(Address home_address) {
        this.home_address = home_address;
    }

    public void setOffice_address(Address office_address) {
        this.office_address = office_address;
    }
    public Address getOffice_address() {
        return office_address;
    } */
    /*
    // Use Case : If have to store the list of address that the user had lived so far : Collections
    @ElementCollection // Tells hibernate to handle address as different TAble
    // To give a different Table Name other than default and column name (instead UserDetails_listOfAddress and UserDetails_userId)
    @JoinTable (name ="USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    private Set<Address> listOfAddress = new HashSet<>();

    public Set<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Set<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

     */
    @ElementCollection // Tells hibernate to handle address as different TAble
    // To give a different Table Name other than default and column name (instead UserDetails_listOfAddress and UserDetails_userId)
    @JoinTable (name ="USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    @GenericGenerator(name="increment-gen",strategy="increment")
    @CollectionId(
            columns = { @Column(name="ADDRESS_ID")},
            type = @Type(type = "long"),
            generator = "increment-gen"
    )
    private Collection<Address> listOfAddress = new ArrayList<>();

    public Collection<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Collection<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

    //@LOB for large data  CLOB for char and BLOB for byte  if DT is String then it is CLOB
    // Annotations can be placed on top of getters also instead of column name
    //@Transient // This column will not be saved in DB
    @Lob
    private String description;

    @Temporal(TemporalType.DATE) //Always with timestamp we can be specific
    private Date joining_Date;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getJoining_Date() {
        return joining_Date;
    }

    public void setJoining_Date(Date joining_Date) {
        this.joining_Date = joining_Date;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
