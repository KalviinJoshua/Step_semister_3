import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int k = 0;

        for (int i = 0; i < n; i++) {
            if (k == 0 || a[i] != a[k - 1])
                a[k++] = a[i];
        }

        System.out.println("Length: " + k);
        System.out.println(Arrays.toString(Arrays.copyOf(a, k)));
    }
}