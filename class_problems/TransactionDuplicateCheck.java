import java.util.*;

public class TransactionDuplicateCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            if (!set.add(sc.next())) duplicate = true;
        }

        System.out.println(duplicate);
    }
}