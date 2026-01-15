import java.io.*;
import java.util.*;

class Employee {
    String id;
    String name;
    String department;
    double salary;

    Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    String toFileString() {
        return id + "," + name + "," + department + "," + salary;
    }

    void display() {
        System.out.println(id + " " + name + " " + department + " " + salary);
    }
}

public class EmployeeManagementSystem {

    private static final String FILE_NAME = "employees.txt";
    private static Map<String, Employee> employeeMap = new HashMap<>();

    static void loadFromFile() {
        employeeMap.clear();
        File file = new File(FILE_NAME);
        if (!file.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee emp = new Employee(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                );
                employeeMap.put(emp.id, emp);
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }

    static void saveToFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (Employee emp : employeeMap.values()) {
                fw.write(emp.toFileString() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error writing file");
        }
    }

    static void addEmployee(Scanner sc) {
        String id = sc.next();
        if (employeeMap.containsKey(id))
            throw new RuntimeException("Employee ID already exists");

        String name = sc.next();
        String dept = sc.next();
        double salary = sc.nextDouble();

        if (salary <= 0)
            throw new RuntimeException("Salary must be positive");

        if (dept.isEmpty())
            throw new RuntimeException("Department cannot be empty");

        employeeMap.put(id, new Employee(id, name, dept, salary));
        saveToFile();
    }

    static void displayEmployees() {
        for (Employee emp : employeeMap.values()) {
            emp.display();
        }
    }

    static void searchEmployee(String id) {
        Employee emp = employeeMap.get(id);
        if (emp == null)
            throw new RuntimeException("Employee not found");
        emp.display();
    }

    static void updateSalary(String id, double salary) {
        if (salary <= 0)
            throw new RuntimeException("Salary must be positive");

        Employee emp = employeeMap.get(id);
        if (emp == null)
            throw new RuntimeException("Employee not found");

        emp.salary = salary;
        saveToFile();
    }

    static void deleteEmployee(String id) {
        if (!employeeMap.containsKey(id))
            throw new RuntimeException("Employee not found");

        employeeMap.remove(id);
        saveToFile();
    }

    static void displaySortedEmployees() {
        List<Employee> list = new ArrayList<>(employeeMap.values());
        list.sort(Comparator.comparingDouble(e -> e.salary));
        for (Employee emp : list) {
            emp.display();
        }
    }

    static void displayDepartments() {
        Set<String> departments = new HashSet<>();
        for (Employee emp : employeeMap.values()) {
            departments.add(emp.department);
        }
        for (String d : departments) {
            System.out.println(d);
        }
    }

    static boolean login(Scanner sc) {
        String username = sc.next();
        String password = sc.next();
        return username.equals("admin") && password.equals("admin123");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (!login(sc)) {
            System.out.println("Invalid login");
            sc.close();
            return;
        }

        loadFromFile();

        while (true) {
            int choice = sc.nextInt();

            try {
                if (choice == 1) {
                    addEmployee(sc);
                } 
                else if (choice == 2) {
                    displayEmployees();
                } 
                else if (choice == 3) {
                    searchEmployee(sc.next());
                } 
                else if (choice == 4) {
                    updateSalary(sc.next(), sc.nextDouble());
                } 
                else if (choice == 5) {
                    deleteEmployee(sc.next());
                } 
                else if (choice == 6) {
                    displaySortedEmployees();
                } 
                else if (choice == 7) {
                    displayDepartments();
                } 
                else if (choice == 8) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
