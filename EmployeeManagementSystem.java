import java.util.ArrayList;
import java.util.Scanner;

// Employee class
class Employee {
    int id;
    String name;
    String department;

    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    void display() {
        System.out.println(id + "\t" + name + "\t" + department);
    }
}

// Main class
public class EmployeeManagementSystem {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // Add employee
    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        employees.add(new Employee(id, name, dept));
        System.out.println("Employee added successfully!");
    }

    // View employees
    static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("ID\tName\tDepartment");
        for (Employee e : employees) {
            e.display();
        }
    }

    // Search employee
    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Employee Found:");
                System.out.println("ID\tName\tDepartment");
                e.display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Delete employee
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                employees.remove(e);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
