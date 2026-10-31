import java.util.*;

public class SpiralOrderTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) System.out.print(a[top][j] + " ");
            top++;

            for (int i = top; i <= bottom; i++) System.out.print(a[i][right] + " ");
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) System.out.print(a[bottom][j] + " ");
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) System.out.print(a[i][left] + " ");
                left++;
            }
        }
    }
}