import java.util.*;

public class InsertPositionInSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int target = sc.nextInt(), l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] == target) {
                System.out.println(mid);
                return;
            }
            if (a[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        System.out.println(l);
    }
}