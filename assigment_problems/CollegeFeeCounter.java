import java.util.Scanner;
abstract class Student {
    protected String name;
    Student(String name) {
        this.name = name;
    }
    abstract double calculateTuition();
    double calculateExtraFees() {
        return 0.0;
    }
    double calculateTotalFee() {
        return calculateTuition() + calculateExtraFees();
    }
}
interface BusUser {
    default double getTransportFee() {
        return 12000.0;
    }
}
class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }
    @Override
    double calculateTuition() {
        return 40000.0;
    }
    @Override
    double calculateExtraFees() {
        return getTransportFee();
    }
}
class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }
    @Override
    double calculateTuition() {
        return 40000.0;
    }
    @Override
    double calculateExtraFees() {
        return 60000.0;
    }
}
class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }
    @Override
    double calculateTuition() {
        return 20000.0;
    }
    @Override
    double calculateExtraFees() {
        return getTransportFee();
    }
}
public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    students[i] = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }
        }
        double totalCollected = 0;
        for (Student student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}