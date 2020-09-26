package bishi;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @Desc:
 * @Author alery
 * @Date: 2020/9/12 16:41
 * @Version 1.0
 */

public class Wangyi4 {

    static int[][] map = new int[10000][10000];
//    static int[][] map = new int[10][10];
    static int[] visit = new int[10000];
//    static int[] visit = new int[10];
    static int[] link = new int[10000];
//    static int[] link = new int[10];

    static int find(int x) {
        int i;
        for (i = 0; i < 10000; i++) {
            if (map[x][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                if (link[i] == 0 || find(link[i])==1) {
                    link[i] = x;
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        int[] a = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            a[i] = Integer.valueOf(strings[i]);
        }

        strings = sc.nextLine().split(" ");
        int[] b = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            b[i] = Integer.valueOf(strings[i]);
        }
        int n = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < n; i++) {
            strings = sc.nextLine().split(" ");
            map[Integer.parseInt(strings[0])][Integer.parseInt(strings[1])] = 1;
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            visit = new int[10000];
            if (find(a[i]) == 1) {
                sum++;
            }
        }

        System.out.println(sum);

    }

}
