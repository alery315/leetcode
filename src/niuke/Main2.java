package niuke;

import java.util.*;

/**
 * @author 丶Alery
 * @Description
 * @create 2020-03-15 19:54
 */
public class Main2 {
    public static void main(String[] args) {
        int n;
        int mode = 998244353;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long a = 2;
        long b = n - 1;
        long sum = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                sum = (sum * a) % mode;
                b--;
            }
            b /= 2;
            a = a * a % mode;
        }
        System.out.println((sum * n) % mode);

//        long temp = n;
////        long temp = 1;
//        for (int i = 0; i < n - 1; i++) {
//            temp *= 2;
//            temp %= mode;
//        }
//
//        System.out.println(temp);


    }
}
