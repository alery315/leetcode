package offer;

/**
 * @author alery
 * @Description
 * @create 2020-06-15 17:16
 */
public class Fib {
    public long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long n_1 = 0, n_2 = 1;
        for (int i = 0; i < n - 1; i++) {
            long temp = n_2;
            n_2 = n_1 + n_2;
            n_1 = temp;
        }
        return n_2 % 1000000007;
    }

    public static void main(String[] args) {

        Fib fib = new Fib();
        System.out.println(fib.fib(48));
    }


}
