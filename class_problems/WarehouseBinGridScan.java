import java.util.*;

public class WarehouseBinGridScan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] a = new int[m][n];
        int total = 0, max = -1, row = 0, col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                total += a[i][j];

                if (a[i][j] > max) {
                    max = a[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("Total: " + total);
        System.out.println("MaxCoordinate: (" + row + ", " + col + ")");
    }
}