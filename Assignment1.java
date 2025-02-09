// Employee class only holds employee data (SRP)
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

// Single Responsibility Principle(SRP)
class PayslipPrinter {
    public void print(Employee employee) {
        System.out.println("Employee: " + employee.getName() + ", Salary: $" + employee.getSalary());
    }
}

// different storage implementations (OCP)---OPEN for extension ,CLOSE for modification
interface EmployeeRepository {
    void save(Employee employee);
}

// Concrete implementation for saving to a database
class DatabaseEmployeeRepository implements EmployeeRepository {
    public void save(Employee employee) {
        System.out.println("Saving employee to database...");
    }
}

// Concrete implementation for saving to a file ,without modifying existing classes
class FileEmployeeRepository implements EmployeeRepository {
    public void save(Employee employee) {
        System.out.println("Saving employee to file...");
    }
}

// Main Class
public class Assignment1{
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ravi Kumar", 5000);
        Employee emp2 = new Employee("Hari", 5000);
        
        PayslipPrinter printer = new PayslipPrinter();
        printer.print(emp1);
        printer.print(emp2);

        EmployeeRepository dbRepository = new DatabaseEmployeeRepository(); 
        dbRepository.save(emp1);

         EmployeeRepository fileRepository = new DatabaseEmployeeRepository(); 
        fileRepository.save(emp1);
        fileRepository.save(emp2);
        
    }
}
