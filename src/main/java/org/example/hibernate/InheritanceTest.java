package org.example.hibernate;

import org.example.dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class InheritanceTest {

        public static void main(String[] args) {

            buildCRUDOperations();
            /*
            VehicleInheritance vehicleInheritance = new VehicleInheritance();
            vehicleInheritance.setVehicleName("Car");

            TwoWheeler twoWheeler = new TwoWheeler();
            twoWheeler.setVehicleName("Bike");
            twoWheeler.setSteeringHandle("Bike Streeing Handle");

            FourWheeler fourWheeler = new FourWheeler();
            fourWheeler.setVehicleName("Jeep");
            fourWheeler.setStreeingWheel("Jeep Streeing Wheel");

            SessionFactory sessionfactory = buildSessionFactory();
            Session session = sessionfactory.openSession();
            session.beginTransaction();

            session.save(vehicleInheritance);
            session.save(twoWheeler);
            session.save(fourWheeler);

            session.getTransaction().commit();
            session.close();

             */

        }

    private static void buildCRUDOperations() {
            SessionFactory sessionFactory =buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //Create Operation
            for(int i =1 ; i <= 10; i++){
                Users user = new Users();
                user.setUserName("User " + i);
                session.save(user);
            }
            //Read Operation
             Users user5 = (Users) session.get(Users.class,5);
             System.out.println("####" + user5.getUserName());

             //Update Operation
            user5.setUserName("Updated User5");
            session.update(user5);
            System.out.println("####" + user5.getUserName());

            //Delete Operation
           // session.delete(user5);


            session.getTransaction().commit();
            session.close();

            // After the session is closed the object becomes Detached Object.
            //Before the session.beginTransaction and session not saved then the object is Transient
            // After the session.save the username is updated still the DB gets updates.
            // Once you hand over the object to hibernate the object becomes persistent and gets saved in DB.
            // Hibernates detects the least amount of update it has to do. It will watch for changes and does update only

    }

    public static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        //Mapping in config file not working
        configObj.addAnnotatedClass(VehicleInheritance.class);
        configObj.addAnnotatedClass(TwoWheeler.class);
        configObj.addAnnotatedClass(FourWheeler.class);

        configObj.addAnnotatedClass(Users.class);


        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
}
