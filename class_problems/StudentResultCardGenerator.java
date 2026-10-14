import java.util.Scanner;
class Student {
    private String name;
    private int[] marks;
    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / 3.0;
    }
    char calculateGrade() {
        double average = calculateAverage();
        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
    void printResult() {
        System.out.printf(
            "%s: Average %.1f, Grade %c%n",
            name.toUpperCase(),
            calculateAverage(),
            calculateGrade()
        );
    }
}
public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) {
                marks[j] = sc.nextInt();
            }
            students[i] = new Student(name, marks);
        }
        for (Student student : students) {
            student.printResult();
        }
        sc.close();
    }
}