import java.util.*;
import java.util.regex.Pattern;

interface EmployeeOperations {
    void addEmployee(Employee employee);
    void displayEmployees();
    void searchEmployee(String employeeId);
    void removeEmployee(String employeeId);
}

class Employee {
    String employeeId;
    String name;
    String department;

    Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    void display() {
        System.out.println(employeeId + " " + name + " " + department);
    }
}

public class EmployeeRecordManagement implements EmployeeOperations {

    private HashMap<String, Employee> hashMap = new HashMap<>();
    private Hashtable<String, Employee> hashTable = new Hashtable<>();
    private TreeMap<String, Employee> treeMap = new TreeMap<>();

    static boolean validateEmployeeId(String id) {
        return Pattern.matches("EMP[0-9]{3}", id);
    }

    public void addEmployee(Employee employee) {
        hashMap.put(employee.employeeId, employee);
        hashTable.put(employee.employeeId, employee);
        treeMap.put(employee.employeeId, employee);
    }

    public void displayEmployees() {
        for (Employee e : treeMap.values()) {
            e.display();
        }
    }

    public void searchEmployee(String employeeId) {
        Employee e = hashMap.get(employeeId);
        if (e != null)
            e.display();
        else
            System.out.println("Employee not found");
    }

    public void removeEmployee(String employeeId) {
        hashMap.remove(employeeId);
        hashTable.remove(employeeId);
        treeMap.remove(employeeId);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeRecordManagement manager = new EmployeeRecordManagement();

        while (true) {
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                if (choice == 1) {
                    String id = sc.nextLine();
                    String name = sc.nextLine();
                    String dept = sc.nextLine();

                    if (!validateEmployeeId(id)) {
                        System.out.println("Invalid Employee ID");
                        continue;
                    }

                    Employee emp = new Employee(id, name, dept);
                    manager.addEmployee(emp);
                } 
                else if (choice == 2) {
                    manager.displayEmployees();
                } 
                else if (choice == 3) {
                    String id = sc.nextLine();
                    manager.searchEmployee(id);
                } 
                else if (choice == 4) {
                    String id = sc.nextLine();
                    manager.removeEmployee(id);
                } 
                else if (choice == 5) {
                    manager.hashMap.put(null, null);
                    System.out.println("HashMap supports null key and null value");
                    System.out.println("Hashtable does not support null key or value");
                } 
                else if (choice == 6) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
