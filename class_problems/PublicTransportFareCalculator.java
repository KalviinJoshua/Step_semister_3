import java.util.Scanner;

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Transport[] transports = new Transport[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            types[i] = type;

            switch (type) {

                case "BUS":
                    transports[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    transports[i] = new Train(distance);
                    break;

                case "METRO":
                    double peakHourFactor = sc.nextDouble();

                    transports[i] =
                        new Metro(distance, peakHourFactor);
                    break;
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {

            double fare = transports[i].calculateFare();

            System.out.printf(
                "%s: %.2f%n",
                types[i],
                fare
            );

            total += fare;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}