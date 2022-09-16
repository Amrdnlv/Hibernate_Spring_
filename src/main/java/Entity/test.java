package Entity;

import Entity.Emploee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
            int getid = emp.getId();
            Emploee employ = session.get(Emploee.class, getid);
            //создание Select по айди
            System.out.print(employ);

            //HQL запрос Получение всех работников
            List <Emploee> emploees= session.createQuery("FROM Emploee").getResultList();
            for (Emploee e: emploees)
                System.out.print(e);
            List <Emploee> emploeess= session.createQuery("FROM Emploee WHERE name = 'Roman'").getResultList();
            for (Emploee e: emploeess)
                System.out.print(e);



            session.getTransaction().commit();
        }finally {
            factory.close();
        }


    }
}
