import java.util.*;

public class EmployeeIDLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(sc.next(), sc.next());

        String id = sc.next();
        System.out.println(map.getOrDefault(id, "Unknown"));
    }
}