package qiuzhao_learn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/22 22:56
 * @Version 1.0
 */

public class SmallestK {

    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() == k) {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            } else {
                queue.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nuims = {1, 3, 5, 7, 2, 4, 6, 8};
        new SmallestK().smallestK(nuims, 4);

    }

}
