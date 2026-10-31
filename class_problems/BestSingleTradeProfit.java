import java.util.*;

public class BestSingleTradeProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), min = Integer.MAX_VALUE, profit = 0;

        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }

        System.out.println(profit);
    }
}