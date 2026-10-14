import java.util.Scanner;
abstract class ElectricityConnection {
    protected double units;
    ElectricityConnection(double units) {
        this.units = units;
    }
    abstract double calculateBill();
}
class HomeConnection extends ElectricityConnection {
    HomeConnection(double units) {
        super(units);
    }
    @Override
    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }
}
class ShopConnection extends ElectricityConnection {
    ShopConnection(double units) {
        super(units);
    }
    @Override
    double calculateBill() {
        return units * 8 + 100;
    }
}
class FactoryConnection extends ElectricityConnection {
    FactoryConnection(double units) {
        super(units);
    }
    @Override
    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}
public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ElectricityConnection[] connections =
            new ElectricityConnection[n];
        String[] types = new String[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            types[i] = type;
            switch (type) {
                case "HOME":
                    connections[i] = new HomeConnection(units);
                    break;
                case "SHOP":
                    connections[i] = new ShopConnection(units);
                    break;
                case "FACTORY":
                    connections[i] = new FactoryConnection(units);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid connection type");
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double bill = connections[i].calculateBill();
            System.out.printf("%s: %.2f%n", types[i], bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}