package hiber.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import web.model.Car;

import java.util.Properties;

public class Util {

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.connection.username", "bestuser");
        prop.setProperty("hibernate.connection.password", "bestuser");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("hibernate.show_sql", "true");

        try {
            sessionFactory = new Configuration().addAnnotatedClass(Car.class)
                .buildSessionFactory(new StandardServiceRegistryBuilder()
                    .applySettings(prop).build());
        } catch (HibernateException e) {
            System.err.println("Failed to create sessionFactory object." + e);
            e.printStackTrace();
        }

        return sessionFactory;
    }
}
