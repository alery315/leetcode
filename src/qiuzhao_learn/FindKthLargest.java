package qiuzhao_learn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author alery
 * @Description
 * @create 2020-07-28 16:56
 */
public class FindKthLargest {

    private static Random random = new Random(System.currentTimeMillis());

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(len, (a, b) -> b - a);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            int t;
            t = priorityQueue.peek();
            if (nums[i] > t) {
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }



    // 在区间 [left, right] 这个区间执行 partition 操作

    private int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int pivot_index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                pivot_index++;
                swap(nums, pivot_index, i);
            }
        }
        swap(nums, left, pivot_index);
        return pivot_index;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
//        System.out.println(findKthLargest(nums, 4));
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest2(nums, 4));

    }

}
