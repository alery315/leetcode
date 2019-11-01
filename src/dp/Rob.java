package dp;

import java.awt.*;
import java.awt.font.MultipleMaster;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Rob {

    public static int[] result;

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        System.out.println("rob 1 is : " + Arrays.toString(dp));
        return dp[len - 1];
    }

    public static int solve(int idx, int[] nums) {
        if (idx < 0) return 0;
        if (result[idx] >= 0) return result[idx];
        result[idx] = Math.max(nums[idx] + solve(idx - 2, nums), solve(idx - 1, nums));
        System.out.println(Arrays.toString(result));
        return result[idx];
    }

    // 递归改为迭代方式
    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(nums[i] + result[i - 2],result[i - 1]);
        }
        System.out.println("rob2 is : " + Arrays.toString(result));
        return result[nums.length - 1];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 1, 2};

        result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        System.out.println(rob(nums));

        solve(nums.length - 1, nums);

        System.out.println(rob2(nums));

    }

}
