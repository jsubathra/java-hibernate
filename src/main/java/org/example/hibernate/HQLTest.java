package org.example.hibernate;

import org.example.dto.FourWheeler;
import org.example.dto.TwoWheeler;
import org.example.dto.Users;
import org.example.dto.VehicleInheritance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import java.util.List;

public class HQLTest {

    public static void main(String[] args) {
        Users users = new Users();


        SessionFactory sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        /*
        for(int i =1 ; i <= 10; i++){
            Users user = new Users();
            user.setUserName("User " + i);
            session.save(user);
        } */

        Query query = session.createQuery("from Users where userId > 5"); // Have to give the classname and memeber variables
                                                                            // instead of table name and column name in DB

        List<Users> usersList =  (List<Users>) query.list();


        System.out.println(usersList.size());


        session.getTransaction().commit();
        session.close();


    }
    public static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        //Mapping in config file not working
        configObj.addAnnotatedClass(Users.class);

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
}
