import java.util.Scanner;
abstract class Plot {
    protected String owner;
    Plot(String owner) {
        this.owner = owner;
    }
    abstract double calculateArea();
}
class CirclePlot extends Plot {
    private double radius;
    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
class RectanglePlot extends Plot {
    private double length;
    private double width;
    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    @Override
    double calculateArea() {
        return length * width;
    }
}
class TrianglePlot extends Plot {
    private double base;
    private double height;
    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}
public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        String[] shapes = new String[n];
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            shapes[i] = shape;
            switch (shape) {
                case "CIRCLE":
                    plots[i] = new CirclePlot(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    plots[i] = new RectanglePlot(
                        owner, sc.nextDouble(), sc.nextDouble()
                    );
                    break;
                case "TRIANGLE":
                    plots[i] = new TrianglePlot(
                        owner, sc.nextDouble(), sc.nextDouble()
                    );
                    break;
                default:
                    throw new IllegalArgumentException("Invalid plot shape");
            }
        }
        double totalArea = 0;
        for (int i = 0; i < n; i++) {
            double area = plots[i].calculateArea();
            System.out.printf(
                "%s (%s): %.2f%n",
                plots[i].owner, shapes[i], area
            );
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}