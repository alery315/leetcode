package qiuzhao_learn;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/1 20:26
 * @Version 1.0
 */

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {

        new MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});

    }
}
