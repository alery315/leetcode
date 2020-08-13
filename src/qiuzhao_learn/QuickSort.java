package qiuzhao_learn;

/**
 * @author alery
 * @Description
 * @create 2020-07-28 19:26
 */

import sun.misc.Version;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static Random random = new Random(System.currentTimeMillis());
    public static int cnt = 0;

    public static int quickSort(int[] nums, int left, int right, int target) {
        if (right > left) {
            int random_index = left + 1 + random.nextInt(right - left);
            swap(nums, left, random_index);
        }
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] >= pivot && i < j) j--;
            if (i < j) nums[i] = nums[j];
            while (nums[i] <= pivot && i < j) i++;
            if (i < j) nums[j] = nums[i];
        }
        nums[i] = pivot;
        if (i > target && left <= i - 1) {
            return quickSort(nums, left, i - 1, target);
        } else if (i < target && i + 1 <= right) {
            return quickSort(nums, i + 1, right, target);
        } else {
            return pivot;
        }
//        quickSort(nums, left, i - 1, target);
//        quickSort(nums, i + 1, right, target);
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 5, 4, 6, 7};
        System.out.println(quickSort(nums, 0, nums.length - 1, nums.length - 2));
        System.out.println(Arrays.toString(nums));
//        System.out.println(cnt);
    }

}
