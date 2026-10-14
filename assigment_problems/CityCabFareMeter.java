import java.util.Scanner;
abstract class Cab {
    protected double distance;
    Cab(double distance) {
        this.distance = distance;
    }
    abstract double getRatePerKm();
    double calculateFare() {
        return Math.max(100.0, distance * getRatePerKm());
    }
}
interface NightService {
    default double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}
class MiniCab extends Cab {
    MiniCab(double distance) {
        super(distance);
    }
    @Override
    double getRatePerKm() {
        return 10.0;
    }
}
class SedanCab extends Cab implements NightService {
    SedanCab(double distance) {
        super(distance);
    }
    @Override
    double getRatePerKm() {
        return 14.0;
    }
}
class SUVCab extends Cab implements NightService {
    SUVCab(double distance) {
        super(distance);
    }
    @Override
    double getRatePerKm() {
        return 18.0;
    }
}
public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] types = new String[n];
        String[] times = new String[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            types[i] = type;
            times[i] = time;
            switch (type) {
                case "MINI":
                    cabs[i] = new MiniCab(km);
                    break;
                case "SEDAN":
                    cabs[i] = new SedanCab(km);
                    break;
                case "SUV":
                    cabs[i] = new SUVCab(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            if (times[i].equals("NIGHT")
                    && !(cabs[i] instanceof NightService)) {
                System.out.println(
                    types[i] + ": night service not available"
                );
                continue;
            }
            double fare = cabs[i].calculateFare();
            if (times[i].equals("NIGHT")) {
                fare = ((NightService) cabs[i]).applyNightCharge(fare);
            }
            System.out.printf("%s: %.2f%n", types[i], fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}