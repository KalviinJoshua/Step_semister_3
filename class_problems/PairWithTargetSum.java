import java.util.*;

public class PairWithTargetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (set.contains(target - x)) found = true;
            set.add(x);
        }

        System.out.println(found);
    }
}