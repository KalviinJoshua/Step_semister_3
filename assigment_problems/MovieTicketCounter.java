import java.util.Scanner;
abstract class Ticket {
    protected int count;
    private static final double CONVENIENCE_FEE = 20.0;
    Ticket(int count) {
        this.count = count;
    }
    abstract double getPrice();
    double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}
class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }
    @Override
    double getPrice() {
        return 150.0;
    }
}
class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }
    @Override
    double getPrice() {
        return 250.0;
    }
}
class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }
    @Override
    double getPrice() {
        return 400.0;
    }
}
public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Ticket[] tickets = new Ticket[n];
        String[] seats = new String[n];
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            seats[i] = seat;
            switch (seat) {
                case "REGULAR":
                    tickets[i] = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    tickets[i] = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    tickets[i] = new ReclinerTicket(count);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid seat type: " + seat
                    );
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double amount = tickets[i].calculateAmount();
            System.out.printf("%s: %.2f%n", seats[i], amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}