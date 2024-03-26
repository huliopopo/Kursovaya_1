public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee(1, "Иванов Иван Иванович", 33000);
        employees[1] = new Employee(2, "Ширяев Дональд Геннадиевич", 35000);
        employees[2] = new Employee(3, "Копылов Митрофан Авдеевич", 25000);
        employees[3] = new Employee(4, "Кудряшов Клим Эдуардович", 45000);
        employees[4] = new Employee(5, "Самойлов Мирон Иванович", 61000);
        employees[5] = new Employee(1, "Афанасьев Платон Аркадьевич", 31000);
        employees[6] = new Employee(2, "Пестов Евгений Ефимович", 29000);
        employees[7] = new Employee(3, "Воробьёв Ярослав Парфеньевич", 46000);
        employees[8] = new Employee(4, "Макаров Тарас Германович", 75000);
        employees[9] = new Employee(5, "Максимов Аскольд Дмитрьевич", 37000);
        printAllEmployees();
        System.out.println("salaryPerMonth() = " + salaryPerMonth());
        System.out.println("findMinSalaryEmployee() = " + findMinSalaryEmployee());
        System.out.println("findMaxSalaryEmployee() = " + findMaxSalaryEmployee());
        System.out.println("averageSalary() = " + averageSalary());
        printAllEmployeesNames();
        raiseAllSalary(1.10);
        printAllEmployees();
        int dep = 5; // Номер отдела по которому будет осуществлятся поиск
        System.out.println("Сотрудник с минимальной ЗП в отделе " + dep + ":\n" + findMinSalaryEmployeeByDepartment(dep));
        System.out.println("Сотрудник с максимальной ЗП в отделе " + dep + ":\n" + findMaxSalaryEmployeeByDepartment(dep));
        System.out.println("salaryPerMonthByDepartment(dep) = " + salaryPerMonthByDepartment(dep));
        System.out.println("averageSalaryByDepartment(dep) = " + averageSalaryByDepartment(dep));
        indexAllSalaryInDep(dep, 1.10);
        printAllEmployeesInDepWithoutDep(dep);
        int number = 40000;
        printAllEmployeesWithLowerSalaries(number);
        printAllEmployeesWithHigherOrEqualSalaries(number);

    }

    public static void printAllEmployees() {
        System.out.println("Массив сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public static int salaryPerMonth() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static Employee findMinSalaryEmployee() {
        int minSum = employees[0].getSalary();
        Employee employeeMinSalary = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < minSum) {
                minSum = employees[i].getSalary();
                employeeMinSalary = employees[i];
            }
        }
        return employeeMinSalary;
    }

    public static Employee findMaxSalaryEmployee() {
        int maxSum = 0;
        Employee employeeMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSum) {
                maxSum = employee.getSalary();
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    public static int averageSalary() {
        return salaryPerMonth() / employees.length;
    }

    public static void printAllEmployeesNames() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName());
        }
    }

    public static void raiseAllSalary(double k) {
        for (int i = 0; i < employees.length; i++) {
            int salary;
            salary = (int) (employees[i].getSalary() * k);
            employees[i].setSalary(salary);
        }
    }

    public static Employee findMinSalaryEmployeeByDepartment(int department) {
        Employee minSalaryEmployeeByDepartment = employees[0];
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department && employees[i].getSalary() < minSum) {
                minSum = employees[i].getSalary();
                minSalaryEmployeeByDepartment = employees[i];
            }
        }
        return minSalaryEmployeeByDepartment;
    }

    public static Employee findMaxSalaryEmployeeByDepartment(int department) {
        int maxSum = 0;
        Employee maxSalaryEmployeeByDepartment = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department && employees[i].getSalary() > maxSum) {
                maxSum = employees[i].getSalary();
                maxSalaryEmployeeByDepartment = employees[i];
            }
        }
        return maxSalaryEmployeeByDepartment;
    }

    public static int salaryPerMonthByDepartment(int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public static int averageSalaryByDepartment(int department) {
        int sum = 0;
        int numberOfEmployeesInDep = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
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

    public static void indexAllSalaryInDep(int department, double k) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                int salary;
                salary = (int) (employees[i].getSalary() * k);
                employees[i].setSalary(salary);
            }
        }
    }

    public static void printAllEmployeesInDepWithoutDep(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println("ФИО: " + employees[i].getName() + " ЗП:" + employees[i].getSalary());
//                Есть ли иной способ вывода всех полей объекта кроме одного? Чтобы не приходилось все поля перечислять
            }
        }
    }
    public static void printAllEmployeesWithLowerSalaries(int number) {
        System.out.println("Список сотрудников с ЗП меньше числа:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < number) {
                System.out.println(employees[i]);
            }
        }
    }
        public static void printAllEmployeesWithHigherOrEqualSalaries(int number) {
            System.out.println("Список сотрудников с ЗП больше числа:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= number) {
                System.out.println(employees[i]);
            }
        }
    }


}





