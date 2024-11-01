import java.util.Random;

public class Main {


  public static void main(String[] args) {
    EmployeeBook objectOfEmployeeBook= new EmployeeBook();
    objectOfEmployeeBook.vvodSotrudnikov();

    System.out.println("Полный список сотрудников: ");
    objectOfEmployeeBook.printSotrudnikov();
    System.out.println();

    objectOfEmployeeBook.delSotrudnika(1);
    System.out.println("Список после delSotrudnika");
    objectOfEmployeeBook.printSotrudnikov();

    objectOfEmployeeBook.insSotrudnika("СТЕПАНОВ СТЕПАН СТЕПАНОВИЧ", 3, 90000);
    System.out.println();

    System.out.println("Сумма затрат на зарплату в месяц: " + objectOfEmployeeBook.sumSalars());
    System.out.println("Сотрудник с минимальной зарплатой: " + objectOfEmployeeBook.sotrudnikMinSalary());
    System.out.println("Сотрудник с максимальной зарплатой: " + objectOfEmployeeBook.sotrudnikMaxSalary());
    System.out.println("Средняя зарплата: " + objectOfEmployeeBook.sredSalary());
    System.out.println();
    System.out.println("Ф.И.О. Сотрудников: ");
    objectOfEmployeeBook.printFamilii();
    System.out.println();

    objectOfEmployeeBook.IndexSalaryAll(10);
    System.out.println();

    objectOfEmployeeBook.IndexSalaryOtdel(15, 2);
    System.out.println();

    objectOfEmployeeBook.sotrudnikiOtdela(2);
    System.out.println();

    objectOfEmployeeBook.sravniSalary(80000);
    System.out.println();

    objectOfEmployeeBook.findPoId(4);


  }
}
