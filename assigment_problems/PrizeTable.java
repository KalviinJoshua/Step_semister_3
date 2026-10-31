import java.util.*;

public class PrizeTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int max = i;

            for (int j = i + 1; j < n; j++)
                if (a[j] > a[max]) max = j;

            if (max != i) {
                int t = a[i];
                a[i] = a[max];
                a[max] = t;
                swaps++;
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println("Swaps: " + swaps);
    }
}