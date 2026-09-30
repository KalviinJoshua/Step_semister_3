import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {

    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {

    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Delivery[] deliveries = new Delivery[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            types[i] = type;

            switch (type) {

                case "STANDARD":
                    deliveries[i] =
                        new StandardDelivery(weight, distance);
                    break;

                case "EXPRESS":
                    deliveries[i] =
                        new ExpressDelivery(weight, distance);
                    break;

                case "INTERNATIONAL":
                    double customsFee = sc.nextDouble();

                    deliveries[i] =
                        new InternationalDelivery(
                            weight,
                            distance,
                            customsFee
                        );
                    break;
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {

            double fee = deliveries[i].calculateFee();

            System.out.printf(
                "%s: %.2f%n",
                types[i],
                fee
            );

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}