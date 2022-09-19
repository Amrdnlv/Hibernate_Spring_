package Entity_2;


import Entity_2.Emploee_2;
import Entity_2.Details;
import net.bytebuddy.asm.MemberSubstitution;
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

//           session = factory.getCurrentSession();
//           Emploee_2 employee = new Emploee_2("Roman", "Danilov",
//                   "It", 500);
//           Details detail = new Details("Kazan", "899993838","email@email.ru");
//           System.out.println("done!");
//           employee.setEmpDetail(detail); //добавляем классу
//            //эмлои данные о классе детаил через сеттер, чтобы
//            //класс наш класс знал
//            session.beginTransaction();
//            session.save(employee);

            //получение деталей работника с айди
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Emploee_2 emp_2 = session.get(Emploee_2.class,1);
//            System.out.println(emp_2.getEmpDetail());

//            //каскадное удаление работника
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Emploee_2 emp_2 = session.get(Emploee_2.class,2);
//            session.delete(emp_2);
            session = factory.getCurrentSession();
            session.beginTransaction();
            Emploee_2 emp = new Emploee_2("Vasuya", "Pupkin", "HR", 500);
            Details detail = new Details("Mascow", "806352493", "vas@mail.ru");
            emp.setEmpDetail(detail);
            detail.setEmp(emp);
            session.save(detail);
        }finally {
            //коммит сессии
            session.getTransaction().commit();
            //закрытие фактори
            factory.close();
        }


    }
}
