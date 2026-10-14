import java.util.Scanner;
abstract class Parcel {
    protected double weight;
    protected double declaredValue;
    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }
    abstract double calculateCharge();
    double calculateInsurance() {
        return 0.0;
    }
    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}
interface Insurable {
    double calculateInsurance();
}
class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    @Override
    double calculateCharge() {
        return 40 + 10 * weight;
    }
}
class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    @Override
    double calculateCharge() {
        return 80 + 15 * weight;
    }
    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}
class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    @Override
    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }
    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}
public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        String[] types = new String[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            types[i] = type;
            switch (type) {
                case "STANDARD":
                    parcels[i] = new StandardParcel(weight, value);
                    break;
                case "EXPRESS":
                    parcels[i] = new ExpressParcel(weight, value);
                    break;
                case "FRAGILE":
                    parcels[i] = new FragileParcel(weight, value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid parcel type");
            }
        }
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            double charge = parcels[i].calculateCharge();
            double insurance = parcels[i].calculateInsurance();
            double total = parcels[i].calculateTotal();
            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types[i], charge, insurance, total
            );
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}