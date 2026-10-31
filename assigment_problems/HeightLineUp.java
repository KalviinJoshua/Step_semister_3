import java.util.*;

public class HeightLineUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int pass = 1;

        while (true) {
            boolean swapped = false;

            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass++ + ": " + Arrays.toString(a));

            if (!swapped) break;
        }
    }
}