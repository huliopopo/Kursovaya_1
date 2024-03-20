import java.util.Objects;

public class Employee {
    private int department;
    private final String name;
    private int salary;
    static int id;

    public Employee(int department, String name, int salary) {
        this.department = department;
        this.name = name;
        this.salary = salary;
        id++;
    }

    public int getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, name, salary);
    }

    @Override
    public String toString() {
        return "Отдел=" + department +
                ", ФИО='" + name + '\'' +
                ", Зарплата=" + salary;
    }
}




