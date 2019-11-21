package math.medium;

/**
 * @auther alery
 * @create 2019-11-21 22:09
 */
public class MyPow {

    public double myPow(double x, int n) {
        double ans = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ans *= x;
            }
        } else {
            for (int i = 0; i < -n; i++) {
                ans /= x;
            }
        }
        return ans;
    }

    // 其实好像也不需要存储,这个想法太强了,快速幂思想
    public double myPow2(double x, int n) {
        if (n == 0) { return 1; }
        if (n == 1) { return x; }
        if (n == -1) { return 1 / x; }
        double half = myPow2(x, n / 2);
        double rest = myPow2(x, n % 2);
        return rest * half * half;
    }

    // 快速幂迭代写法
    public long binaryPow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
            b >>= 1;
        }
        return ans;
    }


    public static void main(String[] args) {

        long  startTime = System.currentTimeMillis();    //获取开始时间

        System.out.println(new MyPow().myPow2(2, 5));

        System.out.println(new MyPow().binaryPow(2, 10));

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }
}
