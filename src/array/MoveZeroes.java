package array;

import java.util.Arrays;

/**
 * @Description
 * @auther alery
 * @create 2019-09-12 下午3:54
 */

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int j;
                for (j = i + 1; j < len; j++) {
                    if (nums[j] != 0) {
                        break;
                    }
                }
                if (j != len) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int len = nums.length;
        int lastNoZeroPos = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastNoZeroPos];
                nums[lastNoZeroPos] = temp;
                lastNoZeroPos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));


    }

}
