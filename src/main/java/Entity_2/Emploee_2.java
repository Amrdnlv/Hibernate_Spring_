package Entity_2;

import javax.persistence.*;

@Entity
@Table(name = "employee_2")
public class Emploee_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private Integer salary;
    @OneToOne(cascade = CascadeType.ALL)//указываем принцип связи, и тип каскада тип удаление всех заввисимых полей
    @JoinColumn(name = "details_id") //на какой столбец ссылается,
    // по какому полю идет соединение
    private Details empDetail;

    public Emploee_2(){}

    public Emploee_2(String name, String surname, String department, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emploee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
