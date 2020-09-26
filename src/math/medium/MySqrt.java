package math.medium;

import com.sun.corba.se.spi.ior.iiop.IIOPFactories;

/**
 * @auther alery
 * @create 2019-11-20 22:41
 */
public class MySqrt {

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }


    public int mySqrt2(int x) {
        long l = 0, r = 999999999;

        while (l < r) {
            // 这个写法很重要,可以选择右中位数(相对大的那个)
            long mid = (l + r + 1) >>> 1;
            long temp = mid * mid;
            System.out.println(l + " : " + r + " : " + temp);
            if (temp < x) {
                l = mid;
            } else if (temp > x) {
                r = mid - 1;
            } else {
                return (int) mid;
            }
        }
        return (int) r;
    }

    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double x1 = x / 2.0;
        for (int i = 0; i < 99999999; i++) {

            double x2 = (x1 + (x / x1)) / 2;
            System.out.println(x1 + " : " + x2);
            if (x1 - x2 < 0.01) {
                return (int) x2;
            }
            x1 = x2;
        }
        return 0;
    }

    public int sqrt3(int x) {
        if (x == 0) {
            return 0;
        }
        double y1 = x / 2.0;
        while (true) {
            double y2 = (2 * y1 + x / (y1 * y1)) / 3;
            if (y1 - y2 < 1e-3) {
                return (int) y2;
            }
            y1 = y2;
        }
    }

    public int sqrts(double x, double s) {
        if (x == 0) return 0;
        double e = 1e-3;
        double res = (x + s / x) / 2;
        System.out.println(res * res);
        if (res * res - s < e) {
            return (int) res;
        } else {
            return sqrts(res, s);
        }

    }


    public static void main(String[] args) {

//        System.out.println(new MySqrt(1).mySqrt2(2147395599));
        System.out.println(new MySqrt().sqrt3(65));
    }

}
