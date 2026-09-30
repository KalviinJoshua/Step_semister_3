import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {
        protected int units;

        public Room(int units) {
            this.units = units;
        }

        public abstract double calculateBill();

        public abstract String getType();
    }

    static class SingleRoom extends Room {

        public SingleRoom(int units) {
            super(units);
        }

        @Override
        public double calculateBill() {
            return units * 8;
        }

        @Override
        public String getType() {
            return "SINGLE";
        }
    }

    static class SharedRoom extends Room {

        private int occupants;

        public SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        public double calculateBill() {
            return (units * 6) / occupants;
        }

        @Override
        public String getType() {
            return "SHARED";
        }
    }

    static class ACRoom extends Room {

        public ACRoom(int units) {
            super(units);
        }

        @Override
        public double calculateBill() {
            return (units * 10) + 200;
        }

        @Override
        public String getType() {
            return "AC";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {

            String type = scanner.next();

            int units = scanner.nextInt();

            switch (type) {

                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;

                case "SHARED":
                    int occupants = scanner.nextInt();
                    rooms[i] = new SharedRoom(units, occupants);
                    break;

                case "AC":
                    rooms[i] = new ACRoom(units);
                    break;
            }
        }

        double total = 0;

        for (Room room : rooms) {

            double bill = room.calculateBill();

            System.out.printf(
                    "%s: %.2f%n",
                    room.getType(),
                    bill
            );

            total = total + bill;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}