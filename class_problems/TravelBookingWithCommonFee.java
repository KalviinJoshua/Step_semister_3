import java.util.Scanner;
abstract class TravelBooking {
    protected double distanceKm;
    private static final double BOOKING_FEE = 50.0;
    TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }
    abstract double calculateBaseFare();
    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}
class BusBooking extends TravelBooking {
    BusBooking(double distanceKm) {
        super(distanceKm);
    }
    @Override
    double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}
class TrainBooking extends TravelBooking {
    TrainBooking(double distanceKm) {
        super(distanceKm);
    }
    @Override
    double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}
class FlightBooking extends TravelBooking {
    FlightBooking(double distanceKm) {
        super(distanceKm);
    }
    @Override
    double calculateBaseFare() {
        return 2500 + distanceKm * 4.0;
    }
}
public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];
        String[] modes = new String[n];
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            modes[i] = mode;
            switch (mode) {
                case "BUS":
                    bookings[i] = new BusBooking(distance);
                    break;
                case "TRAIN":
                    bookings[i] = new TrainBooking(distance);
                    break;
                case "FLIGHT":
                    bookings[i] = new FlightBooking(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf(
                "%s: %.2f%n",
                modes[i], bookings[i].calculateTotal());
        }
        sc.close();
    }
}