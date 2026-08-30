import java.util.Arrays;
public class ThreeSum {
    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        int[][] tempResult = new int[nums.length * nums.length][3];
        int resultCount = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    tempResult[resultCount][0] = nums[i];
                    tempResult[resultCount][1] = nums[left];
                    tempResult[resultCount][2] = nums[right];
                    resultCount++;
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        int[][] result = new int[resultCount][3];
        for (int i = 0; i < resultCount; i++) {
            result[i] = tempResult[i];
        }
        return result;
    }
    static void printResult(int[][] result) {
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(
                    "[" + result[i][0] + ", " +
                    result[i][1] + ", " +
                    result[i][2] + "]"
            );
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[][] result = threeSum(nums);
        printResult(result);
    }
}