package bishi;

import java.time.temporal.Temporal;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/16 21:16
 * @Version 1.0
 */

public class Guanglianda1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int t = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            t = sc.nextInt();
            priorityQueue.add(t);
        }
        for (int i = 0; i < m; i++) {
            t = priorityQueue.poll() + x;
            priorityQueue.add(t);
        }
        System.out.println(priorityQueue.poll());

    }
}
