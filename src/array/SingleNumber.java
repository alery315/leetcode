package array;

import java.util.Arrays;

/**
 * @Description
 * @auther alery
 * @create 2019-09-12 下午2:23
 */

public class SingleNumber {

    // 无敌版本,巧用异或
    // a ^ b ^ b = a
    // 0 ^ a = a
    // 而且题中重复的为出现两次
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber2(nums));


    }


}
