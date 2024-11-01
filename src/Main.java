import java.util.Random;

public class Main {


  public static void main(String[] args) {

    vvodSotrudnikov();
    System.out.println("Полный список сотрудников: ");
    printSotrudnikov();
    System.out.println();
    System.out.println("Сумма затрат на зарплату в месяц: " + sumSalars());
    System.out.println("Сотрудник с минимальной зарплатой: " + sotrudnikMinSalary());
    System.out.println("Сотрудник с максимальной зарплатой: " + sotrudnikMaxSalary());
    System.out.println("Средняя зарплата: " + sredSalary());
    System.out.println();
    System.out.println("Ф.И.О. Сотрудников: ");
    printFamilii();
    System.out.println();

    IndexSalaryAll(10);
    System.out.println();

    IndexSalaryOtdel(15,2);
    System.out.println();

    sotrudnikiOtdela(2);
    System.out.println();

    sravniSalary(80000);
    System.out.println();



  }

  // private static void printSotrudnikov() {
//for (int i = 0; i < massivSotrudnikov.length; i++) {
  //  String sotrudnik = String.valueOf(massivSotrudnikov[i]);
  //   System.out.println(sotrudnik);
  //for (Employee sotrudnik:massivSotrudnikov)
  // System.out.println("спис сотр " + sotrudnik);

  private static void printFamilii() {
    for (Employee fio : massivSotrudnikov) {
      System.out.println(fio.getFullname());
    }
  }

  private static float sredSalary() {
   /* float sum = 0;
    for (Employee sotrudnik : massivSotrudnikov) {
      sum = sum + sotrudnik.getSalary();
    }
    float srednya = sum / massivSotrudnikov.length;
    */
    float srednya = sumSalars() / massivSotrudnikov.length;
    return srednya;
  }

  private static Employee sotrudnikMaxSalary() {
    Employee sotrMaxSalary = null;
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrMaxSalary == null || sotrudnik.getSalary() > sotrMaxSalary.getSalary()) {
        sotrMaxSalary = sotrudnik;
      }
    }
    return sotrMaxSalary;
  }

  private static Employee sotrudnikMinSalary() {
    Employee sotrMinSalary = null;
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrMinSalary == null || sotrudnik.getSalary() < sotrMinSalary.getSalary()) {
        sotrMinSalary = sotrudnik;
      }
    }
    return sotrMinSalary;
  }

  private static int sumSalars() {
    int sum = 0;
    for (Employee sotrudnik : massivSotrudnikov) {
      sum = sum + sotrudnik.getSalary();
    }
    return sum;
  }


  private static Employee[] massivSotrudnikov = new Employee[10];

  private static Random random = new Random();
  private static String[] name = {"Иван", "Сергей", "Петр", "Максим", "Олег"};
  private static String[] familiya = {"Иванов", "Сергеев", "Петров", "Максимов", "Олегов"};
  private static String[] otchestvo = {"Иванович", "Сергеевич", "Петрович", "Олегович"};

  private static void vvodSotrudnikov() {
    for (int i = 0; i < massivSotrudnikov.length; i++) {
      String fullname = familiya[random.nextInt(0, familiya.length)] + " "
          + name[random.nextInt(0, name.length)] + " "
          + otchestvo[random.nextInt(0, otchestvo.length)];
      massivSotrudnikov[i] = new Employee(fullname, random.nextInt(1, 6),
          random.nextInt(50000, 100000));
    }
  }

  private static void printSotrudnikov() {
    for (int i = 0; i < massivSotrudnikov.length; i++) {
      String sotrudnik = String.valueOf(massivSotrudnikov[i]);
      System.out.println(sotrudnik);
      //for (Employee sotrudnik:massivSotrudnikov)
      // System.out.println("спис сотр " + sotrudnik);
    }
  }

  public static int IndexSalaryAll(int procent) {
    int newSalary = 0;
    System.out.println("Зарплата проиндексированная на : " + procent + " процентов : ");
    for (Employee sotrudnik : massivSotrudnikov) {
      newSalary = sotrudnik.getSalary() + sotrudnik.getSalary() * procent / 100;
      sotrudnik.setSalary(newSalary);

      System.out.println(sotrudnik.getFullname() + " : " + sotrudnik.getSalary());

    }
    return newSalary;
  }

  public static int IndexSalaryOtdel(int procent, int otdel) {
    int newSalary = 0;
    System.out.println("Зарплата сотрудников " + otdel + " отдела" +
        " проиндексированная на : " + procent + " процентов : ");
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik.getOtdel() == otdel) {
        newSalary = sotrudnik.getSalary() + sotrudnik.getSalary() * procent / 100;
        sotrudnik.setSalary(newSalary);

        System.out.println(sotrudnik.getFullname() + " : " + sotrudnik.getSalary());
      }
    }
    return newSalary;
  }

  public static void sotrudnikiOtdela(int otdel) {
    //String spisok = "Списочек";
    System.out.println("Сотрудники " + otdel + " отдела");
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik.getOtdel() == otdel) {
        System.out.println(sotrudnik.getId() +" "+ sotrudnik.getFullname() +" "+
            sotrudnik.getSalary());

      }
    }
  }

  public static void sravniSalary(int zp) {
    for (Employee sotrudnik : massivSotrudnikov) {
      if (sotrudnik.getSalary() < zp) {
        System.out.println("Зарплата сотрудника меньше: " +zp+ ":" + sotrudnik.getId() + " " +
            sotrudnik.getFullname() + " " + sotrudnik.getSalary());
      } else {
        System.out.println("Зарплата сотрудника больше " +zp+ ": " + sotrudnik.getId() + " " +
            sotrudnik.getFullname() + " " + sotrudnik.getSalary());
      }
    }
  }




}
