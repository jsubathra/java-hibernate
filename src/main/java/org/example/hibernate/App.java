package org.example.hibernate;

import org.example.dto.Address;
import org.example.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String [] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactoryObj  = buildSessionFactory();
        UserDetails user = new UserDetails();
        //user.setUserId(1);
        user.setUserName("Subathra");
        user.setDepartment("Engg");
        user.setJoining_Date(new Date());
        user.setDescription("This is the description for the LOB  datatype instead of varchar 255");
        Address addr = new Address();
        addr.setStreetName("10638 Gardena Ct");
        addr.setCity("Cupertino");
        addr.setState("California");
        addr.setPinCode("95014");
       // user.setHome_address(addr);
        user.getListOfAddress().add(addr);

        Address addr2 = new Address();
        addr2.setStreetName("LinkedIn St");
        addr2.setCity("Sunnyvalue");
        addr2.setState("California");
        addr2.setPinCode("95087");
       // user.setOffice_address(addr2);
        user.getListOfAddress().add(addr2);


        Session session =  sessionFactoryObj.openSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        user = null;
        session = sessionFactoryObj.openSession();
        session.beginTransaction();
        user = (UserDetails) session.get(UserDetails.class, 1);

        System.out.println("User Details ====> "+ user.getUserId() + "  " + user.getUserName() + " " + user.getDepartment() + " " + user.getJoining_Date() +
                " " + user.getDescription() + " ");
    }

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(UserDetails.class);
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;

    }
}