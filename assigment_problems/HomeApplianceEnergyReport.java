import java.util.Scanner;
abstract class Appliance {
    protected double hours;
    Appliance(double hours) {
        this.hours = hours;
    }
    abstract double getPowerWatts();
    double calculateUnits() {
        return getPowerWatts() * hours / 1000.0;
    }
    double calculateCost() {
        return calculateUnits() * 8.0;
    }
}
interface SaverMode {
    default double reduceUnits(double units) {
        return units * 0.75;
    }
}
class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }
    @Override
    double getPowerWatts() {
        return 150.0;
    }
}
class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }
    @Override
    double getPowerWatts() {
        return 1500.0;
    }
}
class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }
    @Override
    double getPowerWatts() {
        return 100.0;
    }
}
class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }
    @Override
    double getPowerWatts() {
        return 500.0;
    }
}
public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Appliance[] appliances = new Appliance[n];
        String[] names = new String[n];
        boolean[] saverRequested = new boolean[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double hours = sc.nextDouble();
            boolean saver = false;
            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }
            names[i] = name;
            saverRequested[i] = saver;
            switch (name) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AirConditioner(hours);
                    break;
                case "TV":
                    appliances[i] = new Television(hours);
                    break;
                case "WASHER":
                    appliances[i] = new WashingMachine(hours);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid appliance type"
                    );
            }
        }
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            Appliance appliance = appliances[i];
            if (saverRequested[i]
                    && !(appliance instanceof SaverMode)) {
                System.out.println(
                    names[i] + ": saver mode not supported"
                );
                continue;
            }
            double units = appliance.calculateUnits();
            if (saverRequested[i]) {
                units = ((SaverMode) appliance).reduceUnits(units);
            }
            double cost = units * 8.0;
            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                names[i], units, cost
            );
            totalCost += cost;
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}