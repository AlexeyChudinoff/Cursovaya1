public class Main {

  public static void main(String[] args) {
    EmployeeBook objectOfEmployeeBook= new EmployeeBook();
    objectOfEmployeeBook.greatEmpioyee();
    System.out.println("Полный список сотрудников: ");
    objectOfEmployeeBook.printListEmployees();
    System.out.println();
    objectOfEmployeeBook.delEmployee(1);
    System.out.println("Список после delEmployee");
    objectOfEmployeeBook.printListEmployees();
    objectOfEmployeeBook.insEmployee("СТЕПАНОВ СТЕПАН СТЕПАНОВИЧ", 3, 90000);
    System.out.println();
    System.out.println("Сумма затрат на зарплату в месяц: " + objectOfEmployeeBook.calculatingSumSalary());
    System.out.println("Сотрудник с минимальной зарплатой: " + objectOfEmployeeBook.calculatingSotrudnikMinSalary());
    System.out.println("Сотрудник с максимальной зарплатой: " + objectOfEmployeeBook.calculatingSotrudnikMaxSalary());
    System.out.println("Средняя зарплата: " + objectOfEmployeeBook.calculatingAverageSalary());
    System.out.println();
    System.out.println("Ф.И.О. Сотрудников: ");
    objectOfEmployeeBook.printLastName();
    System.out.println();
    objectOfEmployeeBook.indexSalaryAll(10);
    System.out.println();
    objectOfEmployeeBook.indexSalaryOtdel(15, 2);
    System.out.println();
    objectOfEmployeeBook.printListOtdela(2);
    System.out.println();
    objectOfEmployeeBook.compareSalary(80000);
    System.out.println();
    objectOfEmployeeBook.findToId(4);
  }
}