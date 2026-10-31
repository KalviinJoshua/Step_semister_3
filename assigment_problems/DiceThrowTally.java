import java.util.*;

public class DiceThrowTally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[7];

        for (int i = 0; i < n; i++)
            count[sc.nextInt()]++;

        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++)
            System.out.print(i + ":" + count[i] + " ");

        int[] result = new int[n];
        int k = 0;

        for (int i = 1; i <= 6; i++)
            for (int j = 0; j < count[i]; j++)
                result[k++] = i;

        System.out.println("\nSorted: " + Arrays.toString(result));
    }
}