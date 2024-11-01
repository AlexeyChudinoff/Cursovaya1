import java.util.Random;

public class EmployeeBook {

  private static final Employee[] massivEmployees = new Employee[10];

  private final Random random = new Random();

  private final String[] firstName = {"Иван", "Сергей", "Петр", "Максим", "Олег"};
  private final String[] lastName = {"Иванов", "Сергеев", "Петров", "Максимов", "Олегов"};
  private final String[] patronymic = {"Иванович", "Сергеевич", "Петрович", "Олегович"};

  public void greatEmpioyee() {
    for (int i = 0; i < massivEmployees.length; i++) {
      String fullname = lastName[random.nextInt(0, lastName.length)] + " "
          + firstName[random.nextInt(0, firstName.length)] + " "
          + patronymic[random.nextInt(0, patronymic.length)];
      massivEmployees[i] = new Employee(fullname, random.nextInt(1, 6),
          random.nextInt(50000, 100000));
    }
  }

  //печатает фамилии всех сотрудников
  public void printLastName() {
    for (Employee sotrudnik : massivEmployees) {
      if (sotrudnik == null) {
        continue;
      }
      System.out.println(sotrudnik.getFullname());
    }
  }

  //вычисляет среднюю зп
  public float calculatingAverageSalary() {
    float average = (float) calculatingSumSalary() / massivEmployees.length;
    return average;
  }

  // вычисляет сотрудника с максимальной зп
  public Employee calculatingSotrudnikMaxSalary() {
    Employee employeeWithMaxSalary = massivEmployees[0];
    for (Employee employee : massivEmployees) {
      if (employee == null) {
        continue;
      }
      if (employeeWithMaxSalary == null
          || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
        employeeWithMaxSalary = employee;
      }
    }
    return employeeWithMaxSalary;
  }

  // вычисляет сотрудника с минимальной зп
  public Employee calculatingSotrudnikMinSalary() {
    Employee employeeWithMinSalary = massivEmployees[0];
    for (Employee employee : massivEmployees) {
      if (employee == null) {
        continue;
      }
      if (employeeWithMinSalary == null
          || employee.getSalary() < employeeWithMinSalary.getSalary()) {
        employeeWithMinSalary = employee;
      }
    }
    return employeeWithMinSalary;
  }

  //вычисляет сумму всех затрат на зп
  public int calculatingSumSalary() {
    int sum = 0;
    for (Employee sotrudnik : massivEmployees) {
      if (sotrudnik == null) {
        continue;
      }
      sum = sum + sotrudnik.getSalary();
    }
    return sum;
  }

  //печатает список всех сотрудников
  public void printListEmployees() {
    for (int i = 0; i < massivEmployees.length; i++) {
      String sotrudnik = String.valueOf(massivEmployees[i]);
      System.out.println(sotrudnik);
    }
  }

  //индексирует зп всех сотрудников на заданный процент
  public int indexSalaryAll(int procent) {
    int newSalary = 0;
    System.out.println("Зарплата всех соттрудников проиндексированная на : "
        + procent + " процентов : ");
    for (Employee sotrudnik : massivEmployees) {
      if (sotrudnik == null) {
        continue;
      }
      newSalary = sotrudnik.getSalary() + sotrudnik.getSalary() * procent / 100;
      sotrudnik.setSalary(newSalary);
      System.out.println(sotrudnik.getFullname() + " : " + sotrudnik.getSalary());
    }
    return newSalary;
  }

  //индексирует зарплату сотрудников заданного отдела на заданный процент
  public int indexSalaryOtdel(int procent, int otdel) {
    int newSalary = 0;
    System.out.println("Зарплата сотрудников " + otdel + " отдела" +
        " проиндексированная на : " + procent + " процентов : ");
    for (Employee sotrudnik : massivEmployees) {
      if (sotrudnik == null) {
        continue;
      }
      if (sotrudnik.getOtdel() == otdel) {
        newSalary = sotrudnik.getSalary() + sotrudnik.getSalary() * procent / 100;
        sotrudnik.setSalary(newSalary);

        System.out.println(sotrudnik.getFullname() + " : " + sotrudnik.getSalary());
      }
    }
    return newSalary;
  }

  //печать сотрудников заданного отдела
  public void printListOtdela(int otdel) {
    System.out.println("Сотрудники " + otdel + " отдела");
    for (Employee sotrudnik : massivEmployees) {
      if (sotrudnik == null) {
        continue;
      }
      if (sotrudnik.getOtdel() == otdel) {
        System.out.println(sotrudnik.getId() + " " + sotrudnik.getFullname() + " " +
            sotrudnik.getSalary());
      }
    }
  }

  // сравнение зп сотрудников с заданной зп
  public void compareSalary(int zp) {
    for (Employee sotrudnik : massivEmployees) {
      if (sotrudnik == null) {
        continue;
      }
      if (sotrudnik.getSalary() < zp) {
        System.out.println("Зарплата сотрудника меньше: " + zp + ":" + sotrudnik.getId() + " " +
            sotrudnik.getFullname() + " " + sotrudnik.getSalary());
      } else {
        System.out.println("Зарплата сотрудника больше " + zp + ": " + sotrudnik.getId() + " " +
            sotrudnik.getFullname() + " " + sotrudnik.getSalary());
      }
    }
  }

  // удаление сотрудника по заданному ID
  public void delEmployee(int id) {
    for (int i = 0; i < massivEmployees.length; i++) {
      if (i == id - 1) {
        massivEmployees[i] = null;
      }
    }
  }

  //добавление сотрудника с предварительной проверкой возможности
  public void insEmployee(String fullname, int otdel, int salary) {
    Employee newEmoloyee = new Employee(fullname, otdel, salary);
    String answer = "Нельзя добавить сотрудника " + fullname + ", нет свободных мест ";
    for (int i = 0; i < massivEmployees.length; i++) {
      if (massivEmployees[i] == null) {
        answer = "Можно добавить сотрудника, есть свободное место ";
        massivEmployees[i] = newEmoloyee;
        System.out.println(" Добавиляем :" + fullname );
        break;
      }
    }
    System.out.println(answer);
  }
//поиск сотрудника по ID
  public void findToId(int id) {
    for (int i = 0; i < massivEmployees.length; i++) {
      if (i == id - 1) {
        String sotrudnik = String.valueOf(massivEmployees[i]);
        System.out.println(sotrudnik);
      }
    }
  }

}