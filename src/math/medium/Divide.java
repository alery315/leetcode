package math.medium;

import java.sql.SQLOutput;

/**
 * @auther alery
 * @create 2019-12-12 21:59
 */
public class Divide {

    public int divide(int dividend, int divisor) {

        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;

        long res = 0;

        int positive = (dividend > 0) == (divisor > 0) ? 1 : -1;

//        System.out.println(positive);
        long t_dend = dividend;
        long t_sor = divisor;
        t_dend = Math.abs(t_dend);
        t_sor = Math.abs(t_sor);


        while (t_dend >= t_sor) {

            long temp = t_sor;
            int i = 1;

            while (temp <= t_dend) {
                res += i;
                t_dend -= temp;

                temp = temp << 1;
                i = i << 1;
            }

        }

        if (positive == -1) res = -res;


        return (int) Math.min(Math.max(res, min), max);
    }


    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648, -1));

    }

}
