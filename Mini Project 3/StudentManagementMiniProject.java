import java.util.*;

class Student {
    int eno;
    String name;
    String branch;
    int sem;
    double percentage;

    Student(int eno, String name, String branch, int sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    void display() {
        System.out.println(eno + " " + name + " " + branch + " " + sem + " " + percentage);
    }
}

public class StudentManagementMiniProject {

    private static Map<Integer, Student> studentMap = new HashMap<>();

    static boolean login(Scanner sc) {
        String username = sc.next();
        String password = sc.next();
        return username.equals("admin") && password.equals("admin123");
    }

    static void addStudent(Scanner sc) {
        int eno = sc.nextInt();

        if (studentMap.containsKey(eno))
            throw new RuntimeException("Enrollment number already exists");

        String name = sc.next();
        String branch = sc.next();
        int sem = sc.nextInt();
        double percentage = sc.nextDouble();

        if (percentage <= 0)
            throw new RuntimeException("Percentage must be positive");

        if (branch.isEmpty())
            throw new RuntimeException("Branch cannot be empty");

        studentMap.put(eno, new Student(eno, name, branch, sem, percentage));
    }

    static void displayStudents() {
        for (Student s : studentMap.values()) {
            s.display();
        }
    }

    static void searchStudent(int eno) {
        Student s = studentMap.get(eno);
        if (s == null)
            throw new RuntimeException("Student not found");
        s.display();
    }

    static void updateStudentBranch(int eno, String branch) {
        if (branch.isEmpty())
            throw new RuntimeException("Branch cannot be empty");

        Student s = studentMap.get(eno);
        if (s == null)
            throw new RuntimeException("Student not found");

        s.branch = branch;
    }

    static void deleteStudent(int eno) {
        if (!studentMap.containsKey(eno))
            throw new RuntimeException("Student not found");

        studentMap.remove(eno);
    }

    static void displaySortedStudents() {
        List<Student> list = new ArrayList<>(studentMap.values());
        list.sort((a, b) -> Double.compare(b.percentage, a.percentage));

        for (Student s : list) {
            s.display();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (!login(sc)) {
            System.out.println("Invalid login");
            sc.close();
            return;
        }

        while (true) {
            int choice = sc.nextInt();

            try {
                if (choice == 1) {
                    addStudent(sc);
                } 
                else if (choice == 2) {
                    displayStudents();
                } 
                else if (choice == 3) {
                    searchStudent(sc.nextInt());
                } 
                else if (choice == 4) {
                    updateStudentBranch(sc.nextInt(), sc.next());
                } 
                else if (choice == 5) {
                    deleteStudent(sc.nextInt());
                } 
                else if (choice == 6) {
                    displaySortedStudents();
                } 
                else if (choice == 7) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
