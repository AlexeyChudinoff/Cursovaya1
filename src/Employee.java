import java.util.Objects;

public class Employee {

  private static int schetchic = 1;

  private final int id;
  private final String fullname;
  private int otdel;
  private int salary;

//конструктор заполнения данных сотрудника
  public Employee(String fullname, int otdel, int salary) {
    this.fullname = fullname;
    this.otdel = otdel;
    this.salary = salary;
    this.id = schetchic++;

  }


  public String getFullname() {
    return fullname;
  }

  public int getOtdel() {
    return otdel;
  }

  public void setOtdel(int otdel) {
    this.otdel = otdel;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return otdel == employee.otdel && salary == employee.salary && id == employee.id
        && Objects.equals(fullname, employee.fullname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullname, otdel, salary, id);
  }

  @Override
  public String toString() {
    return
        "Номер : " + id +
            " , Ф.И.О. :  " + fullname +
            " , Отдел : " + otdel +
            " , Зарплата : " + salary
        ;
  }
}
