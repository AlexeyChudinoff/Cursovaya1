import java.util.Random;

public class EmployeeBook {

  private static Employee[] massivSotrudnikov = new Employee[10];

  private final Random random = new Random();

  private final String[] name = {"Иван", "Сергей", "Петр", "Максим", "Олег"};
  private final String[] familiya = {"Иванов", "Сергеев", "Петров", "Максимов", "Олегов"};
  private final String[] otchestvo = {"Иванович", "Сергеевич", "Петрович", "Олегович"};

  public void vvodSotrudnikov() {
    for (int i = 0; i < massivSotrudnikov.length; i++) {
      String fullname = familiya[random.nextInt(0, familiya.length)] + " "
          + name[random.nextInt(0, name.length)] + " "
          + otchestvo[random.nextInt(0, otchestvo.length)];
      massivSotrudnikov[i] = new Employee(fullname, random.nextInt(1, 6),
          random.nextInt(50000, 100000));
    }
  }

  public void printFamilii() {
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik == null) {
        continue;
      }
      System.out.println(sotrudnik.getFullname());
    }
  }

  public float sredSalary() {
   /* float sum = 0;
    for (Employee sotrudnik : massivSotrudnikov) {
      sum = sum + sotrudnik.getSalary();
    }
    float srednya = sum / massivSotrudnikov.length;
    */
    float srednya = sumSalars() / massivSotrudnikov.length;
    return srednya;
  }

  public Employee sotrudnikMaxSalary() {
    Employee sotrMaxSalary = null;
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik == null) {
        continue;
      }
      if (sotrMaxSalary == null || sotrudnik.getSalary() > sotrMaxSalary.getSalary()) {
        sotrMaxSalary = sotrudnik;
      }
    }
    return sotrMaxSalary;
  }

  public Employee sotrudnikMinSalary() {
    Employee sotrMinSalary = null;
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik == null) {
        continue;
      }
      if (sotrMinSalary == null || sotrudnik.getSalary() < sotrMinSalary.getSalary()) {
        sotrMinSalary = sotrudnik;
      }
    }
    return sotrMinSalary;
  }

  public int sumSalars() {
    int sum = 0;
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik == null) {
        continue;
      }
      sum = sum + sotrudnik.getSalary();
    }
    return sum;
  }

  public void printSotrudnikov() {
    for (int i = 0; i < massivSotrudnikov.length; i++) {
      String sotrudnik = String.valueOf(massivSotrudnikov[i]);
      System.out.println(sotrudnik);
      //for (Employee sotrudnik:massivSotrudnikov)
      // System.out.println("спис сотр " + sotrudnik);

    }
  }

  public int IndexSalaryAll(int procent) {
    int newSalary = 0;
    System.out.println("Зарплата проиндексированная на : " + procent + " процентов : ");
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik == null) {
        continue;
      }
      newSalary = sotrudnik.getSalary() + sotrudnik.getSalary() * procent / 100;
      sotrudnik.setSalary(newSalary);

      System.out.println(sotrudnik.getFullname() + " : " + sotrudnik.getSalary());

    }
    return newSalary;
  }

  public int IndexSalaryOtdel(int procent, int otdel) {
    int newSalary = 0;
    System.out.println("Зарплата сотрудников " + otdel + " отдела" +
        " проиндексированная на : " + procent + " процентов : ");
    for (Employee sotrudnik : massivSotrudnikov) {
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

  public void sotrudnikiOtdela(int otdel) {
    System.out.println("Сотрудники " + otdel + " отдела");
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik == null) {
        continue;
      }
      if (sotrudnik.getOtdel() == otdel) {
        System.out.println(sotrudnik.getId() + " " + sotrudnik.getFullname() + " " +
            sotrudnik.getSalary());
      }
    }
  }

  public void sravniSalary(int zp) {
    for (Employee sotrudnik : massivSotrudnikov) {
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

  public void delSotrudnika(int id) {
    for (int i = 0; i < massivSotrudnikov.length; i++) {
      if (i == id - 1) {
        massivSotrudnikov[i] = null;
      }
    }
  }


  public void insSotrudnika(String fullname, int otdel, int salary) {
    Employee newSotr = new Employee(fullname, otdel, salary);
    for (int i = 0; i < massivSotrudnikov.length; i++) {
      if (massivSotrudnikov[i] == null) {
        massivSotrudnikov[i] = newSotr;
        System.out.println("Список после insSotrudnika");
        printSotrudnikov();
        System.out.println(true);
        break;
      } else {
        System.out.println(false + "нет свободного места");
      }
    }
  }

  public void findPoId(int id) {
    for (int i = 0; i < massivSotrudnikov.length; i++) {
      if (i == id - 1) {
        String sotrudnik = String.valueOf(massivSotrudnikov[i]);
        System.out.println(sotrudnik);
      }
    }
  }


}
