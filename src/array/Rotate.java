package array;

import java.util.Arrays;

/**
 * @Description
 * @auther alery
 * @create 2019-09-10 下午8:50
 */

public class Rotate {

    private int i = 0;

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k % len == 0) {
            return;
        }
        int temp, previous;
        k = k % len;
        for (int i = 0; i < k; i++) {
            previous = nums[len - 1];
            for (int j = 0; j < len; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
//            System.out.println(Arrays.toString(nums));
        }

    }

    public static void rotate2(int[] nums, int k) {

        int temp;
        int previous;
        int count = 0;
        int len = nums.length;
        k = k % len;
        for (int i = 0, j; count < nums.length; i++) {
            j = i;
            previous = nums[i];
            do {
                temp = nums[(j + k) % len];
                nums[(j + k) % len] = previous;
                previous = temp;
                j = (j + k) % len;
                count++;
            } while (i != j);
        }

    }

    // 反转所有,反转前k个,反转后len-k个元素,即可
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }


    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        rotate3(nums, 3);

        System.out.println(Arrays.toString(nums));

    }


}
