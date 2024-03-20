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

}





