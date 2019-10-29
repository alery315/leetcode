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

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-24}));

    }


}
