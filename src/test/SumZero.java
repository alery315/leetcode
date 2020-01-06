package test;

import java.util.Arrays;

/**
 * @auther alery
 * @create 2020-01-03 15:01
 */
public class SumZero {

    public int[] sumZero(int n) {

        int count = n / -2;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count++;
        }
        res[n - 1] = n % 2 == 0 ? res[0] * -1 + res[n - 1] : res[n - 1];
        return res;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new SumZero().sumZero(6)));

    }

}
