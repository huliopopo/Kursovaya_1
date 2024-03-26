public class EmployeeBook {
    private Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[5];
    }

    public void addEmployee(int department, String name, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee newEmployee = new Employee(department, name, salary);
                employees[i] = newEmployee;
                break;
            } else if (i == employees.length - 1) {
                System.out.println("Список переполнен");
            }
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void printEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                System.out.println(employees[i]);
                break;
            } else if (i == employees.length - 1) {
                System.out.println("Сотрудник с id=" + id + " не найден");

            }
        }
    }


    public void printAllEmployees() {
        System.out.println("Массив сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public int salaryPerMonth() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public Employee findMinSalaryEmployee() {
        int minSum = Integer.MAX_VALUE;
        Employee employeeMinSalary = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSum) {
                minSum = employees[i].getSalary();
                employeeMinSalary = employees[i];
            }
        }
        return employeeMinSalary;
    }

    public Employee findMaxSalaryEmployee() {
        int maxSum = 0;
        Employee employeeMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSum) {
                maxSum = employee.getSalary();
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    public int averageSalary() {
        return salaryPerMonth() / employees.length;
    }

    public void printAllEmployeesNames() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getName());
            }
        }
    }

    public void raiseAllSalary(double k) {
        for (int i = 0; i < employees.length; i++) {
            int salary;
            if (employees[i] != null) {
                salary = (int) (employees[i].getSalary() * k);
                employees[i].setSalary(salary);
            }
        }
    }

    public Employee findMinSalaryEmployeeByDepartment(int department) {
        Employee minSalaryEmployeeByDepartment = employees[0];
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() < minSum) {
                minSum = employees[i].getSalary();
                minSalaryEmployeeByDepartment = employees[i];
            }
        }
        return minSalaryEmployeeByDepartment;
    }

    public Employee findMaxSalaryEmployeeByDepartment(int department) {
        int maxSum = 0;
        Employee maxSalaryEmployeeByDepartment = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() > maxSum) {
                maxSum = employees[i].getSalary();
                maxSalaryEmployeeByDepartment = employees[i];
            }
        }
        return maxSalaryEmployeeByDepartment;
    }

    public int salaryPerMonthByDepartment(int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public int averageSalaryByDepartment(int department) {
        int sum = 0;
        int numberOfEmployeesInDep = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
                numberOfEmployeesInDep++;
            }
        }
        if (numberOfEmployeesInDep != 0) {
            return sum / numberOfEmployeesInDep;
        } else {
            return 0;
        }

    }

    public void indexAllSalaryInDep(int department, double k) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                int salary;
                salary = (int) (employees[i].getSalary() * k);
                employees[i].setSalary(salary);
            }
        }
    }

    public void printAllEmployeesInDepWithoutDep(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println("ФИО: " + employees[i].getName() + " ЗП:" + employees[i].getSalary());
//                Есть ли иной способ вывода всех полей объекта кроме одного? Чтобы не приходилось все поля перечислять
            }
        }
    }

    public void printAllEmployeesWithLowerSalaries(int number) {
        System.out.println("Список сотрудников с ЗП меньше числа:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < number) {
                System.out.println(employees[i]);
            }
        }
    }

    public void printAllEmployeesWithHigherOrEqualSalaries(int number) {
        System.out.println("Список сотрудников с ЗП больше числа:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= number) {
                System.out.println(employees[i]);
            }
        }
    }
}
