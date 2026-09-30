import java.util.Scanner;

public class CanteenBillingCounter {

    static abstract class Customer {
        protected double amount;

        public Customer(double amount) {
            this.amount = amount;
        }

        public abstract double calculateFinalAmount();

        public abstract String getType();
    }

    static class Student extends Customer {

        public Student(double amount) {
            super(amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 0.90;
        }

        @Override
        public String getType() {
            return "STUDENT";
        }
    }

    static class Staff extends Customer {

        public Staff(double amount) {
            super(amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 0.95;
        }

        @Override
        public String getType() {
            return "STAFF";
        }
    }

    static class Guest extends Customer {

        public Guest(double amount) {
            super(amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount + 10;
        }

        @Override
        public String getType() {
            return "GUEST";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {

            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {

                case "STUDENT":
                    customers[i] = new Student(amount);
                    break;

                case "STAFF":
                    customers[i] = new Staff(amount);
                    break;

                case "GUEST":
                    customers[i] = new Guest(amount);
                    break;
            }
        }

        double total = 0;

        for (Customer customer : customers) {

            double finalAmount =
                    customer.calculateFinalAmount();

            System.out.printf(
                    "%s: %.2f%n",
                    customer.getType(),
                    finalAmount
            );

            total = total + finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}