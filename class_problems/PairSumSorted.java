import java.util.*;

public class PairSumSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int target = sc.nextInt(), l = 0, r = n - 1;

        while (l < r) {
            int sum = a[l] + a[r];

            if (sum == target) {
                System.out.println("(" + a[l] + ", " + a[r] + ")");
                return;
            }

            if (sum < target) l++;
            else r--;
        }

        System.out.println("Not Found");
    }
}