import java.util.*;

public class LibraryCatalogLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] isbn = new String[n], title = new String[n];

        for (int i = 0; i < n; i++) {
            isbn[i] = sc.next();
            title[i] = sc.next();
        }

        String target = sc.next();
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int cmp = isbn[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println(title[mid]);
                return;
            }
            if (cmp < 0) l = mid + 1;
            else r = mid - 1;
        }

        System.out.println("Not Found");
    }
}