package org.example.hibernate;

import org.example.dto.Address;
import org.example.dto.NewUserDetails;
import org.example.dto.UserDetails;
import org.example.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

public class HibernateTest {
    public static void main(String [] args){
        SessionFactory sessionfactory = buildSessionFactory();
        NewUserDetails user = new NewUserDetails();
        user.setUserName("Subathra");

        Address addr = new Address();
        addr.setStreetName("10638 Gardena Ct");
        addr.setCity("Cupertino");
        addr.setState("California");
        addr.setPinCode("95014");

        Address addr2 = new Address();
        addr2.setStreetName("LinkedIn St");
        addr2.setCity("Sunnyvalue");
        addr2.setState("California");
        addr2.setPinCode("95087");


        //One to One
        //user.setVehicle(vehicle);

        //One to Many
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Bus");

        user.getVehicle().add(vehicle);
        user.getVehicle().add(vehicle2);

        //Many to One
       // vehicle.setUser(user);
       // vehicle2.setUser(user);

        //Many To Many
        vehicle.getUserdet().add(user);
        vehicle2.getUserdet().add(user);

        Session session = sessionfactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();


    }

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        //Mapping in config file not working
        configObj.addAnnotatedClass(NewUserDetails.class);
        configObj.addAnnotatedClass(Vehicle.class);
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
}
