package dp;

import java.util.Arrays;

public class MaxSubArray {

    public static int maxSubArray(int[] nums) {

        int len = nums.length;
        if (len == 0) return 0;
        // dp table
        int[] sum = new int[len];

        // base case
        int ret = nums[0];
        sum[0] = nums[0];

        for (int i = 1; i < len; i++) {
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
            ret = Math.max(ret, sum[i]);
        }

        return ret;

    }

    public static int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ret = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ret = Math.max(dp[i], ret);
        }
        System.out.println(Arrays.toString(dp));
        return ret;
    }

    public static void main(String[] args) {

        System.out.println(maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }


}
