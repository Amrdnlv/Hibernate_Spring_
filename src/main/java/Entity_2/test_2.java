package Entity_2;


import Entity_2.Emploee_2;
import Entity_2.Details;
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


           Emploee_2 employee = new Emploee_2("Roman", "Danilov",
                   "It", 500);
           Details detail = new Details("Kazan", "899993838","email@email.ru");
           System.out.println("done!");
           employee.setEmpDetail(detail); //добавляем классу
            //эмлои данные о классе детаил через сеттер, чтобы
            //класс наш класс знал
            session.beginTransaction();
            session.save(employee);


        }finally {
            //коммит сессии
            session.getTransaction().commit();
            //закрытие фактори
            factory.close();
        }


    }
}
