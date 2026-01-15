import java.util.*;
import java.util.regex.Pattern;

interface StudentOperations {
    void addStudent(Student student);
    void displayStudents();
    void searchStudent(String studentId);
    void removeStudent(String studentId);
}

class Student {
    String studentId;
    String name;
    String course;
    int marks;

    Student(String studentId, String name, String course, int marks) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    void display() {
        System.out.println(studentId + " " + name + " " + course + " " + marks);
    }
}

public class UniversityStudentManagementSystem implements StudentOperations {

    private List<Student> studentList = new ArrayList<>();
    private Vector<Student> studentVector = new Vector<>();
    private Stack<Student> studentStack = new Stack<>();

    private HashMap<String, Student> studentHashMap = new HashMap<>();
    private Hashtable<String, Student> studentHashtable = new Hashtable<>();
    private TreeMap<String, Student> studentTreeMap = new TreeMap<>();

    private Set<String> courseSet = new HashSet<>();

    static boolean validateStudentId(String id) {
        return Pattern.matches("STU[0-9]{3}", id);
    }

    public void addStudent(Student student) {
        if (studentHashMap.containsKey(student.studentId)) {
            System.out.println("Duplicate entry not allowed");
            return;
        }

        studentList.add(student);
        studentVector.add(student);
        studentStack.push(student);

        studentHashMap.put(student.studentId, student);
        studentHashtable.put(student.studentId, student);
        studentTreeMap.put(student.studentId, student);

        courseSet.add(student.course);
    }

    public void displayStudents() {
        for (Student s : studentTreeMap.values()) {
            s.display();
        }
    }

    public void searchStudent(String studentId) {
        Student s = studentHashMap.get(studentId);
        if (s != null)
            s.display();
        else
            System.out.println("Student not found");
    }

    public void removeStudent(String studentId) {
        Student s = studentHashMap.remove(studentId);

        if (s != null) {
            studentHashtable.remove(studentId);
            studentTreeMap.remove(studentId);
            studentList.remove(s);
            studentVector.remove(s);
            studentStack.remove(s);
        } else {
            System.out.println("Student not found");
        }
    }

    void sortStudentsByMarks() {
        studentList.sort((a, b) -> b.marks - a.marks);
        for (Student s : studentList) {
            s.display();
        }
    }

    void convertHashMapToTreeMap() {
        TreeMap<String, Student> convertedMap = new TreeMap<>(studentHashMap);
        for (Student s : convertedMap.values()) {
            s.display();
        }
    }

    void countStudentsCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Student s : studentList) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }

        for (String course : countMap.keySet()) {
            System.out.println(course + " : " + countMap.get(course));
        }
    }

    void displayAllCourses() {
        for (String course : courseSet) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UniversityStudentManagementSystem system = new UniversityStudentManagementSystem();

        while (true) {
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                if (choice == 1) {
                    String id = sc.nextLine();
                    String name = sc.nextLine();
                    String course = sc.nextLine();
                    int marks = sc.nextInt();

                    if (!validateStudentId(id)) {
                        System.out.println("Invalid Student ID");
                        continue;
                    }

                    system.addStudent(new Student(id, name, course, marks));
                } 
                else if (choice == 2) {
                    system.displayStudents();
                } 
                else if (choice == 3) {
                    String id = sc.nextLine();
                    system.removeStudent(id);
                } 
                else if (choice == 4) {
                    String id = sc.nextLine();
                    system.searchStudent(id);
                } 
                else if (choice == 5) {
                    system.sortStudentsByMarks();
                } 
                else if (choice == 6) {
                    system.convertHashMapToTreeMap();
                } 
                else if (choice == 7) {
                    system.countStudentsCourseWise();
                } 
                else if (choice == 8) {
                    system.displayAllCourses();
                } 
                else if (choice == 9) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
