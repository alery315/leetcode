package niuke;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-26 19:05
 */
public class Main12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];

        double res = 0d;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int flag = 1;
        for (int i = n - 1; i >= 0; i--) {
            res += array[i] * array[i] * flag;
            flag = -flag;
        }
        System.out.println(String.format("%.5f", res * Math.PI));


    }

}
