import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    static abstract class Plan {

        protected String name;
        protected LocalDate startDate;

        public Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public abstract LocalDate calculateRenewalDate();

        public String getName() {
            return name;
        }
    }

    static class BasicPlan extends Plan {

        public BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(30);
        }
    }

    static class StandardPlan extends Plan {

        public StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(90);
        }
    }

    static class PremiumPlan extends Plan {

        public PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Plan[] plans = new Plan[n];

        for (int i = 0; i < n; i++) {

            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate =
                    LocalDate.parse(scanner.next());

            switch (type) {

                case "BASIC":
                    plans[i] =
                            new BasicPlan(name, startDate);
                    break;

                case "STANDARD":
                    plans[i] =
                            new StandardPlan(name, startDate);
                    break;

                case "PREMIUM":
                    plans[i] =
                            new PremiumPlan(name, startDate);
                    break;
            }
        }

        for (Plan plan : plans) {

            LocalDate renewalDate =
                    plan.calculateRenewalDate();

            System.out.println(
                    plan.getName() + ": " + renewalDate
            );
        }

        scanner.close();
    }
}