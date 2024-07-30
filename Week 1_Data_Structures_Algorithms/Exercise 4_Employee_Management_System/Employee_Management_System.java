import java.util.*;

public class Employee_Management_System {

    public static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static class EmployeeManager {
        private Employee[] employees;
        private int size;

        public EmployeeManager(int capacity) {
            employees = new Employee[capacity];
            size = 0;
        }

        public void addEmployee(Employee employee) {
            if (size < employees.length) {
                employees[size++] = employee;
            } else {
                System.out.println("Array is full. Cannot add more employees.");
            }
        }

        public Employee searchEmployeeById(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    return employees[i];
                }
            }
            return null;
        }

        public void deleteEmployeeById(int employeeId) {
            int indexToDelete = -1;
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    indexToDelete = i;
                    break;
                }
            }
            if (indexToDelete != -1) {
                for (int i = indexToDelete; i < size - 1; i++) {
                    employees[i] = employees[i + 1];
                }
                employees[--size] = null;
            } else {
                System.out.println("Employee not found.");
            }
        }

        public void traverseEmployees() {
            if (size == 0) {
                System.out.println("No employees to display.");
                return;
            }
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager(10);

        boolean running = true;

        while (running) {
            System.out.println("\nEmployee Management System:");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    manager.addEmployee(new Employee(id, name, position, salary));
                    System.out.println("Employee added.");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Employee foundEmployee = manager.searchEmployeeById(searchId);
                    System.out.println("Search Result: " + (foundEmployee != null ? foundEmployee : "Employee not found"));
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    manager.deleteEmployeeById(deleteId);
                    System.out.println("Employee deleted if found.");
                    break;

                case 4:
                    System.out.println("Displaying all employees:");
                    manager.traverseEmployees();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
