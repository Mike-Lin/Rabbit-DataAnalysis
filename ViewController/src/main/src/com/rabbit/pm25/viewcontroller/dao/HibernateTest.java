package com.rabbit.pm25.viewcontroller.dao;

import com.rabbit.pm25.data.domain.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* Created with IntelliJ IDEA.
* User: Mac
* Date: 13-8-19
* Time: 上午12:37
* To change this template use File | Settings | File Templates.
*/
public class HibernateTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        Configuration cfg = new Configuration();
        cfg.configure(); // 重要
        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        try {
            sessionFactory = cfg.configure()
                    .addAnnotatedClass(City.class)
                    .buildSessionFactory(sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        City city = new City();
        city.setName("北京");

        session.persist(city);
        tx.commit();
        session.close();
        System.out.println("end");
    }

    public static void main() {

    }

    @After
    public void tearDown() throws Exception {

        sessionFactory.close();

        System.out.println("tearDown");
    }
}
