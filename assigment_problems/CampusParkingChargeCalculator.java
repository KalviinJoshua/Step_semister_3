import java.util.Scanner;

public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        protected int hours;

        public Vehicle(int hours) {
            this.hours = hours;
        }

        public abstract double calculateCharge();

        public abstract String getType();
    }

    static class Bike extends Vehicle {

        public Bike(int hours) {
            super(hours);
        }

        @Override
        public double calculateCharge() {
            return hours * 10;
        }

        @Override
        public String getType() {
            return "BIKE";
        }
    }

    static class Car extends Vehicle {

        public Car(int hours) {
            super(hours);
        }

        @Override
        public double calculateCharge() {

            if (hours == 1) {
                return 30;
            }

            return 30 + (hours - 1) * 20;
        }

        @Override
        public String getType() {
            return "CAR";
        }
    }

    static class Truck extends Vehicle {

        public Truck(int hours) {
            super(hours);
        }

        @Override
        public double calculateCharge() {

            double charge = hours * 50;

            if (charge < 100) {
                charge = 100;
            }

            return charge;
        }

        @Override
        public String getType() {
            return "TRUCK";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            String type = scanner.next();
            int hours = scanner.nextInt();

            switch (type) {

                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;

                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;

                case "TRUCK":
                    vehicles[i] = new Truck(hours);
                    break;
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {

            double charge = vehicle.calculateCharge();

            System.out.printf(
                    "%s: %.2f%n",
                    vehicle.getType(),
                    charge
            );

            total = total + charge;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}