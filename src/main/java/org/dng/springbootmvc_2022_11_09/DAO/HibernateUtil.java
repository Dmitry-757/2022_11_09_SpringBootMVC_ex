package org.dng.springbootmvc_2022_11_09.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;


public class HibernateUtil {
//    private static final SessionFactory sessionFactory;
//    static {
//        try {
//            Properties properties= new Properties();
//            properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/students");
//            properties.setProperty("hibernate.connection.username", "root");
//            properties.setProperty("hibernate.connection.password", "dingo1975");
//            properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//            properties.setProperty("hibernate.hbm2ddl.auto", "create");
//
//            sessionFactory = new Configuration()
//                    .addPackage("org.dng.springbootmvc_2022_11_09.DAO")//package where entity is placed
//                    .addProperties(properties)
////                    .addAnnotatedClass(myEntity1.class)
//                    .buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//    public static Session getSession()
//            throws HibernateException {
//        return sessionFactory.openSession();
//    }
}
