package Entity_2;

import Entity_2.Emploee_2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class test_2 {
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Emploee_2.class)
                .addAnnotatedClass(Details.class) //добавляем зависимый класс
                .buildSessionFactory();
        Session session = null;
        try {
           session = factory.getCurrentSession();
            Emploee_2 emp = new Emploee_2("Roman", "Danilov", "ID", 50000);
            session.beginTransaction();
            session.save(emp);
            int getid = emp.getId(); // получение созданного работника
            Emploee_2 employ = session.get(Emploee_2.class, getid);
            //создание Select по айди
            System.out.print(employ);


          //HQL запрос Получение всех работников
            List <Emploee_2> emploees= session.createQuery("FROM Emploee_2").getResultList();
            for (Emploee_2 e: emploees)
                System.out.print(e);
            //поиск работников с именем Roman
            List <Emploee_2> emploeess= session.createQuery("FROM Emploee_2 WHERE name = 'Roman'").getResultList();
            for (Emploee_2 e: emploeess)
                System.out.print(e);

            //Обновление записи работника, обновляем зарплату
            Emploee_2 employeUp = session.get(Emploee_2.class, 4);
            //employeUp.setSalary(1500);

            //Обновляем данные запролаты у сотрудников по имени Роман
            // session.createQuery("update Emploee set salary = 10000 where  name = 'Roman'").executeUpdate();


            //Удаление работника
            session.delete(employeUp); //удаление обновленного сотрудника
            System.out.println("Delete employeee");

            //Удаление по критерию
            //session.createQuery("delete Emploee where name = 'Roman'");
        }finally {
            //коммит сессии
            session.getTransaction().commit();
            //закрытие фактори
            factory.close();
        }


    }
}
