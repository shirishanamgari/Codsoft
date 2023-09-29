import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.println("Enter student details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Roll Number: ");
        int rollNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent() {
        System.out.print("Enter the roll number of the student to remove: ");
        int rollNumber = Integer.parseInt(scanner.nextLine());

        boolean removed = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                removed = true;
                System.out.println("Student removed successfully.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent() {
        System.out.print("Enter the roll number of the student to search: ");
        int rollNumber = Integer.parseInt(scanner.nextLine());

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        System.out.println("All students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void exit() {
        System.out.println("Exiting the Student Management System.");
        scanner.close();
        System.exit(0);
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.removeStudent();
                    break;
                case 3:
                    system.searchStudent();
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    system.exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
