package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-25 14:23
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};

        System.out.println(new FindKthLargest().findKthLargest(nums, 4));

    }

}
