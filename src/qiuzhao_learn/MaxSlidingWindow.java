package qiuzhao_learn;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/1 22:50
 * @Version 1.0
 */

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        if (len < k || len == 0) return new int[0];
        if (k == 1) return nums;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            res[0] = Math.max(res[0], nums[i]);
        }
        for (int i = 1, j = k; j < len; i++, j++) {
            res[i] = Math.max(res[i - 1], nums[j]);
        }
        return res;
    }

    public static void main(String[] args) {

        new MaxSlidingWindow().maxSlidingWindow(new int[]{7, 2, 4}, 2);

    }


}
