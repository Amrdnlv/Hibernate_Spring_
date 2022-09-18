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
        Session session = null;
        try {
           session = factory.getCurrentSession();
            Emploee emp = new Emploee("Roman", "Danilov", "ID", 50000);
            session.beginTransaction();
            session.save(emp);
            int getid = emp.getId(); // получение созданного работника
            Emploee employ = session.get(Emploee.class, getid);
            //создание Select по айди
            System.out.print(employ);


          //HQL запрос Получение всех работников
            List <Emploee> emploees= session.createQuery("FROM Emploee").getResultList();
            for (Emploee e: emploees)
                System.out.print(e);
            //поиск работников с именем Roman
            List <Emploee> emploeess= session.createQuery("FROM Emploee WHERE name = 'Roman'").getResultList();
            for (Emploee e: emploeess)
                System.out.print(e);

            //Обновление записи работника, обновляем зарплату
            Emploee employeUp = session.get(Emploee.class, 4);
            //employeUp.setSalary(1500);

            //Обновляем данные запролаты у сотрудников по имени Роман
            // session.createQuery("update Emploee set salary = 10000 where  name = 'Roman'").executeUpdate();


            //Удаление работника
            session.delete(employeUp); //удаление обновленного сотрудника
            System.out.println("Delete employeee");

            //Удаление по критерию
            //session.createQuery("delete Emploee where name = 'Roman'");




        }finally {
            session.getTransaction().commit();
            factory.close();
        }


    }
}
