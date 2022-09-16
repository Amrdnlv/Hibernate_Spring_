package Entity;

import Entity.Emploee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Emploee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Emploee emp = new Emploee("Roman", "Danilov", "ID", "50000");
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }


    }
}
