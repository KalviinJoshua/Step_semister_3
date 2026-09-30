import java.util.Scanner;

public class FestivalBonusCalculator {

    static abstract class Employee {

        protected String name;
        protected double monthlySalary;

        public Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public abstract double calculateBonus();

        public String getName() {
            return name;
        }
    }

    static class FullTimeEmployee extends Employee {

        public FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return monthlySalary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {

        public PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return monthlySalary * 0.05;
        }
    }

    static class Intern extends Employee {

        public Intern(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return 2000;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            switch (type) {

                case "FULLTIME":
                    employees[i] =
                            new FullTimeEmployee(name, salary);
                    break;

                case "PARTTIME":
                    employees[i] =
                            new PartTimeEmployee(name, salary);
                    break;

                case "INTERN":
                    employees[i] =
                            new Intern(name, salary);
                    break;
            }
        }

        double totalBonus = 0;

        for (Employee employee : employees) {

            double bonus = employee.calculateBonus();

            System.out.printf(
                    "%s: %.2f%n",
                    employee.getName(),
                    bonus
            );

            totalBonus = totalBonus + bonus;
        }

        System.out.printf(
                "Total Bonus: %.2f%n",
                totalBonus
        );

        scanner.close();
    }
}