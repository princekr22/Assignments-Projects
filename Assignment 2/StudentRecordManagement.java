import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class Student {
    int rollNumber;
    String name;
    int marks;

    Student(int rollNumber, String name, int marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    void displayStudent() {
        System.out.println(rollNumber + " " + name + " " + marks);
    }
}

public class StudentRecordManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Student> studentList = new ArrayList<>();
        Vector<Student> studentVector = new Vector<>();

        while (true) {
            int choice = sc.nextInt();

            try {
                if (choice == 1) {
                    int roll = sc.nextInt();
                    String name = sc.next();
                    int marks = sc.nextInt();

                    Student student = new Student(roll, name, marks);
                    studentList.add(student);
                    studentVector.add(student);
                } 
                else if (choice == 2) {
                    for (Student s : studentList) {
                        s.displayStudent();
                    }
                } 
                else if (choice == 3) {
                    int roll = sc.nextInt();
                    boolean found = false;

                    for (Student s : studentList) {
                        if (s.rollNumber == roll) {
                            studentList.remove(s);
                            studentVector.remove(s);
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student not found");
                } 
                else if (choice == 4) {
                    int roll = sc.nextInt();
                    boolean found = false;

                    for (Student s : studentList) {
                        if (s.rollNumber == roll) {
                            s.displayStudent();
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student not found");
                } 
                else if (choice == 5) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
