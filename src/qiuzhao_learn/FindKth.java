package qiuzhao_learn;

import test.ReflectTest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/3 21:45
 * @Version 1.0
 */

public class FindKth {

    public int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(K);
        for (int i = 0; i < n; i++) {
            if (minHeap.size() >= K) {
                // 第k大，只有新来的大于顶点值，才进行替换
                if (a[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(a[i]);
                }
            } else {
                minHeap.add(a[i]);
            }
        }
        return minHeap.peek();
    }

    public int findKth2(int[] a, int n, int K) {
        return find(a, 0, n - 1, n - K);
    }

    public int find(int[] a, int low, int high, int K) {
        int pivot = quickSort(a, low, high);

        if (pivot < K)//中轴位置少于K个，在右子数组中继续查找
            return find(a, pivot + 1, high, K);
        else if (pivot > K)//中轴位置大于K个，在左子数组中继续查找
            return find(a, low, pivot - 1, K);
        else//中轴元素正好是第K大的元素
            return a[pivot];
    }

    public int quickSort(int[] a, int l, int r) {
        int p = a[l];
        while (l < r) {
            while (a[r] >= p && l < r) r--;
            a[l] = a[r];
            while (a[l] <= p && l < r) l++;
            a[r] = a[l];
        }
        a[l] = p;
        return l;
    }


    public static void main(String[] args) {
//        int a = new FindKth().findKth(new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663}, 49, 24);
        int a = new FindKth().findKth2(new int[]{4, 12, 5, 2, 9, 17}, 6, 3);
        System.out.println(a);
    }

}
