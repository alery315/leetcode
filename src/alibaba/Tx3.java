package alibaba;

import java.util.Scanner;

/**
 * @author alery
 * @Description
 * @create 2020-04-26 20:52
 */
public class Tx3 {

    public static int ret = Integer.MAX_VALUE;
    public static int n;
    public static int[] array_a;
    public static int[] array_b;

    public static void dfs(int pos, int cnt) {
        if (cnt >= 1000) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (judge()) {
                ret = Math.min(ret, cnt);
            }
            if (pos == i) {
                continue;
            }
            swap(i, i + 1);
            dfs(i, cnt + 1);
            swap(i, i + 1);
        }
    }

    public static void swap(int a, int b) {
        int temp = array_b[b];
        array_b[b] = array_a[a];
        array_a[a] = temp;
        temp = array_a[b];
        array_a[b] = array_b[a];
        array_b[a] = temp;
    }

    public static boolean judge() {
        for (int i = 0; i < n - 1; i++) {
            if (array_a[i] > array_a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        array_a = new int[n];
        array_b = new int[n];
        String s;
        String[] s_arr;
        s = sc.nextLine();
        s_arr = s.split(" ");
        for (int i = 0; i < n; i++) {
            array_a[i] = Integer.valueOf(s_arr[i]);
        }
        s = sc.nextLine();
        s_arr = s.split(" ");
        for (int i = 0; i < n; i++) {
            array_b[i] = Integer.valueOf(s_arr[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            swap(i, i + 1);
            dfs(i, 1);
            swap(i, i + 1);
        }
        System.out.println(ret);
    }
}
