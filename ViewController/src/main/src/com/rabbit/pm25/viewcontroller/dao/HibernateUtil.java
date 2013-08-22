package com.rabbit.pm25.viewcontroller.dao;

import com.rabbit.pm25.data.domain.City;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-15
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory configureSessionFactory() throws HibernateException {

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

        return sessionFactory;
    }


}
