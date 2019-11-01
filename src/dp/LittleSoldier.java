package dp;

public class LittleSoldier {

    public static int fun(int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }

        if (n == 1 || m == 1) {
            return 1;
        }

        return fun(n - 1, m) + fun(n , m - 1) +
                fun(n - 2, m) + fun(n, m - 2);
    }


    public static void main(String[] args) {

        System.out.println(fun(2, 3));

    }

}
