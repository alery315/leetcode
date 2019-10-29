package dp;

import java.awt.font.MultipleMaster;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Rob {

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(dp[1], dp[0] + nums[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + nums[i]), dp[i-3] + nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2,7,90,3,1,2,4,5}));

    }

}
