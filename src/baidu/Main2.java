package baidu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-29 18:51
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }


        long res = 0;
        Arrays.sort(arr);
        int count_n = 0;
        while (count_n != n) {
            count_n = 0;
            arr[n - 1] -= n;
            count_n++;
            for (int i = 0; i < n - 1; i++) {
                arr[i] += 1;
                if (arr[i] < n) {
                    count_n++;
                }
            }
            Arrays.sort(arr);
            res++;
        }
        System.out.println(res);


    }


}
