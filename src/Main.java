public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee(11, "Ivan1", 1_000);
        employeeBook.addEmployee(12, "Ivan2", 2_000);
        employeeBook.addEmployee(13, "Ivan3", 3_000);
        employeeBook.printAllEmployees();
        System.out.println();

        employeeBook.deleteEmployee(2);
        employeeBook.printAllEmployees();
        System.out.println();

        employeeBook.addEmployee(14, "Ivan4", 4_000);
        employeeBook.printAllEmployees();
        employeeBook.printEmployeeById(2);
        employeeBook.printEmployeeById(4);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("salaryPerMonth() = " + employeeBook.salaryPerMonth());
        System.out.println("findMinSalaryEmployee() = " + employeeBook.findMinSalaryEmployee());
        System.out.println("findMaxSalaryEmployee() = " + employeeBook.findMaxSalaryEmployee());
        System.out.println("averageSalary() = " + employeeBook.averageSalary());
        employeeBook.printAllEmployeesNames();
        employeeBook.raiseAllSalary(1.10);
        employeeBook.printAllEmployees();
        int dep = 5; // Номер отдела по которому будет осуществлятся поиск
        System.out.println("Сотрудник с минимальной ЗП в отделе " + dep + ":\n" + employeeBook.findMinSalaryEmployeeByDepartment(dep));
        System.out.println("Сотрудник с максимальной ЗП в отделе " + dep + ":\n" + employeeBook.findMaxSalaryEmployeeByDepartment(dep));
        System.out.println("salaryPerMonthByDepartment(dep) = " + employeeBook.salaryPerMonthByDepartment(dep));
        System.out.println("averageSalaryByDepartment(dep) = " + employeeBook.averageSalaryByDepartment(dep));
        employeeBook.indexAllSalaryInDep(dep, 1.10);
        employeeBook.printAllEmployeesInDepWithoutDep(dep);
        int number = 40000;
        employeeBook.printAllEmployeesWithLowerSalaries(number);
        employeeBook.printAllEmployeesWithHigherOrEqualSalaries(number);

    }


}





